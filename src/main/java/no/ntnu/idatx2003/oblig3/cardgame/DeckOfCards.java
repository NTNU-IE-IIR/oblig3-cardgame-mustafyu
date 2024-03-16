package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.*;


/**
 * Represents a deck of playing cards. A deck of cards has 52 cards, with 13 cards in each of 4 suits.
 */

public class DeckOfCards {
  private  final List<PlayingCard> deck;

  /**
   * Intializes a new deck of cards with 52 cards.
   *
   */
  public DeckOfCards(){
    deck = new ArrayList<>();

    char[] suits = {'S', 'H', 'D', 'C'};
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Shuffles the deck of cards.
   */

  public void shuffle(){
    Collections.shuffle(deck);
  }

  /**
   * Deals a hand of cards from the deck.
   *
   * @param n the number of cards to deal
   * @return Return a hand of n cards
   */
  public List<PlayingCard> dealHand(int n){
    if (n < 1 || n > deck.size()) {
      throw new IllegalArgumentException("Parameter n must be a number between 0 to 52");
    }
    List<PlayingCard> hand = new ArrayList<>();
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      int index = random.nextInt(deck.size());
      hand.add(deck.remove(index));
    }
    return hand;

  }
}
