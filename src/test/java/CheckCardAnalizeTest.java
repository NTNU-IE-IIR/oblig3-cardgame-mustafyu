import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;
import no.ntnu.idatx2003.oblig3.cardgame.CheckCardAnalize;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicMenuUI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Represents Test Class of CheckCardAnalize
 *
 * <p> The following methods are tested:
 * <ul>
 *   <li> Test Sum of Card Values</li>
 *   <li> Test hearts cards</li>
 *   <li> Test hearts card with invalid input</li>
 *   <li>check If QueenOfSpades</li>
 *   <li>check If QueenOfSpades with invalid input</li>
 *   <li>Check Five Flush </li>
 *   <li>Check Five Flush with invalid input</li>
 *   </ul>
 *   </p>
 */


public class CheckCardAnalizeTest {

  //Positive Test
  @Test
  public void testSumOfCardValues() {
    List<PlayingCard> hand = new ArrayList<>();
    hand.add(new PlayingCard('H', 1));
    hand.add(new PlayingCard('D', 10));
    hand.add(new PlayingCard('S', 13));
    assertEquals(24, CheckCardAnalize.sumOfCardValues(hand));
  }

    @Test
    public void testHeartsCards() {
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard('S', 1));
        hand.add(new PlayingCard('H', 2));
        hand.add(new PlayingCard('H', 3));
        hand.add(new PlayingCard('H', 7));
        hand.add(new PlayingCard('S', 8));

        assertEquals("H2, H3, H7", CheckCardAnalize.getHeartsCards(hand));
    }

    @Test
    public void testCheckIfQueenOfSpades() {
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard('S', 12));
        hand.add(new PlayingCard('H', 2));
        hand.add(new PlayingCard('H', 3));

        assertEquals(true, CheckCardAnalize.hasQueenOfSpades(hand));
    }

    @Test
    public void testFiveFlush() {
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard('S', 1));
        hand.add(new PlayingCard('S', 2));
        hand.add(new PlayingCard('S', 3));
        hand.add(new PlayingCard('S', 4));
        hand.add(new PlayingCard('S', 5));

        assertEquals(true, CheckCardAnalize.isFiveFlush(hand));
    }


    //Negative Test

    @Test
    public void testHeartsCardsWithInvalidInput() {
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard('S', 1));
        hand.add(new PlayingCard('S', 2));
        hand.add(new PlayingCard('S', 3));

        assertEquals("No Hearts", CheckCardAnalize.getHeartsCards(hand));
    }

    @Test
    public void testCheckIfQueenOfSpadesWithInvalidInput() {
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard('S', 1));
        hand.add(new PlayingCard('S', 2));
        hand.add(new PlayingCard('S', 3));

        assertEquals(false, CheckCardAnalize.hasQueenOfSpades(hand));
    }

    @Test
    public void testFiveFlushWithInvalidInput() {
        List<PlayingCard> hand = new ArrayList<>();
        hand.add(new PlayingCard('S', 1));
        hand.add(new PlayingCard('S', 2));
        hand.add(new PlayingCard('S', 3));
        hand.add(new PlayingCard('H', 4));

        assertEquals(false, CheckCardAnalize.isFiveFlush(hand));
    }

}

