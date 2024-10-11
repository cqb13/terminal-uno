package dev.cqb13.game.deck;

import java.util.ArrayList;
import java.util.List;

public class Deck {
  private List<Card> cards = new ArrayList<>();

  public void addCard(Card card) {
    cards.add(card);
  }

  public Card takeCard() {
    return cards.isEmpty() ? null : cards.remove(0);
  }

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }
}
