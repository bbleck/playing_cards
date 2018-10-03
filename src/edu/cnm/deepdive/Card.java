package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public static void main(String[] args) {
    List<Card> deck = new ArrayList<>();
    for (Suit suit :
        Suit.values()) {
      for (Rank rank :
          Rank.values()) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }
    System.out.println(deck);
    Collections.shuffle(deck);
    System.out.println(deck);
  }

  public static List<Card> getDeck(){
    List<Card> deck = new ArrayList<>();
    for (Suit suit :
        Suit.values()) {
      for (Rank rank :
          Rank.values()) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }
    return deck;
  }

  @Override
  public String toString() {
    return rank.getSymbol()+suit.getSymbol();
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }
}
