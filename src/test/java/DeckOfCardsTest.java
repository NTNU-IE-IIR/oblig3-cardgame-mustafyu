import no.ntnu.idatx2003.oblig3.cardgame.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tets for the DeckOfCards class
 * The following methods are tested:
 * <ul>
 *   <li> Test dealhand method when runned</li>
 */


public class DeckOfCardsTest {

    @Test
    public void testDealHand() {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = deck.dealHand(5);
        assertEquals(5, hand.size());
    }
}
