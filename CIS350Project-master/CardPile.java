package SuiteOfGames;

import java.awt.Color;
import java.awt.Graphics;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * This is a general definition of a pile of cards
 * to be extended by other classes.
 *
 * @author Christina Kidwell
 * @see DeckPile
 * @see DiscardPile
 * @see SuitPile
 * @see TablePile
 * @see TempPile
 */
public class CardPile {
    /**Horizontal position of the upper left corner of a pile.*/
    int x;
    /**Vertical position of the upper left corner of a pile.*/
    int y;
    /**Stack that holds the cards that will go in the pile.*/
    Stack<Card> thePile;

    /**
    * Constructor for CardPile that initializes the variables and
    * creates the stack that will hold the cards in the pile.
    * @param xl Stores the horizontal component for the location of the pile.
    * @param yl Stores the vertical component for the location of the pile.
    */
    CardPile(final int xl, final int yl) {
        x = xl;
        y = yl;
        thePile = new Stack<Card>();
    }

    /**
     * Returns the first card in the stack without removing it from the stack.
     * @return the card object that is the first in the stack.
     */
    public final Card top() {
        return (Card) thePile.peek();
    }

    /**
     * Helper method to check if the stack of cards is empty.
     * @return boolean that represents if the stack of cards is empty or not.
     */
    public final boolean isEmpty() {
        return thePile.empty();
    }

    /**
     * Returns the card at the top of the stack
     * and removes it from the stack.
     * @return the card object at the top of the stack.
     */
    final Card pop() {
        try {
            return (Card) thePile.pop();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    /**
     * Checks to see if a pile was clicked on.
     * @param mouseX x coordinate of the mouse click.
     * @param mouseY y coordinate of the mouse click.
     * @return true if the pile was click and false if otherwise.
     */
    boolean includes(final int mouseX, final int mouseY) {
        return x <= mouseX && mouseX <= x + Card.width
                && y <= mouseY && mouseY <= y + Card.height;
    }

    /**
     * Method executed when pile is selected.
     */
    void select() {

    }

    /**
     * Pushes a card onto the stack.
     * @param card which is being put on the stack.
     */
    void addCard(final Card card) {
        thePile.push(card);
    }

    /**
     * Displays a visual representation of the pile of cards.
     * @param g the graphics space of the window.
     */
    void display(final Graphics g) {
        g.setColor(Color.blue);
        if (isEmpty()) {
            g.clearRect(x, y, Card.width, Card.height);
            g.drawRect(x, y, Card.width, Card.height);
        } else {
            top().draw(g, x, y);
        }
    }

    /**
     * boolean value that states if the card can be put on the pile.
     * @param card the card object in question.
     * @return boolean defaults to false but is overwritten in
     * classes that extend CardPile.
     * @see TablePile
     * @see SuitPile
     */
    boolean canTake(final Card card) {
        return false;
    }
}
