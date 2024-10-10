
package dev.cqb13.game.deck;

public class Card {
  public enum Type {
    One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero,
    Reverse, Skip, DrawTwo, DrawFour, Wild
  }

  public enum Color {
    Red, Blue, Green, Yellow, Wild
  }

  private Type type;
  private Color color;

  public Card(Type type, Color color) {
    this.type = type;
    this.color = color;
  }

  public Type getType() {
    return type;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public String toString() {
    return "Card{" +
        "type=" + type +
        ", color=" + color +
        '}';
  }
}
