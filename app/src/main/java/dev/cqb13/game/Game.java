package dev.cqb13.game;

import dev.cqb13.game.deck.Deck;
import dev.cqb13.game.deck.Card;

public class Game {
  int players;
  Deck deck;
  Deck playedCards;

  public Game(int players) {
    if (players >= 2 && players <= 10) {
      this.players = players;
    } else {
      throw new RuntimeException("Players must be between 2 and 10 inclusive");
    }

    /*
     * An uno deck has 108 cards
     *
     * 25 cards for each color:
     * -- 1 zero and 2 for each number up to 9
     * -- 2 reverse cards
     * -- 2 skip cards
     * -- 2 draw 2 cards
     *
     * Additional cards:
     * -- 4 wild draw 4 cards
     * -- 4 wild cards
     */
    Deck deck = new Deck();

    // generate deck by adding cards in random order

    Deck playedCards = new Deck();

    Card takenCard = deck.takeCard();

    playedCards.addCard(takenCard);

    this.playedCards = playedCards;
  }
}
