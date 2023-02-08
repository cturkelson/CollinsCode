package SuiteOfGames;

import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;

class NineMensMorrisPlayer {
    /**
     * This is a boolean variable that's used to store if it is this player's
     * turn or not.
     */
    private boolean turnStatus;

    /**
     * Blank constructor used for testing purposes only.
     */
    NineMensMorrisPlayer() {

    }

    /**
     * Method used to set the number of turns completed. Only used for testing.
     * @param turnCounter the desired number of turns.
     */
    void setTurnCounter(final int turnCounter) {
        this.turnCounter = turnCounter;
    }

    /**
     * Method used to clear the ArrayList used to store the player's pieces.
     */
    void clearMyPlacedPieces() {
        myPlacedPieces.clear();
    }

    /**
     * This integer variable is used to track how many pieces the player has
     * placed on the board. It is initially set to 0.
     */
    private int piecesPlacedCount = 0;
    /**
     * This integer variable is used to track how many pieces the player has on
     * the board currently. It is initially set to 0.
     */
    private int piecesOnBoardCount = 0;
    /**
     * This integer variable is used to track how many turns the player has
     * completed.
     */
    private int turnCounter = 0;

    /**
     * This ArrayList object will be used to store the JButtons that represent
     * the pieces the player has placed on the board.
     */
    private ArrayList<JButton> myPlacedPieces = new ArrayList<>();
    ArrayList<JButton> getMyPlacedPieces() {
        return myPlacedPieces;
    }
    /**
     * This variable is used to store the color of the pieces the player is
     * using. It is used to confirm which player a piece belongs to.
     */

    private Color color;

    /**
     * This is the constructor for a new NineMensMorrisPlayer object. The color
     * parameter is used to set the color of the player's pieces.
     * @param color used to set the new NineMensMorrisPlayer object's piece
     *              color.
     */
    NineMensMorrisPlayer(final Color color) {
        this.color = color;
    }

    /**
     * This method is used to get the color of the pieces used by the player.
     * It is used for verification of piece ownership.
     * @return the color of the player's pieces.
     */
    Color getPlayerColor() {
        return color;
    }

    /**
     * This method is used to get the number of pieces the player has placed on
     * the board. This is not representative of how many pieces the player
     * currently has on the board.
     * @return an integer that represents the number of pieces the player has
     * placed on the board.
     */
    int getPiecesPlacedCount() {
        return piecesPlacedCount;
    }
    /**
     * This method is used to increase both the number of pieces the player has
     * placed total, and the number of pieces the player has in play on the
     * board. It is used during the first phase of the game when players are
     * able to place new pieces on the board.
     */
    private void incrementBothCount() {
        piecesPlacedCount += 1;
        piecesOnBoardCount += 1;
    }

    /**
     * This method is used to return a boolean that represents if it is this
     * player's turn or not.
     * @return a boolean that represents if it is this player's turn or not.
     * True means that it is this player's turn and false means it is not.
     */
    boolean isTurnStatus() {
        return turnStatus;
    }

    /**
     * This method is used by other methods to manipulate the boolean variable
     * that represents if it is the player's turn or not. It is used by the
     * Game class to change turns between players.
     * @param turnStatus the desired turn status for the player. True means it
     *                   is the player's turn and false means it is not.
     */
    void setTurnStatus(final boolean turnStatus) {
        this.turnStatus = turnStatus;
    }

    /**
     * This method is used to return the number of turns the player has
     * completed. It is used to switch between the first and second phases of
     * the game, and to determine when enough turns have passed where a win is
     * possible.
     * @return an integer that represents the number of turns the player has
     * completed.
     */
    int getTurnCounter() {
        return turnCounter;
    }

    /**
     * This method is used to increase the turn counter which keeps track of
     * how many turns the player has completed.
     */
    private void incrementTurnCounter() {
        turnCounter += 1;
    }

    /**
     * This method is used to add the location of a new piece to the ArrayList
     * that stores the locations of the player's pieces. It adds the JButton to
     * the ArrayList, as well as calling the methods used to increment the
     * counter used to store the number of pieces placed and currently on the
     * board.
     * @param lastMove JButton object that represents the location of the piece
     *                 that was placed.
     */
    void placePiece(final JButton lastMove) {
        myPlacedPieces.add(lastMove);
        incrementBothCount();
        incrementTurnCounter();
    }

    /**
     * This method is used to get the number of pieces the player currently has
     * in play on the board.
     * @return an Integer that represents the number of pieces the player has
     * in play.
     */
    int getNumberOfMyPieces() {
        return myPlacedPieces.size();
    }

    /**
     * This method is used to determine if a piece belongs to the player or
     * not. It checks the inputted JButton that represents the piece in
     * question against the ArrayList of the player's pieces. If the JButton
     * matches one in the ArrayList, it returns true. Otherwise it returns
     * false.
     * @param btn JButton object that represents the piece in question.
     * @return a boolean value that represents if the piece is the player's or
     * not.
     */
    boolean checkIfMyPiece(final JButton btn) {
        for (JButton myPlacedPiece : myPlacedPieces) {
            if (myPlacedPiece == btn) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used when a player slides or moves a piece from one
     * location to another. It loops through the ArrayList to find the JButton
     * that represents the location where the piece began the turn. It removes
     * that JButton from the ArrayList, and adds the JButton entered as the
     * endBtn parameter, which represents the ending location of the piece, to
     * the ArrayList.
     * @param startBtn JButton that represents the location where the piece
     *                began the turn
     * @param endBtn JButton that represents the location where the piece is
     *               moved to.
     */
    void replacePiece(final JButton startBtn, final JButton endBtn) {
        for (int i = 0; i < myPlacedPieces.size(); i++) {
            if (myPlacedPieces.get(i) == startBtn) {
                myPlacedPieces.remove(startBtn);
                myPlacedPieces.add(endBtn);
                incrementTurnCounter();
            }
        }
    }

    /**
     * This method is used when a piece is removed from play. The method
     * removes the JButton entered as a parameter from the ArrayList that holds
     * the location of the player's pieces. It uses the setPiecesOnBoardCount
     * to reduce the integer that represents the number of pieces the player
     * has on the board by 1.
     * @param byeByeBtn JButton that represents the location of the piece being
     *                  removed.
     */
    void removePiece(final JButton byeByeBtn) {
        myPlacedPieces.remove(byeByeBtn);
    }

    /**
     * This method is used to return the color of the player's piece as a
     * string. It is used when the game is over to print a message that
     * contains the winning player's piece color.
     * @return a String that represents the color of the player's pieces.
     */
    String printPlayerColor() {
        if (getPlayerColor() == Color.white) {
            return "White";
        }
        return "Black";
    }

    /**
     * This method is used to reset the player objects when a new game is
     * desired. It resets the integers that keep track of how many pieces were
     * placed on the board, and how many pieces were currently on the board. It
     * clears the ArrayList where the JButtons representing the player's pieces
     * are stored.
     */
    void reset() {
        piecesPlacedCount = 0;
        myPlacedPieces.clear();
        piecesOnBoardCount = 0;
        turnCounter = 0;
    }
}
