package dev.cqb13.game.deck;

public class Deck {
  public int size;
  public Node topCard;

  public Deck() {
    this.size = 0;
    this.topCard = null;
  }

  public void addCard(Card card) {
    Node node = new Node(card);

    node.next = this.topCard;

    this.size++;

    this.topCard = node;
  }

  public Card takeCard() {
    if (this.size == 0) {
      return null;
    }

    Card card = this.topCard.value;

    this.topCard = this.topCard.next;

    this.size--;

    return card;
  }

  public Card checkCard() {
    if (this.size == 0) {
      return null;
    }

    return this.topCard.value;
  }
}
