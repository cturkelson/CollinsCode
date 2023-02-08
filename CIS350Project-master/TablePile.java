package SuiteOfGames;

import java.awt.Graphics;
import java.util.Enumeration;

/**
 * Extension of CardPile that describes the function of a table pile.
 * @author Christina Kidwell
 * @see CardPile
 *
 */
class TablePile extends CardPile {

    TablePile(final int x, final int y, final int c) {
        super(x, y);
        for (int i = 0; i < c; i++) {
            addCard(Solitaire.deckPile.pop());
        }
        top().flip();
    }

    /**
     * Returns true if a card can be put on the selected pile.
     * @param card the card in question.
     * @return True if a card can be put on the selected pile.
     */
    boolean canTake(final Card card) {
        if (isEmpty()) {
            return card.getRank() == 12;
        }
        Card topCard = top();
        if (!topCard.getFace()) {
            return false;
        }
        return (card.getColor() != topCard.getColor())
                && (card.getRank() == topCard.getRank() - 1);
    }

    boolean includes(final int tx, final int ty) {
        return x <= tx && tx <= x + Card.width && y <= ty;
    }

    /**
     * Displays a visual representation of the pile of cards.
     * @param g graphical space of the window.
     */
    void display(final Graphics g) {
        int localy = y;
        for (Enumeration<?> e = thePile.elements(); e.hasMoreElements();) {
            Card card = (Card) e.nextElement();
            card.draw(g, x, localy);
            localy += Card.height / 6;
        }
    }

    /**
     * Checks if the top card on the selected pile can be moved to any of the
     * suit piles. If it can it will otherwise the card stays where it is.
     * @see TempPile
     */
    void select() {
        if (isEmpty()) {
            return;
        }

        Card topCard = top();
        if (!topCard.getFace()) {
            topCard.flip();
            return;
        }

        topCard = pop();
        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(topCard)) {
                Solitaire.suitPile[i].addCard(topCard);
                Solitaire.loser = 0;
                if (!isEmpty()) {
                    topCard = top();
                    if (!topCard.getFace()) {
                        topCard.flip();
                    }

                }
                return;
            }
        }
        Solitaire.tempPile.addCard(topCard);
        while (!isEmpty()) {
            if (top().getFace()) {
                topCard = pop();
                Solitaire.tempPile.addCard(topCard);
            } else {
                break;
            }
        }
        topCard = Solitaire.tempPile.top();
        for (int i = 0; i < 7; i++) {
//          System.out.println(i); Test to see what column was being looked at
            if (Solitaire.tableau[i].canTake(topCard)) {
                Solitaire.loser = 0;
                while ((topCard = Solitaire.tempPile.pop()) != null) {
                    Solitaire.tableau[i].addCard(topCard);
                }
                if (!isEmpty()) {
                    topCard = top();
                    if (!topCard.getFace()) {
                        topCard.flip();
                    }

                }
                return;
            }
        }
        while ((topCard = Solitaire.tempPile.pop()) != null) {
            addCard(topCard);
        }
    }
}
