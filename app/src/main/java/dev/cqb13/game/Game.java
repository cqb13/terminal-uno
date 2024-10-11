package dev.cqb13.game;

import dev.cqb13.game.deck.Card.Color;
import dev.cqb13.game.deck.Card;
import dev.cqb13.game.deck.Deck;

import java.util.Collections;
import java.util.List;

public class Game {
  private int players;
  private Deck deck;
  private Deck playedCards;

  public Game(int players) {
    if (players >= 2 && players <= 10) {
      this.players = players;
    } else {
      throw new IllegalArgumentException("Players must be between 2 and 10 inclusive");
    }
    this.deck = initializeDeck();
    shuffleDeck();

    this.playedCards = new Deck();
    Card takenCard = deck.takeCard();
    playedCards.addCard(takenCard);
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
  private Deck initializeDeck() {
    Deck deck = new Deck();
    Color[] colors = { Card.Color.Red, Card.Color.Blue, Card.Color.Green, Card.Color.Yellow };

    // Create 1 zero and 2 of each other number/action card for each color
    for (Color color : colors) {
      deck.addCard(new Card(Card.Type.Zero, color));

      for (int i = 1; i <= 9; i++) {
        deck.addCard(new Card(Card.fromNumber(i), color));
        deck.addCard(new Card(Card.fromNumber(i), color));
      }

      // Add 2 of each action card (Reverse, Skip, DrawTwo)
      for (int j = 0; j < 2; j++) {
        deck.addCard(new Card(Card.Type.Reverse, color));
        deck.addCard(new Card(Card.Type.Skip, color));
        deck.addCard(new Card(Card.Type.DrawTwo, color));
      }
    }

    // Add 4 Wild and 4 Wild Draw Four cards (color is irrelevant for wilds)
    for (int i = 0; i < 4; i++) {
      deck.addCard(new Card(Card.Type.Wild, Card.Color.Wild));
      deck.addCard(new Card(Card.Type.DrawFour, Card.Color.Wild));
    }

    return deck;
  }

  private void shuffleDeck() {
    List<Card> cards = deck.getCards();
    Collections.shuffle(cards);
    deck.setCards(cards);
  }
}
