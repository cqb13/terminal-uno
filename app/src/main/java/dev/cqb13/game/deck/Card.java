package dev.cqb13.game.deck;

public enum Card {
  One(Color.Red),
  Two(Color.Red),
  Three(Color.Red),
  Four(Color.Red),
  Five(Color.Red),
  Six(Color.Red),
  Seven(Color.Red),
  Eight(Color.Red),
  Nine(Color.Red),
  Zero(Color.Red),
  Reverse(Color.Red),
  Skip(Color.Red),
  DrawTwo(Color.Red),
  DrawFour(Color.Wild),
  Wild(Color.Wild);

  private final Color color;

  Card(Color color) {
    this.color = color;
  }

  public Color color() {
    return color;
  }
}
