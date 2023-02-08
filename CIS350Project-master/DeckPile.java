package SuiteOfGames;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * This class describes the functionality of
 * the deck that cards are drawn from.
 *
 * @author Christina Kidwell
 * @see CardPile
 * @throws URISyntaxException Checked exception thrown to indicate that
 * a string could not be parsed as aURI reference.
 * @throws IOException Signals that an I/O exception of some sort has occurred.
 */
class DeckPile extends CardPile {
    DeckPile(final int x, final int y) throws IOException, URISyntaxException {
        super(x, y);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 12; j++) {
                addCard(new Card(i, j));
            }
        }

        Random generator = new Random();
        for (int i = 0; i < 52; i++) {
            int j = Math.abs(generator.nextInt()) % 52;
            Card temp = thePile.elementAt(i);
            thePile.setElementAt(thePile.elementAt(j), i);
            thePile.setElementAt(temp, j);
        }
    }

    /**
     * Grabs a single card from the Deck,
     * puts it in the Discard Pile, and flips it over.
     * If no cards remain in the Deck pile Clicking it will return the
     * cards from the discard pile face down to the deck pile.
     * @see DiscardPile
     */
    void select() {
        if (isEmpty()) {
            Solitaire.loser++;
            for (int i = 0; i < 52; i++) {
                Card topCard = Solitaire.discardPile.pop();
                if (topCard == null) {
                    return;
                }
                addCard(topCard);
                top().flip();
            }
        }
        Solitaire.discardPile.addCard(pop());
        /**
         * If these if statements are implemented the game becomes a
         * draw 3 version of solitaire. I left these out because I
         * could not figure out how to show this visually in time for
         * the due date. Goal for if/when I return to this project.
         * if (!isEmpty()) {
         *     Solitaire.discardPile.addCard(pop());
         * }
         * if (!isEmpty()) {
         *     Solitaire.discardPile.addCard(pop());
         * }
         */
    }
}
