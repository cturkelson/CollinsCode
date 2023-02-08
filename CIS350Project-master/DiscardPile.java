package SuiteOfGames;

/**
 * Extension of CardPile that describes the function of the Discard pile.
 * @author Christina Kidwell
 * @see CardPile 
 */
class DiscardPile extends CardPile {

    /**
     * Add description here.
     * @param x Add description here.
     * @param y Add description here.
     */
    DiscardPile(int x, int y) {
        super(x, y);
    }

    /**
     * Pushes a card onto the stack.
     * 
     */
    void addCard(Card card) {
        if (!card.getFace()) {
            card.flip();
        }
        super.addCard(card);
    }

    /**
     * Checks if the top card on the selected pile can be moved to any of the
     * suit piles or table piles. If it can it will otherwise the card stays
     * where it is.
     */
    void select() {
        if (isEmpty()) {
            return;
        }
        Card topCard = pop();
        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(topCard)) {
                Solitaire.suitPile[i].addCard(topCard);
                return;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].canTake(topCard)) {
                Solitaire.tableau[i].addCard(topCard);
                return;
            }
        }
        addCard(topCard);
    }
}
