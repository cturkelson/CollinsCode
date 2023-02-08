package SuiteOfGames;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Eric Evely
 * @version Release 1
 */
class NineMensMorrisGame {

    /**
     * Helper method used for testing that returns the player1 object.
     * @return NineMensMorrisPlayer object that represents player1.
     */
    NineMensMorrisPlayer getPlayer1() {
        return player1;
    }
    /**
     * Helper method used for testing that returns the player2 object.
     * @return NineMensMorrisPlayer object that represents player2.
     */
    NineMensMorrisPlayer getPlayer2() {
        return player2;
    }
    /**This instantiates a NineMensMorrisPlayer object to store the information
     * for project1.Player 1.**/
    private final NineMensMorrisPlayer player1 =
            new NineMensMorrisPlayer(Color.black);
    /**This instantiates a NineMensMorrisPlayer object to store the information
     * for project1.Player 2.**/
    private final NineMensMorrisPlayer player2 =
            new NineMensMorrisPlayer(Color.white);
    /**An ArrayList that holds all of the places on the board where a player
     * has placed a piece.**/
    private final ArrayList<JButton> placedPieces = new ArrayList<>();

    /********************************************************************
     * This method is the constructor for the Nine Men's Morris Game. It
     * creates a new game in which project1.Player 1 goes first.
     *******************************************************************/
    NineMensMorrisGame() {
        player1.setTurnStatus(true);
    }
    /********************************************************************
     * This method returns the player who's turn it currently is.
     * @return the NineMensMorrisPlayer object who's turn it currently is.
     *******************************************************************/
    NineMensMorrisPlayer whosTurn() {
        if (player1.isTurnStatus()) {
            return player1;
        }
        return player2;
    }
    /********************************************************************
     * This method returns the player who's turn it currently is not.
     * @return the NineMensMorrisPlayer object who's turn it currently is not.
     *******************************************************************/
    NineMensMorrisPlayer getOtherPlayer() {
        if (whosTurn() == player1) {
            return player2;
        }
        return player1;
    }
    /********************************************************************
     * This method changes who's turn it is by manipulating the boolean values
     * in the NineMensMorrisPlayer object.
     * @param currentPlayer the NineMensMorrisPlayer who's turn it is.
     *******************************************************************/
    void changeTurn(final NineMensMorrisPlayer currentPlayer) {
        if (currentPlayer.getPlayerColor() == Color.black) {
            player1.setTurnStatus(false);
            player2.setTurnStatus(true);
        } else {
            player2.setTurnStatus(false);
            player1.setTurnStatus(true);
        }

    }
    /********************************************************************
     * This method takes the JButton (referred to as a piece), that was entered
     * as the parameter for the method, and uses the methods in the project1.
     * Player class to add it to the current player's ArrayList that stores the
     * location of its pieces.
     * @param btn the JButton that will be added to the player's ArrayList.
     *******************************************************************/
    void placePiecePlayer(final JButton btn) {
        NineMensMorrisPlayer currentplayer = whosTurn();

        if (currentplayer.getPiecesPlacedCount() < 9) {
            if (openSpot(btn)) {
                currentplayer.placePiece(btn);
                placedPieces.add(btn);
            }
        }
    }
    void placePieceWhite(final JButton btn) {
        if (player2.getPiecesPlacedCount() < 9) {
            if (openSpot(btn)) {
                player2.placePiece(btn);
                placedPieces.add(btn);
            }
        }
    }
    void placePieceBlack(final JButton btn) {
        if (player1.getPiecesPlacedCount() < 9) {
            if (openSpot(btn)) {
                player1.placePiece(btn);
                placedPieces.add(btn);
            }
        }
    }
    /********************************************************************
     * This method is used during the second phase of the game to slide a piece
     * from its present location to an open and adjacent location. The method
     * does this by first checking if the proposed move is legal, using a built
     * in helper method, removes the starting location from the ArrayList that
     * stores the occupied pieces, and adding the ending location to that
     * ArrayList.
     * @param startBtn the JButton that represents the piece's starting
     *                 location.
     * @param endBtn the JButton that represents the piece's ending location.
     *******************************************************************/
    void slidePiece(final JButton startBtn, final JButton endBtn) {
        NineMensMorrisPlayer currentPlayer = whosTurn();
        if (checkLegalSlide(startBtn, endBtn)) {
            currentPlayer.replacePiece(startBtn, endBtn);
            placedPieces.remove(startBtn);
            placedPieces.add(endBtn);
        }
    }
    /********************************************************************
     * This method is used during the third phase of the game to move a piece
     * from its present location to an open location. The method does this by
     * first checking if the proposed move is legal, using a built in helper
     * method, removes the starting location from the ArrayList that stores the
     * occupied pieces, and adding the ending location to that ArrayList.
     * @param startBtn the JButton that represents the piece's starting
     *                 location.
     * @param endBtn the JButton that represents the piece's ending location.
     *******************************************************************/
    void movePiece(final JButton startBtn, final JButton endBtn) {
        NineMensMorrisPlayer currentPlayer = whosTurn();
        if (openSpot(endBtn)) {
            currentPlayer.replacePiece(startBtn, endBtn);
            placedPieces.remove(startBtn);
            placedPieces.add(endBtn);
        }
    }
    /******************************************************************
     * This method is used to determine if a piece has already been placed on
     * the selected space on the board. It does this by looping through the
     * ArrayList that contains the location of all placed pieces.
     * @param btn the JButton object that represents the desired spot on the
     *            board.
     * @return a boolean object that represents if the space contains a piece.
     *******************************************************************/
    private boolean openSpot(final JButton btn) {
        for (JButton placedPiece : placedPieces) {
            if (placedPiece == btn) {
                return false;
            }
        }
        return true;
    }
    /******************************************************************
     * This method is used to determine if a move of a piece from its current
     * location to another location on the board is possible and allowed by the
     * rules of the game. It first checks if the start piece belongs to the
     * player whos turn it is. It then checks if the desired location has a
     * piece on it, either the current player's or the other player's. Last it
     * confirms that the piece in the starting location is in fact the current
     * player's, and that the desired location does not have a piece on it.
     * @param startBtn the JButton object that represents the current location
     *                 of the piece on the board.
     * @param endBtn the JButton object that represents the desired spot on
     *               the board.
     * @return a boolean object that represents if the desired move is legal.
     *******************************************************************/
    boolean checkLegalSlide(final JButton startBtn,
                            final JButton endBtn) {
            if ((!whosTurn().checkIfMyPiece(startBtn))) {
                JOptionPane.showMessageDialog(null, "Not your piece!");
                return false;
            }
            if (whosTurn().checkIfMyPiece(endBtn)) {
                JOptionPane.showMessageDialog(null,
                        "Can't move onto your own piece!");
                return false;
            }
            if (getOtherPlayer().checkIfMyPiece(startBtn)) {
                JOptionPane.showMessageDialog(null,
                        "Can't move your opponent's piece!");
                return false;
            }
            if (getOtherPlayer().checkIfMyPiece(endBtn)) {
                JOptionPane.showMessageDialog(null,
                        "Can't move  there!");
                return false;
            }
        return (whosTurn().checkIfMyPiece(startBtn)) && (openSpot(endBtn));
    }
    /******************************************************************
     * This method is used to remove a piece from play. The piece that is to be
     * removed is represented by the JButton parameter. That object is used to
     * remove the corresponding object from the ArrayList of all the pieces on
     * the board. The whosPiece method is used to call the project1. Player
     * object who's piece is being removed, and remove it from that object's
     * ArrayList that stores all of its placed pieces.
     * @param btn the JButton object that represents the piece to be removed.
     *******************************************************************/
    void removePiece(final JButton btn) {
        placedPieces.remove(btn);
        whosPiece(btn).removePiece(btn);
    }
    /******************************************************************
     * This method is used to retrieve the ArrayList that contains all of the
     * pieces currently in play on the board.
     * @return the ArrayList containing all of the pieces on the board.
     *******************************************************************/
    ArrayList<JButton> getPlacedPieces() {
        return placedPieces;
    }
    /******************************************************************
     * This method is used to determine which player a piece belongs to.
     * @param btn the JButton object that represents the piece who's ownership
     *            needs to be determined.
     * @return the project1.Player who's piece it is.
     *******************************************************************/
    NineMensMorrisPlayer whosPiece(final JButton btn) {
        if (player1.checkIfMyPiece(btn)) {
            return player1;
        }
        return player2;
    }

    /**
     * This method is used to determine when the game is over. When called, it
     * checks if the players have 2 pieces left (it is not possible to have one
     * left), and that more than 9 turns have passed. This is to prevent the
     * game from declaring the game over when a player places their second
     * piece on the board at the beginning of the game. The method then returns
     * a boolean object that represents the result.
     * @return a boolean object that represents if the game is over or not.
     */
    boolean gameOver() {
        if (player1.getNumberOfMyPieces() == 2
                && player1.getTurnCounter() > 9) {
            return true;
        }
        return player2.getNumberOfMyPieces() == 2 && player2.getTurnCounter()
                > 9;
    }
    /**
     * This method is used to determine the winning player. It checks if a
     * player has 2 pieces left, and if so, returns the other player.
     * @return NineMensMorrisPlayer object that represents the winning player.
     */
    NineMensMorrisPlayer winningPlayer() {
        if (player1.getNumberOfMyPieces() == 2) {
            return player2;
        }
        return player1;
    }
    /**
     * This method is used to reset the game when a user would like to start a
     * new game. In this class it clears the ArrayList that holds the location
     * of all the pieces currently on the board. It clears the ArrayLists used
     * by both player objects that hold the location of their pieces. It then
     * sets the turnStatus boolean so that the Player 1 object will place their
     * piece first.
     */
    void reset() {
        player2.setTurnStatus(false);
        player1.setTurnStatus(true);
        placedPieces.clear();
        player1.reset();
        player2.reset();
        player1.setTurnCounter(0);
        player1.clearMyPlacedPieces();
        player2.setTurnCounter(0);
        player2.clearMyPlacedPieces();
    }
}

