package edu.cnm.deepdive;

import edu.cnm.deepdive.Suit.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Trick {

  private List<Card> deck;
  private List<Card> redPile;
  private List<Card> blackPile;
  private Card topCard;
  private Random rng;

  public Trick() {
    deck = Card.getDeck();
    redPile = new ArrayList<>();
    blackPile = new ArrayList<>();
    rng = new Random();
  }

  public static void main(String[] args) {
    Trick theTrick = new Trick();
    Collections.shuffle(theTrick.deck);
    theTrick.processDeck(theTrick.deck);
    theTrick.swapNCards();
    theTrick.countCards();
  }

  private void swapNCards() {
    swapCards(pickN());
  }

  private int pickN() {
    int redSize = redPile.size();
    int blackSize = blackPile.size();
    int smallSize = redSize < blackSize? redSize : blackSize;
    return rng.nextInt(smallSize)+1;
  }

  private void swapCards(int nCards) {
    List<Card> tempHolderRed = new ArrayList<>();
    List<Card> tempHolderBlack = new ArrayList<>();
    for (int i = 0; i < nCards; i++) {
      tempHolderRed.add(redPile.remove(i));
      tempHolderBlack.add(blackPile.remove(i));
      nCards--;
    }
    blackPile.addAll(tempHolderRed);
    redPile.addAll(tempHolderBlack);

  }



  private void countCards() {
    System.out.printf("Red pile: %s%n", redPile);
    System.out.printf("Black pile: %s%n", blackPile);
    long redCount = redPile.parallelStream().filter((c) -> c.getSuit().getColor() == Color.RED).count();
    long blackCount = blackPile.parallelStream().filter((c) -> c.getSuit().getColor() == Color.BLACK).count();
    System.out.println("Reds in Red Pile: " + redCount);
    System.out.println("Black in Black Pile: " + blackCount);
    assert redCount == blackCount;


//    int redCardsInRed=0;
//    int blackCardsInBlack=0:
//    for (Card card :
//        redPile) {
//      if(card.getSuit().getColor()==Color.RED){
//        redCardsInRed++;
//      }
//
//    }
  }

  private void processDeck(List<Card> deck) {
    while (deck.size() > 0) {
      drawAndPlaceCard(drawToDiscard(deck));
    }
    assert((redPile.size() + blackPile.size())*2 == Suit.values().length * Rank.values().length);
  }

  private boolean drawToDiscard(List<Card> deck) {
    topCard = deck.remove(0);
    if (topCard.getSuit().getColor() == Color.RED) {
      return true;
    } else {
      return false;
    }
  }

  private void drawAndPlaceCard(boolean isRed) {
    if (isRed) {
      redPile.add(deck.remove(0));
    } else {
      blackPile.add(deck.remove(0));
    }
  }


}
