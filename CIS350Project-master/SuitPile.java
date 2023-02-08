package SuiteOfGames;

/**
 * SuitPile extension of CardPile that describes the function of a suit pile.
 * @author Christina Kidwell
 * @see CardPile
 */
class SuitPile extends CardPile {

    SuitPile(final int x, final int y) {
        super(x, y);
    }

    /**
     * Returns true if a card can be put on the pile. When empty a
     * suit pile can only accept an Ace.
     * @param card the card in question.
     * @return a boolean that returns true if the pile can accept the card.
     */
    boolean canTake(final Card card) {
        if (isEmpty()) {
            return card.getRank() == 0;
        }
        Card topCard = top();
        return (card.getSuit() == topCard.getSuit())
                && (card.getRank() == 1 + topCard.getRank());
    }

    /**
     * Checks if the top card on the selected pile can be moved to any of the
     * table piles. If it can it will otherwise the card stays where it is.
     * @see TablePile
     */
    void select() {
        if (isEmpty()) {
            return;
        }

        Card topCard = pop();
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].canTake(topCard)) {
                Solitaire.tableau[i].addCard(topCard);
                return;
            }
        }
        addCard(topCard);
    }
}
