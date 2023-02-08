package SuiteOfGames;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *The NMM creates a JPanel that is used by the NMMGUI class to display the game
 * and allow the players to interact with the program.
 */

class NMMPanel extends JPanel {
    /**
     *Instantiates a new NineMensMorrisGame object. This instantiation will
     * handle a lot of the game logic, such as switching turns, keeping track
     * of the separate player's pieces and determining when the game is over.
     */
    private NineMensMorrisGame gameLogic;

    /**
     *Creates a new grid of JButtons that will be displayed in the GUI. The
     * JButtons will serve as placeholders for the pieces the players will
     * place on the board.
     */
    private JButton[][] board;
    /**
     *A boolean value that is used to switch to the ActionListener that handles
     * the removal of a player's piece when their opponent has created a run.
     */
    private boolean removalTime = false;
    /**
     * A color that is used as the background of the JButtons that do not
     * represent a piece.
     */
    private final Color tan = new Color(153, 102, 0);
    /**
     * A integer used for accessing row 0 and column 0  on the board. A variable
     * is used so if the board layout changes it is a simple matter to update
     * all references reflect the new layout.
     */
    private static final int BOARD_0 = 0;
    /**
     * A integer used for accessing row 2 and column 2  on the board. A variable
     * is used so if the board layout changes it is a simple matter to update
     * all references reflect the new layout.
     */
    private static final int BOARD_2 = 2;
    /**
     * A integer used for accessing row 4 and column 4  on the board. A variable
     * is used so if the board layout changes it is a simple matter to update
     * all references reflect the new layout.
     */
    private static final int BOARD_4 = 4;
    /**
     * A integer used for accessing row 6 and column 6  on the board. A variable
     * is used so if the board layout changes it is a simple matter to update
     * all references reflect the new layout.
     */
    private static final int BOARD_6 = 6;
    /**
     * A integer used for accessing row 8 and column 8  on the board. A variable
     * is used so if the board layout changes it is a simple matter to update
     * all references reflect the new layout.
     */
    private static final int BOARD_8 = 8;
    /**
     * A integer used for accessing row 10 and column 10  on the board. A
     * variable is used so if the board layout changes it is a simple matter
     * to update all references reflect the new layout.
     */
    private static final int BOARD_10 = 10;
    /**
     * A integer used for accessing row 12 and column 12  on the board. A
     * variable is used so if the board layout changes it is a simple matter
     * to update all references reflect the new layout.
     */
    private static final int BOARD_12 = 12;
    /**
     * An integer that is used to store the number of pieces remaining that
     * triggers the switch from sliding pieces to moving them to any open spot
     * on the board. A variable was used so if the number of pieces needed to
     * trigger this switch changes, the program can be easily updated to
     * reflect this rule change.
     */
    private static final int PIECE_3 = 3;
    /**
     * An integer that is used to store the number of pieces that a player has
     * placed on the board necessary to switch game phases from placing new
     * pieces on the board, to sliding the pieces to open, adjacent places.
     * A variable was used so if the number of pieces needed to trigger this
     * switch changes, the program can be easily updated to reflect this rule
     * change.
     */
    private static final int TURN_9 = 9;
    /**
     * An integer that is used to store the number of rows and columns of
     * JButtons contained in the board. A variable was used so if the board
     * size needs to be modified, it is a simple matter to update the program
     * to reflect this change.
     */
    private static final int BOARD_SIZE_13 = 13;
    /**
     * Integer used to help determine when a player has no possible moves.
     */
    private int mistakeCount = 0;

    /**
     *This is the constructor for the NMMPanel class. It instantiates a new
     * NineMensMorrisGame object, instantiates the necessary ActionListeners,
     * creates the board, populates it with JButtons, adds the ActionListeners
     * to the proper JButtons, and changes the backgrounds of the JButtons to
     * reflect their position and role on the board. Tan colored JButtons
     * represent playing locations on the board. All other JButtons are colored
     * grey and do nothing.
     */
    NMMPanel() {
        gameLogic = new NineMensMorrisGame();
        setLayout(new GridLayout(BOARD_SIZE_13, BOARD_SIZE_13));
        ButtonListener listener = new ButtonListener();
        SlideListener slideListener = new SlideListener();
        RemovalListener removalListener = new RemovalListener();
        MoveListener moveListener = new MoveListener();


        board = new JButton[BOARD_SIZE_13][BOARD_SIZE_13];
        for (int row = 0; row < BOARD_SIZE_13; row++) {
            for (int col = 0; col < BOARD_SIZE_13; col++) {

                int boardHeight100 = 100;
                if (row == BOARD_0) {
                    if ((col == BOARD_0) || (col == BOARD_6)
                            || (col == BOARD_12)) {
                        board[row][col] = new JButton("");
                        board[row][col].addActionListener(listener);
                        board[row][col].addActionListener(slideListener);
                        board[row][col].addActionListener(removalListener);
                        board[row][col].addActionListener(moveListener);
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(tan);
                        add(board[row][col]);
                    } else {
                        board[row][col] = new JButton("");
                        board[row][col].setSize(boardHeight100, boardHeight100);
                        board[row][col].setBackground(Color.lightGray);
                        add(board[row][col]);
                    }
                } else if (row == BOARD_2) {
                    if ((col == BOARD_2) || (col == BOARD_6)
                            || (col == BOARD_10)) {
                        board[row][col] = new JButton("");
                        board[row][col].addActionListener(listener);
                        board[row][col].addActionListener(slideListener);
                        board[row][col].addActionListener(removalListener);
                        board[row][col].addActionListener(moveListener);
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(tan);
                        add(board[row][col]);
                    } else {
                        board[row][col] = new JButton("");
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(Color.lightGray);
                        add(board[row][col]);
                    }
                } else if (row == BOARD_4) {
                    if ((col == BOARD_4) || (col == BOARD_6)
                            || (col == BOARD_8)) {
                        board[row][col] = new JButton("");
                        board[row][col].addActionListener(listener);
                        board[row][col].addActionListener(slideListener);
                        board[row][col].addActionListener(removalListener);
                        board[row][col].addActionListener(moveListener);
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(tan);
                        add(board[row][col]);
                    } else {
                        board[row][col] = new JButton("");
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(Color.lightGray);
                        add(board[row][col]);
                    }
                } else if (row == BOARD_6) {
                    if ((col == BOARD_0) || (col == BOARD_2) || (col == BOARD_4)
                            || (col == BOARD_8) || (col == BOARD_10)
                            || (col == BOARD_12)) {
                        board[row][col] = new JButton("");
                        board[row][col].addActionListener(listener);
                        board[row][col].addActionListener(slideListener);
                        board[row][col].addActionListener(removalListener);
                        board[row][col].addActionListener(moveListener);
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(tan);
                        add(board[row][col]);
                    } else {
                        board[row][col] = new JButton("");
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(Color.lightGray);
                        add(board[row][col]);
                    }
                } else if (row == BOARD_8) {
                    if ((col == BOARD_4) || (col == BOARD_6)
                            || (col == BOARD_8)) {
                        board[row][col] = new JButton("");
                        board[row][col].addActionListener(listener);
                        board[row][col].addActionListener(slideListener);
                        board[row][col].addActionListener(removalListener);
                        board[row][col].addActionListener(moveListener);
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(tan);
                        add(board[row][col]);
                    } else {
                        board[row][col] = new JButton("");
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(Color.lightGray);
                        add(board[row][col]);
                    }
                } else if (row == BOARD_10) {
                    if ((col == BOARD_2) || (col == BOARD_6)
                            || (col == BOARD_10)) {
                        board[row][col] = new JButton("");
                        board[row][col].addActionListener(listener);
                        board[row][col].addActionListener(slideListener);
                        board[row][col].addActionListener(removalListener);
                        board[row][col].addActionListener(moveListener);
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(tan);
                        add(board[row][col]);
                    } else {
                        board[row][col] = new JButton("");
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(Color.lightGray);
                        add(board[row][col]);
                    }
                } else if (row == BOARD_12) {
                    if ((col == BOARD_0) || (col == BOARD_6)
                            || (col == BOARD_12)) {
                        board[row][col] = new JButton("");
                        board[row][col].addActionListener(listener);
                        board[row][col].addActionListener(slideListener);
                        board[row][col].addActionListener(removalListener);
                        board[row][col].addActionListener(moveListener);
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(tan);
                        add(board[row][col]);
                    } else {
                        board[row][col] = new JButton("");
                        board[row][col].setSize(boardHeight100,
                                boardHeight100);
                        board[row][col].setBackground(Color.lightGray);
                        add(board[row][col]);
                    }
                } else {
                    board[row][col] = new JButton("");
                    board[row][col].setSize(boardHeight100,
                            boardHeight100);
                    board[row][col].setBackground(Color.lightGray);
                    add(board[row][col]);
                }
            }
        }
    }

    /**
     * The first ActionListener used to place pieces during the first nine
     * turns of the game.
     */
    private class ButtonListener implements ActionListener {
        /**
         * It first checks the number of turns, and if the boolean that
         * represents if the current player can remove an opponent's piece. If
         * the number of turns is more than nine, or the boolean is true, then
         * the event source pointer, e, is set to null, and the method returns
         * early. If the conditions are met, it a reference to the JButton where
         * the ActionEvent is occurring, and creates a local variable that is a
         * reference to it. It then checks if the JButton already contains a
         * piece, and if it does not, the background of the JButton is changed
         * to represent the current player's piece color. The method then
         * checks if this placement created a run of three, and if so, sets
         * the boolean variable "removalTime" to true, which triggers a
         * different ActionListener when this class is finished. If the move
         * did not create a run of three, then the turn is changed to the
         * other player and the method is finished.@param e the ActionEvent
         * source.
         * @param e the ActionEvent source.
         */
        @Override
        public void actionPerformed(final ActionEvent e) {
            int x = -1;
            int y = -1;
            if (e.getSource() == null) {
                return;
            }

            if (gameLogic.whosTurn().getTurnCounter() > TURN_9) {
                e.setSource(null);
                return;
            }
            if (!removalTime && gameLogic.whosTurn().getTurnCounter()
                    <= TURN_9) {
                if (!removalTime) {
                    JComponent comp = (JComponent) e.getSource();
                    for (int row = 0; row < BOARD_SIZE_13; row++) {
                        for (int col = 0; col < BOARD_SIZE_13; col++) {
                            if (board[row][col] == comp) {
                                x = row;
                                y = col;
                                break;
                            }
                        }
                    }
                    JButton btn = board[x][y];
                    for (JButton occupiedSpace : gameLogic.getPlacedPieces()) {
                        if (btn == occupiedSpace) {
                            return;
                        }
                    }
                    if (gameLogic.whosTurn().getPlayerColor() == Color.black) {
                        btn.setBackground(Color.black);
                        gameLogic.placePiecePlayer(btn);
                        if (checkForThree(btn)) {
                            removalTime = true;
                            return;
                        } else {
                            gameLogic.changeTurn(gameLogic.whosTurn());
                            return;
                        }
                    } else if (gameLogic.whosTurn().getPlayerColor()
                            == Color.white) {
                        btn.setBackground(Color.white);
                        gameLogic.placePiecePlayer(btn);
                        if (checkForThree(btn)) {
                            removalTime = true;
                            return;
                        } else {
                            gameLogic.changeTurn(gameLogic.whosTurn());
                            return;
                        }
                    }

                }
            }
        }
    }

    /**
     * The second ActionListener class that is used during the second phase of
     * the game, once each player has placed nine pieces on the board.
     */
    private class SlideListener implements ActionListener {
        /**
         *A local boolean variable that is used to differentiate between
         * the part of the turn where the player selects the peice they want to
         * move, and selecting the location they would like to move it to.
         */
        private boolean midturnSwitch = false;
        /**
         *A local JButton variable that is used to store a refrence to the
         * JButton that is the starting location of the piece that is being
         * moved.
         */
        private JButton oldPlace = new JButton();
        /**
         * This method is the ActionListener that handles the second phase of
         * the game, where players slide an already placed piece to an open
         * and adjascent spot on the board. This method is seperated into two
         * parts. In the first, the user selects the piece they would like to
         * move. A refrence to the JButton that represents this piece is stored
         * in the local variable "oldPlace." The boolean "midturnSwitch" is
         * then set to true, and the second half of the method is triggered.
         * The ActionEvent source is cleared and the player selects the spot
         * they would like to move the piece to. Using various helper methods,
         * this method checks that it is a valid move. If so, it removes the
         * original location from the ArrayList in the NineMensMorrisGame
         * object, as well as the ArrayList in the proper project1. Player
         * object. It changes the colors of the appropriate JButtons and then
         * checks if the move created a run of three. If so, the proper
         * boolean is manipulated to trigger the ActionListener that handles
         * removing pieces. If no run was created, the turn is advanced and
         * the game continues.
         * @param e the ActionEvent the method is responding to.
         */
        @Override
        public void actionPerformed(final ActionEvent e) {
                if ((gameLogic.whosTurn().getTurnCounter() >= TURN_9)
                        && (gameLogic.whosTurn().getMyPlacedPieces().size()
                        > PIECE_3) && (!removalTime)) {
                    if (!midturnSwitch) {
                        JComponent comp = (JComponent) e.getSource();
                            for (int row = 0; row < BOARD_SIZE_13; row++) {
                                for (int col = 0; col < BOARD_SIZE_13; col++) {
                                    if (board[row][col] == comp) {
                                        oldPlace = board[row][col];

                                        if (!gameLogic.whosTurn()
                                                .checkIfMyPiece(oldPlace)) {
                                            e.setSource(null);
                                            return;
                                        }
                                        midturnSwitch = true;
                                        return;
                                    }
                                }
                            }
                    }
                    if (midturnSwitch) {
                        JComponent comp = (JComponent) e.getSource();
                        try {
                            for (int row = 0; row < BOARD_SIZE_13; row++) {
                                for (int col = 0; col < BOARD_SIZE_13; col++) {
                                    if (board[row][col] == comp) {
                                        JButton btn;
                                        btn = board[row][col];

                                        if (!validSlide(oldPlace, btn)) {
                                            throw new IllegalArgumentException(
                                            );
                                        } else {
                                            btn.setBackground(gameLogic
                                                    .whosTurn().getPlayerColor(
                                                    ));
                                            gameLogic.slidePiece(oldPlace, btn);
                                            oldPlace.setBackground(tan);
                                            if (checkForThree(btn)) {
                                                removalTime = true;
                                                midturnSwitch = false;
                                                return;
                                            }
                                            midturnSwitch = false;
                                            gameLogic.changeTurn(gameLogic
                                                    .whosTurn());
                                            return;
                                        }
                                    }
                                }
                            }
                        } catch (IllegalArgumentException exception) {
                            midturnSwitch = false;
                            return;
                        }
                    }
                }
        }
    }

    /**
     * This class is another ActionListener class that is only used when a
     * player has created a run of 3 pieces in a row. It is used to remove an
     * opponents piece from play.
     */
    private class RemovalListener implements ActionListener {
        /**
         * This method is used to remove a piece from play once the other
         * player has created a run. The local JButton variable "forRemoval" is
         * used to store a reference to the piece being removed. The method
         * first checks the owner of the piece, and if it is itself in a run,
         * then the source is set to null and the method returns. If the piece
         * is able to be removed, it is removed from all associated ArrayLists,
         * the integer representing the player's pieces in play is updated, and
         * the color of the JButton in the panel is changed back to tan. The
         * turn is concluded and the game continues.
         * @param e the ActionEvent being responded to.
         */
        @Override
        public void actionPerformed(final ActionEvent e) {
            JButton forRemoval = new JButton();
            if (removalTime) {
                JComponent comp = (JComponent) e.getSource();
                for (int row = 0; row < BOARD_SIZE_13; row++) {
                    for (int col = 0; col < BOARD_SIZE_13; col++) {
                        if (board[row][col] == comp) {
                            forRemoval = board[row][col];
                        }
                    }
                }
                if (gameLogic.whosTurn().checkIfMyPiece(forRemoval)) {
                    e.setSource(null);
                    return;
                }
                if (gameLogic.getOtherPlayer().checkIfMyPiece(forRemoval)) {
                    if (checkForThree(forRemoval)) {
                        mistakeCount += 1;
                        if (mistakeCount > gameLogic.getOtherPlayer()
                                .getMyPlacedPieces().size()) {
                            int test = JOptionPane.showConfirmDialog(null,
                                    "Cannot remove a piece that is in a run."
                                            + "\n" + "If you have no possible "
                                            + "moves, hit Yes to end your "
                                            + "turn.", null, JOptionPane
                                            .YES_NO_OPTION);
                            switch (test) {
                                case 0:
                                    e.setSource(null);
                                    removalTime = false;
                                    gameLogic.changeTurn(gameLogic.whosTurn());
                                    mistakeCount = 0;
                                    return;
                                case 1:
                                    e.setSource(null);
                                    return;
                                default:
                                    e.setSource(null);
                                    return;
                            }
                        }
                        e.setSource(null);
                        return;
                        } else if (!checkForThree(forRemoval)) {
                        forRemoval.setBackground(tan);
                        gameLogic.removePiece(forRemoval);
                        gameLogic.changeTurn(gameLogic.whosTurn());
                        e.setSource(null);
                        mistakeCount = 0;
                        removalTime = false;
                        if (gameLogic.gameOver()) {
                            mistakeCount = 0;
                            int test = JOptionPane.showConfirmDialog(null,
                                    "Game Over! " + gameLogic.winningPlayer()
                                            .printPlayerColor() + " won!" + "\n"
                                            + "\n" + "Play again?", null,
                                            JOptionPane.YES_NO_OPTION);
                            switch (test) {
                                case 0:
                                    endGame();
                                    return;
                                case 1:
                                    System.exit(1);
                                default:
                                    break;
                            }
                        }
                        System.out.println("Does it go here ever?");
                        removalTime = false;
                        return;
                    }
                }
            }
        }
    }

    /**
     * This class is the last ActionListener, and is used during the final
     * phase of the game, when a player has only three pieces left in play.
     */
    private class MoveListener implements ActionListener {
        /**
         *A local boolean variable that is used to differentiate between
         * the part of the turn where the player selects the peice they want to
         * move, and selecting the location they would like to move it to.
         */
        private boolean timeToMove = false;
        /**
         * A local JButton variable used to store a reference to the original
         * location of the piece that is being moved.
         */
        private JButton moveFrom = new JButton();
        /**
         * A local JButton variable used to store a reference to the location
         * of where on the board the piece is being moved to.
         */
        private JButton moveTo = new JButton();

        /**
         * This method is triggered when a player has only three pieces left
         * in play. The player is able to move a selected piece to any open
         * spot on the board. The boolean timeToMove is used to trigger this
         * methodThe method first makes sure that the turn count is greater
         * than 9. This is to prevent the method from triggering after a
         * player places their third piece at the beginning of the game. The
         * method uses similar logic to the slide ActionListener method. It
         * checks to ensure that the move is legal, then removes the JButton
         * that represents the pieces original location from the necessary
         * ArrayLists, changes the colors of the necessary JButtons, and then
         * changes the turn before finishing.
         * @param e the ActionEvent
         */
        @Override
        public void actionPerformed(final ActionEvent e) {
            if ((gameLogic.whosTurn().getTurnCounter() > TURN_9)
                    && (gameLogic.whosTurn().getMyPlacedPieces().size()
                    == PIECE_3) && (!removalTime)) {
                if (!timeToMove) {
                    JComponent comp = (JComponent) e.getSource();
                    moveFrom = (JButton) comp;
                    if (!gameLogic.whosTurn().checkIfMyPiece(moveFrom)) {
                        JOptionPane.showMessageDialog(null,
                                "That's not your piece!");
                        moveFrom = null;
                        e.setSource(null);
                        return;
                    } else {
                        timeToMove = true;
                        return;
                    }
                }
            }
            if (timeToMove) {
                JComponent comp = (JComponent) e.getSource();
                for (int row = 0; row < BOARD_SIZE_13; row++) {
                    for (int col = 0; col < BOARD_SIZE_13; col++) {
                        if (board[row][col] == comp) {
                            moveTo = board[row][col];
                            break;
                        }
                    }
                }
                if (moveTo.equals(moveFrom)) {
                    e.setSource(null);
                    return;
                }
                if (gameLogic.getOtherPlayer().checkIfMyPiece(moveTo)) {
                    JOptionPane.showMessageDialog(null, "Can't move onto your"
                            + " opponents piece!");
                    e.setSource(null);
                    return;
                }
                if (gameLogic.whosTurn().checkIfMyPiece(moveTo)) {
                    JOptionPane.showMessageDialog(null, "You already have a "
                            + "piece there!");
                    e.setSource(null);
                    return;
                }
                moveTo.setBackground(gameLogic.whosTurn().getPlayerColor());
                gameLogic.movePiece(moveFrom, moveTo);
                moveFrom.setBackground(tan);
                System.out.println(checkForThree(moveTo));
                if (checkForThree(moveTo)) {
                    removalTime = true;
                    timeToMove = false;
                    return;
                } else if (!checkForThree(moveTo)) {
                    timeToMove = false;
                    gameLogic.changeTurn(gameLogic.whosTurn());
                    return;
                }
            }
            timeToMove = false;
            return;
        }
    }
    boolean validSlide(final JButton startBtn, final JButton endBtn) {
        for (JButton button: gameLogic.getPlacedPieces()) {
            if (button.equals(endBtn)) {
                return false;
            }
        }
        for (JButton btn: possibleMoves(startBtn)) {
            if (btn.equals(endBtn)) {
                return true;
            }
        }
        return false;
    }

    ArrayList<JButton> possibleMoves(final JButton startBtn) {
        int startX = 0;
        int startY = 0;
        for (int row = 0; row < BOARD_SIZE_13; row++) {
            for (int col = 0; col < BOARD_SIZE_13; col++) {
                if (board[row][col] == startBtn) {
                    startX = row;
                    startY = col;
                }
            }
        }
        ArrayList<JButton> moves = new ArrayList<>();

        if (startX == BOARD_0) {
            if (startY == BOARD_0) {
                moves.add(board[BOARD_0][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_0]);
                return moves;
            }
            if (startY == BOARD_6) {
                moves.add(board[BOARD_0][BOARD_0]);
                moves.add(board[BOARD_0][BOARD_12]);
                moves.add(board[BOARD_2][BOARD_6]);
                return moves;
            }
            if (startY == BOARD_12) {
                moves.add(board[BOARD_0][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_12]);
                return moves;
            }
        }
        if (startX == BOARD_2) {
            if (startY == BOARD_2) {
                moves.add(board[BOARD_2][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_2]);
                return moves;
            }
            if (startY == BOARD_6) {
                moves.add(board[BOARD_2][BOARD_2]);
                moves.add(board[BOARD_0][BOARD_6]);
                moves.add(board[BOARD_2][BOARD_10]);
                moves.add(board[BOARD_4][BOARD_6]);
                return moves;
            }
            if (startY == BOARD_10) {
                moves.add(board[BOARD_2][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_10]);
                return moves;
            }
        }
        if (startX == BOARD_4) {
            if (startY == BOARD_4) {
                moves.add(board[BOARD_4][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_4]);
                return moves;
            }
            if (startY == BOARD_6) {
                moves.add(board[BOARD_2][BOARD_6]);
                moves.add(board[BOARD_4][BOARD_4]);
                moves.add(board[BOARD_4][BOARD_8]);
                return moves;
            }
            if (startY == BOARD_8) {
                moves.add(board[BOARD_4][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_8]);
                return moves;
            }
        }
        if (startX == BOARD_6) {
            if (startY == BOARD_0) {
                moves.add(board[BOARD_0][BOARD_0]);
                moves.add(board[BOARD_12][BOARD_0]);
                moves.add(board[BOARD_6][BOARD_2]);
                return moves;
            }
            if (startY == BOARD_2) {
                moves.add(board[BOARD_6][BOARD_0]);
                moves.add(board[BOARD_2][BOARD_2]);
                moves.add(board[BOARD_10][BOARD_2]);
                moves.add(board[BOARD_6][BOARD_4]);
                return moves;
            }
            if (startY == BOARD_4) {
                moves.add(board[BOARD_6][BOARD_2]);
                moves.add(board[BOARD_4][BOARD_4]);
                moves.add(board[BOARD_8][BOARD_4]);
                return moves;
            }
            if (startY == BOARD_8) {
                moves.add(board[BOARD_4][BOARD_8]);
                moves.add(board[BOARD_8][BOARD_8]);
                moves.add(board[BOARD_6][BOARD_10]);
                return moves;
            }
            if (startY == BOARD_10) {
                moves.add(board[BOARD_6][BOARD_8]);
                moves.add(board[BOARD_6][BOARD_12]);
                moves.add(board[BOARD_2][BOARD_10]);
                moves.add(board[BOARD_10][BOARD_10]);
                return moves;
            }
            if (startY == BOARD_12) {
                moves.add(board[BOARD_6][BOARD_10]);
                moves.add(board[BOARD_0][BOARD_12]);
                moves.add(board[BOARD_12][BOARD_12]);
                return moves;
            }
        }
        if (startX == BOARD_8) {
            if (startY == BOARD_4) {
                moves.add(board[BOARD_6][BOARD_4]);
                moves.add(board[BOARD_8][BOARD_6]);
                return moves;
            }
            if (startY == BOARD_6) {
                moves.add(board[BOARD_8][BOARD_4]);
                moves.add(board[BOARD_8][BOARD_8]);
                moves.add(board[BOARD_10][BOARD_6]);
                return moves;
            }
            if (startY == BOARD_8) {
                moves.add(board[BOARD_8][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_8]);
                return moves;
            }
        }
        if (startX == BOARD_10) {
            if (startY == BOARD_2) {
                moves.add(board[BOARD_6][BOARD_2]);
                moves.add(board[BOARD_10][BOARD_6]);
                return moves;
            }
            if (startY == BOARD_6) {
                moves.add(board[BOARD_10][BOARD_2]);
                moves.add(board[BOARD_10][BOARD_10]);
                moves.add(board[BOARD_8][BOARD_6]);
                moves.add(board[BOARD_12][BOARD_6]);
                return moves;
            }
            if (startY == BOARD_10) {
                moves.add(board[BOARD_10][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_10]);
                return moves;
            }
        }
        if (startX == BOARD_12) {
            if (startY == BOARD_0) {
                moves.add(board[BOARD_6][BOARD_0]);
                moves.add(board[BOARD_12][BOARD_6]);
                return moves;
            }
            if (startY == BOARD_6) {
                moves.add(board[BOARD_12][BOARD_0]);
                moves.add(board[BOARD_12][BOARD_12]);
                moves.add(board[BOARD_10][BOARD_6]);
                return moves;
            }
            if (startY == BOARD_12) {
                moves.add(board[BOARD_12][BOARD_6]);
                moves.add(board[BOARD_6][BOARD_12]);
                return moves;
            }
        }
        return moves;
    }
    private boolean checkForThree(final JButton placedBtn) {
        NineMensMorrisPlayer whosIsIt = gameLogic.whosPiece(placedBtn);
        int x = 0;
        int y = 0;
        for (int row = 0; row < BOARD_SIZE_13; row++) {
            for (int col = 0; col < BOARD_SIZE_13; col++) {
                if (board[row][col] == placedBtn) {
                    x = row;
                    y = col;
                }
            }
        }
        if (x == BOARD_0) {
                if (y == BOARD_0) {

                    if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_6])) {
                        if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_12])) {
                            return true;
                        }
                    }
                    if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_0])) {
                        if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_0])) {
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
                if (y == BOARD_6) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_0])) {
                        if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_12])) {
                            return true;
                        }
                    }
                    if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_6])) {
                        if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_6])) {
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
                if (y == BOARD_12) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_6])) {
                        if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_0])) {
                            return true;
                        }
                    }
                    if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_6])) {
                        if (whosIsIt.checkIfMyPiece(board[BOARD_12]
                                [BOARD_12])) {
                            return true;
                        }
                    } else {
                        return false;
                    }
                }
        }
        if (x == BOARD_2) {
            if (y == BOARD_2) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_10])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_2])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_2])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_6) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_2])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_10])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_6])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_10) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_2])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_6])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_10])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_10])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        if (x == BOARD_4) {
            if (y == BOARD_4) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_8])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_4])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_4])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_6) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_4])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_8])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_6])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_8) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_4])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_6])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_8])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_8])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        if (x == BOARD_6) {
            if (y == BOARD_0) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_0])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_0])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_2])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_4])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_2) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_0])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_4])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_2])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_2])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_4) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_4])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_8])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_0])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_2])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_8) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_8])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_8])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_10])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_12])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_10) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_8])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_12])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_10])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_10])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_12) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_12])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_12])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_8])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_10])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        if (x == BOARD_8) {
            if (y == BOARD_4) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_8])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_4])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_4])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_6) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_4])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_8])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_6])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_8) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_4])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_6])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_8])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_4][BOARD_8])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        if (x == BOARD_10) {
            if (y == BOARD_2) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_10])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_2])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_2])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_6) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_2])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_10])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_6])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_10) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_2])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_10])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_2][BOARD_10])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        if (x == BOARD_12) {
            if (y == BOARD_0) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_0])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_0])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_12])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_6) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_0])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_12])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_10][BOARD_6])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_8][BOARD_6])) {
                        return true;
                    }
                } else {
                    return false;
                }
            }
            if (y == BOARD_12) {
                if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_0])) {
                    if (whosIsIt.checkIfMyPiece(board[BOARD_12][BOARD_6])) {
                        return true;
                    }
                }
                if (whosIsIt.checkIfMyPiece(board[BOARD_6][BOARD_12])) {
                    return whosIsIt.checkIfMyPiece(board[BOARD_0][BOARD_12]);
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    void endGame() {
        gameLogic.reset();
        removalTime = false;
        for (int row = 0; row < BOARD_SIZE_13; row++) {
            for (int col = 0; col < BOARD_SIZE_13; col++) {
                if (row == BOARD_0 && (col == BOARD_0 || col == BOARD_6
                        || col == BOARD_12)) {
                    board[row][col].setBackground(tan);
                }
                if (row == BOARD_2 && (col == BOARD_2 || col == BOARD_6
                        || col == BOARD_10)) {
                    board[row][col].setBackground(tan);
                }
                if (row == BOARD_4 && (col == BOARD_4 || col == BOARD_6
                        || col == BOARD_8)) {
                    board[row][col].setBackground(tan);
                }
                if (row == BOARD_6 && (col == BOARD_0 || col == BOARD_2
                        || col == BOARD_4 || col == BOARD_8
                        || col == BOARD_10 || col == BOARD_12)) {
                    board[row][col].setBackground(tan);
                }
                if (row == BOARD_8 && (col == BOARD_4 || col == BOARD_6
                        || col == BOARD_8)) {
                    board[row][col].setBackground(tan);
                }
                if (row == BOARD_10 && (col == BOARD_2 || col == BOARD_6
                        || col == BOARD_10)) {
                    board[row][col].setBackground(tan);
                }
                if (row == BOARD_12 && (col == BOARD_0 || col == BOARD_6
                        || col == BOARD_12)) {
                    board[row][col].setBackground(tan);
                }
            }
        }
    }
}

