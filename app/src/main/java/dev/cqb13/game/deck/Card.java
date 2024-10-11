package dev.cqb13.game.deck;

public class Card {
  public enum Color {
    Red, Blue, Green, Yellow, Wild
  }

  public enum Type {
    Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Reverse, Skip, DrawTwo, Wild, DrawFour
  }

  private Type type;
  private Color color;

  public Card(Type type, Color color) {
    this.type = type;
    this.color = color;
  }

  public static Type fromNumber(int number) {
    switch (number) {
      case 1:
        return Type.One;
      case 2:
        return Type.Two;
      case 3:
        return Type.Three;
      case 4:
        return Type.Four;
      case 5:
        return Type.Five;
      case 6:
        return Type.Six;
      case 7:
        return Type.Seven;
      case 8:
        return Type.Eight;
      case 9:
        return Type.Nine;
      default:
        throw new IllegalArgumentException("Invalid number");
    }
  }
}
