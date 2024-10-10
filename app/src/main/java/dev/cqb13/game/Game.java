package dev.cqb13.game;

import dev.cqb13.game.deck.Deck;
import dev.cqb13.game.deck.Card;
import dev.cqb13.game.deck.Card.Color;
import dev.cqb13.game.deck.Card.Type;

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

    Card[] cards = new Card[108];
    Color[] colors = { Card.Color.Red, Card.Color.Blue, Card.Color.Green, Card.Color.Yellow };
    Type[] numbers = { Card.Type.Zero, Card.Type.One, Card.Type.One, Card.Type.Two, Card.Type.Two, Card.Type.Three,
        Card.Type.Three, Card.Type.Four, Card.Type.Four, Card.Type.Five, Card.Type.Five, Card.Type.Six, Card.Type.Six,
        Card.Type.Seven, Card.Type.Seven, Card.Type.Eight, Card.Type.Eight, Card.Type.Nine, Card.Type.Nine,
        Card.Type.Reverse, Card.Type.Reverse, Card.Type.Skip, Card.Type.Skip, Card.Type.DrawTwo, Card.Type.DrawTwo };
    int current = 0;
    for (int i = 0; i < 4; i++) {
      for (int y = 0; y < 25; y++) {
        if (y == 0) {
          cards[current] = new Card(numbers[y], colors[i]);
        }

        current++;
      }
    }

    for (int i = 0; i < 4; i++) {
      cards[current] = new Card(Card.Type.DrawFour, Card.Color.Wild);
      current++;
    }

    for (int i = 0; i < 4; i++) {
      cards[current] = new Card(Card.Type.Wild, Card.Color.Wild);
      current++;
    }

    Deck playedCards = new Deck();

    Card takenCard = deck.takeCard();

    playedCards.addCard(takenCard);

    this.playedCards = playedCards;
  }
}
