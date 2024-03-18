package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Represents a class for checking the cards.
 *
 * <p> The class is used to check the cards and analyze the cards.
 * </p>
 */
public class CheckCardAnalize {


  /**
   * Returns the sum of the values of the cards on the hand.
   * <p>
   * @param hand the hand of cards to retrieve the cards from.
   * @return the sum of the values of the cards on the hand.
   */
  // Regn ut summen av alle verdiene av kortene på hånd (ess = 1)
  public static int sumOfCardValues(List<PlayingCard> hand) {
    return hand.stream()
      .mapToInt(PlayingCard::getFace)
      .sum();
  }


  /**
   * Retrieves only the cards that are of the color "Hearts".
   *
   * @param hand the hand of cards to retrieve the cards from.
   * @return the cards that are of the color "Hearts".
   */
  // Hent ut bare kort som er av fargen "Hjerter"
  public static String getHeartsCards(List<PlayingCard> hand) {
    List<PlayingCard> heartsCards = hand.stream()
      .filter(card -> card.getSuit() == 'H')
      .collect(Collectors.toList());

    if (heartsCards.isEmpty()) {
      return "No Hearts";
    } else {
      return heartsCards.stream()
        .map(PlayingCard::getAsString)
        .collect(Collectors.joining(" "));
    }
  }

  /**
   * Check if the card "Queen of Spades" is among the cards on the hand.
   *
   * @param hand the hand of cards to retrieve the cards from.
   * @return true if the card "Queen of Spades" is among the cards on the hand, false otherwise.
   */
  // Sjekk om kortet "Spar dame" finnes blant kortene på hånden
  public static boolean hasQueenOfSpades(List<PlayingCard> hand) {
    return hand.stream()
      .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }

  /**
   * Check if the cards on the hand form a "5-flush".
   *
   * @param hand  the hand of cards to retrieve the cards from.
   * @return true if the cards on the hand form a "5-flush", false otherwise.
   */

  // Sjekk om kortene på hånd utgjør en "5-flush"
  public static boolean isFiveFlush(List<PlayingCard> hand) {
    return hand.stream()
      .collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()))
      .values().stream()
      .anyMatch(count -> count >= 5);
  }
}


