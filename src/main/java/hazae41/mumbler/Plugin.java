package hazae41.mumbler;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT;
import static org.bukkit.event.EventPriority.*;

public class Plugin extends JavaPlugin implements Listener {
  @Override
  public void onEnable() {
    super.onEnable();

    getServer().getPluginManager().registerEvents(this, this);
  }

  private void registerLocaleChangeEvent(Consumer<PlayerLocaleChangeEvent> listener) {
    getServer().getPluginManager().registerEvents(new Listener() {
      @EventHandler(priority = MONITOR)
      public void onLocaleChange(PlayerLocaleChangeEvent e) {
        HandlerList.unregisterAll(this);
        listener.accept(e);
      }
    }, this);
  }

  @EventHandler(priority = MONITOR)
  public void onJoin(PlayerJoinEvent joinEvent) {
    registerLocaleChangeEvent(localeEvent -> {
      if (joinEvent.getPlayer() != localeEvent.getPlayer()) return;

      Lang lang = Langs.getLang(localeEvent.getLocale());

      ComponentBuilder.Joiner joiner = TextJoiner
              .fromLegacyLines(lang.getWelcome());

      BaseComponent[] text = new ComponentBuilder()
              .color(ChatColor.GRAY).append(joiner).create();

      joinEvent.getPlayer().spigot().sendMessage(text);
    });
  }

  @EventHandler(priority = NORMAL)
  public void onChat(AsyncPlayerChatEvent e) {
    Set<Player> recipients = new HashSet<>();
    boolean shouting = e.getMessage().endsWith("!");

    if (shouting)
      getServer().getScheduler().runTask(this,
              task -> e.getPlayer().damage(1.0));

    Location l = e.getPlayer().getLocation();
    Vector o = l.toVector();
    Vector u = l.getDirection();

    for (Player recipient : e.getRecipients()) {
      if (recipient == e.getPlayer()) continue;

      Location m = recipient.getLocation();
      Vector p = m.toVector();
      Vector v = m.getDirection();

      Vector d = p.clone().subtract(o); // vector from player to recipient
      Vector dn = d.clone().normalize(); // d but only the direction

      double uc = u.dot(dn); // goodness of player's direction (more important) (+/-1)
      double vc = v.dot(dn) / 4; // goodness of recipient's direction (less important) (+/-0.25)

      double lever = uc - vc; // overall goodness (+/-1.25)
      double blocks = lever * 20; // blocks gained or loss (+/-25)

      double pdistance = d.length(); // player distance (blocks)
      double sdistance = 75 + blocks; // sound distance (blocks) (50 to 100)

      if (shouting) sdistance *= 2; // 100 to 200 blocks

      // if distance is good, the recipient hears
      if (pdistance < sdistance) recipients.add(recipient);
    }

    e.getRecipients().clear();
    e.getRecipients().add(e.getPlayer());
    e.getRecipients().addAll(recipients);
  }

  @EventHandler(priority = HIGHEST)
  public void onChatted(AsyncPlayerChatEvent e) {
    String msg = String.format(e.getFormat(),
            e.getPlayer().getDisplayName(), e.getMessage());

    String seens = e.getRecipients().stream()
            .map(Player::getDisplayName)
            .collect(Collectors.joining(", "));

    for (Player recipient : e.getRecipients()) {
      Lang lang = Langs.getLang(recipient.getLocale());

      BaseComponent[] hoverText = TextJoiner
              .fromLegacyLines(lang.getSeenBy(seens))
              .toComponent();

      HoverEvent hoverEvent = new HoverEvent(SHOW_TEXT, new Text(hoverText));

      BaseComponent[] text = new ComponentBuilder()
              .appendLegacy(msg).event(hoverEvent).create();

      recipient.spigot().sendMessage(text);
    }

    e.setCancelled(true);
  }
}
