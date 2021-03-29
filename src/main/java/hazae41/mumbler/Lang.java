package hazae41.mumbler;

class Langs {
  static Lang getLang(String locale) {
    String first = locale.split("_")[0];

    if (first.equals("en"))
      return new English();
    if (first.equals("fr"))
      return new French();
    if (first.equals("ca"))
      return new Spanish();
    if (first.equals("es"))
      return new Spanish();
    if (first.equals("pt"))
      return new Portuguese();
    if (first.equals("it"))
      return new Italian();
    if (first.equals("de"))
      return new German();
    if (first.equals("nl"))
      return new Dutch();
    if (first.equals("cs"))
      return new Czech();
    if (first.equals("ru"))
      return new Russian();
    if (first.equals("pl"))
      return new Polish();
    if (first.equals("ja"))
      return new Japanese();
    if (first.equals("ko"))
      return new Korean();
    if (first.equals("zh"))
      return new Chinese();

    return new English();
  }
}

public abstract class Lang {
  abstract String[] getWelcome();

  abstract String[] getSeenBy(String seens);
}

class English extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Only close players can see your chat messages",
            "You can shout by adding \"!\" at the end of your messages"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Seen by " + seens};
  }
}

class French extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Seuls les joueurs proches peuvent voir vos messages",
            "Vous pouvez crier en ajoutant \"!\" à la fin de vos messages"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Vu par " + seens};
  }
}

class Spanish extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Solo los jugadores cercanos pueden ver tus mensajes",
            "Puede gritar agregando \"!\" al final de tus mensajes"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Visto por " + seens};
  }
}

class Portuguese extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Apenas jogadores próximos podem ver suas mensagens de chat",
            "Você pode gritar adicionando \"!\" no final de suas mensagens"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Visto por " + seens};
  }
}

class Italian extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Solo i giocatori vicini possono vedere i tuoi messaggi di chat",
            "Puoi gridare aggiungendo \"!\" alla fine dei tuoi messaggi"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Visto da " + seens};
  }
}

class German extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Nur enge Spieler können Ihre Chat-Nachrichten sehen",
            "Sie können schreien, indem Sie \"!\" am Ende Ihrer Nachrichten"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Gesehen von " + seens};
  }
}

class Dutch extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Alleen goede spelers kunnen uw chatberichten zien",
            "U kunt schreeuwen door \"!\" aan het einde van uw berichten"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Gezien door " + seens};
  }
}

class Czech extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Vaše chatovací zprávy mohou vidět pouze blízcí hráči",
            "Můžete křičet přidáním „!“ na konci vašich zpráv"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Viděn " + seens};
  }
}

class Russian extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Только близкие игроки могут видеть ваши сообщения в чате",
            "Вы можете кричать, добавив \"!\" в конце ваших сообщений"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Увидев " + seens};
  }
}

class Polish extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "Tylko bliscy gracze mogą zobaczyć Twoje wiadomości na czacie",
            "Możesz krzyczeć, dodając „!” na końcu twoich wiadomości"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"Widziany przez " + seens};
  }
}

class Japanese extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "近くのプレイヤーだけがあなたのチャットメッセージを見ることができます",
            "「！」を追加すると叫ぶことができます。 メッセージの最後に"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"見た人 " + seens};
  }
}

class Korean extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "가까운 플레이어 만 채팅 메시지를 볼 수 있습니다.",
            "\"!\"를 추가하여 외칠 수 있습니다. 당신의 메시지 끝에"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"본 사람 " + seens};
  }
}

class Chinese extends Lang {
  @Override
  String[] getWelcome() {
    return new String[]{
            "只有近距离的玩家才能看到您的聊天消息",
            "您可以通过添加“！”来大喊。 在邮件末尾"
    };
  }

  @Override
  String[] getSeenBy(String seens) {
    return new String[]{"看过的人 " + seens};
  }
}
