package dev.cqb13.game.deck;

public class Node {
  public Card value;
  public Node next;

  public Node(Card value) {
    this.value = value;
    this.next = null;
  }
}
