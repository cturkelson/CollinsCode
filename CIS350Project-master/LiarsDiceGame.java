package SuiteOfGames;

/**
 * LiarsDiceGame holds the functionality of the game.
 * This class will generate each player, and their die.
 * It will also hold the information of each guess and decide
 * whether a player is lying or not.
 *
 * @author Collin Turkelson
 */
public class LiarsDiceGame {
    /**
     * The current player in the game.
     */
    private Player current;

    /**
     * The previous player in the game.
     */
    private Player prev;

    /**
     * Variable that holds valueGuess.
     */
    private int valueGuess;

    /**
     * Variable that holds amountGuess.
     */
    private int amountGuess;

    /**
     * Dice for the game.
     */
    private Dice dice;

    /**
     * Initializing the double int array that will be the boards dice.
     */
    private int[][]roll;

    /**
     * Array of 6 int containing the amount of each dice value.
     */
    private int[] total;

    /**
     * Reference to the MainMenu.
     * Allows me to alter the data in the constructors parameter.
     */
    private MainMenu mainMenu;

    /**
     * Constructor for the functionality of the game.
     * Sets the current and previous player, and gathers
     * the dice information.
     * @param menu Object responsible for holding the wins and loss statistics.
     */
    public LiarsDiceGame(MainMenu menu) {

        //setting the mainMenu reference
        mainMenu = menu;

        //initializing the current and previous player
        current = Player.Jack;
        prev = Player.Will;

        //initializing the dice
        dice = new Dice();
        roll =  dice.boardRoll();
        total = dice.getTotal();

    }

    /**
     * Sets the current and previous players to the next players.
     */
    public void nextTurn() {

        current = current.next();
        prev = prev.next();
    }

    /**
     * Method that increments each players wins and losses.
     * @param winner Holds the player who won, incrementing their wins.
     * @param loser Holds the player who lost, incrementing their losses.
     */
    public void stats(Player winner, Player loser) {
        if (winner == Player.Jack) {
            mainMenu.getSparrowWin();
        }
        if (winner == Player.Black) {
            mainMenu.getBlackbeardWin();
        }
        if (winner == Player.Hook) {
            mainMenu.getHookWin();
        }
        if (winner == Player.Will) {
            mainMenu.getTurnerWin();
        }
        if (loser == Player.Jack) {
            mainMenu.getSparrowLoss();
        }
        if (loser == Player.Black) {
            mainMenu.getBlackbeardLoss();
        }
        if (loser == Player.Hook) {
            mainMenu.getHookLoss();
        }
        if (loser == Player.Will) {
            mainMenu.getTurnerLoss();
        }
    }

    /**
     * Resets the current and prev player and gathers new dice information.
     */
    public void reset() {
        current = Player.Jack;
        prev = Player.Will;

        roll =  dice.boardRoll();
        total = dice.getTotal();
    }

    /**
     * Returns an array containing the total amount for each dice value.
     * @return total an array where the total amount for dice value 1 will
     * be stored in total[diceValue - 1].
     */
    public int[] getTotal() {
        return total;
    }

    /**
     * Returns the board roll for the LiarPanel.
     * @return roll, an array of arrays containing each
     * players set of dice.
     */
    public int[][] getRoll() {
        return roll;
    }

    /**
     * Getter method that returns whose turn it is.
     * @return current, the current player to make a guess.
     */
    Player returnCurrent() {
        return current;
    }

    /**
     * Getter method that returns whose just took their turn.
     * @return prev, the Player who just made a guess.
     */
    public Player returnPrev() {
        return prev;
    }


    /**
     * Sets the value of the dice being guessed.
     * @param guess the value that the player is guessing.
     */
    public void setValueGuess(final int guess) {
        this.valueGuess = guess;
    }

    /**
     * Gets the value of the dice being guessed.
     */
    public int getValueGuess() {
        return this.valueGuess;
    }

    /**
     * Sets the amount of the value being guessed.
     * @param guess the amount of the value that the player is guessing.
     */
    public void setAmountGuess(final int guess) {
        this.amountGuess = guess;
    }

    /**
     * Gets the amount of the value being guessed.
     */
    public int getAmountGuess() {
        return this.amountGuess;
    }
    /**
     * Method that decides if a player was lying or not.
     * @return true or False depending on if the player is lying
     * or not.
     */
    public boolean liar() {
        if (total[valueGuess - 1] >= amountGuess) {
            return false;
        }
        return true;
    }
}
