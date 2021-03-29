package hazae41.mumbler;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.Arrays;

class TextJoiner implements ComponentBuilder.Joiner {
  public final String separator;
  public final BaseComponent[][] elements;

  public TextJoiner(String separator, BaseComponent[]... elements) {
    this.separator = separator;
    this.elements = elements;
  }

  public static TextJoiner fromLegacy(String separator, String... legacyElements) {
    BaseComponent[][] elements = Arrays.stream(legacyElements)
            .map(TextComponent::fromLegacyText)
            .toArray(BaseComponent[][]::new);

    return new TextJoiner(separator, elements);
  }

  public static TextJoiner fromLegacyLines(String... legacyLines) {
    return fromLegacy("\n", legacyLines);
  }

  public BaseComponent[] toComponent() {
    return new ComponentBuilder().append(this).create();
  }

  @Override
  public ComponentBuilder join(ComponentBuilder builder, ComponentBuilder.FormatRetention retention) {
    boolean first = true;

    for (BaseComponent[] element : elements) {
      if (first) {
        builder.append(element);
        first = false;
      } else {
        builder.append(separator);
        builder.append(element);
      }
    }

    return builder;
  }
}