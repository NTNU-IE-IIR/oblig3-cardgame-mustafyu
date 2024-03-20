package no.ntnu.idatx2003.oblig3.cardgame;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a loader for the card game.
 */
public class CardLoader {

  /**
   * Load card images from the specified directory.
   *
   * @return a list of Image objects representing card images
    */

    public static List<PlayingCard> loadCards() {
      List<PlayingCard> cards = new ArrayList<>();

      // Define suits and faces
      char[] suits = {'H', 'D', 'C', 'S'}; // Hearts, Diamonds, Clubs, Spades
      int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; // Ace to King

      // Generate card names
      for (char suit : suits) {
        for (int face : faces) {
          String cardName = String.format("%c%d", suit, face);
          cards.add(new PlayingCard(suit, face));
        }
      }

      return cards;
    }
  }