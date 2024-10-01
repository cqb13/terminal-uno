package dev.cqb13.game;

public class Game {
  int players;

  public Game(int players) {
    if (players >= 2 && players <= 10) {
      this.players = players;
    } else {
      throw new RuntimeException("Players must be between 2 and 10 inclusive");
    }
  }
}
