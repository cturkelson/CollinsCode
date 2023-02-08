package SuiteOfGames;

import java.util.Random;

/**
 * dice is the class that chooses a random number 1-6.
 * It will assign 5 numbers from this range to each player as dice values.
 *
 * @author Collin Turkelson
 */
public class Dice {
    /**
     * roll is the random number generator used for the dice.
     */
    private Random roll;

    /**
     * jackSet is a 5 int array containing player jacks dice set.
     */
    private int[] jackSet;

    /**
     * blackSet is a 5 int array containing player blacks dice set.
     */
    private int[] blackSet;

    /**
     * hookSet is a 5 int array containing player hooks dice set.
     */
    private int[] hookSet;

    /**
     * willSet is a 5 int array containing player wills dice set.
     */
    private int[] willSet;

    /**
     * A set of sets that will hold each of the players sets.
     * Each set is in order of their ordinal.
     */
    private int[][] set;

    /**
     * Total amount of dice value ones on the table.
     */
    private int one;

    /**
     * Total amount of dice value twos on the table.
     */
    private int two;

    /**
     * Total amount of dice value threes on the table.
     */
    private int three;

    /**
     * Total amount of dice value fours on the table.
     */
    private int four;

    /**
     * Total amount of dice value fives on the table.
     */
    private int five;

    /**
     * Total amount of dice value sixes on the table.
     */
    private int six;

    /**
     * Array of 6 int containing the amount of each dice value.
     */
    private int[] total;

    /**
     * Constructor setting up each set and initializing each dice value.
     */
    public Dice() {
        roll = new Random();
        jackSet = new int[5];
        blackSet = new int[5];
        hookSet = new int[5];
        willSet = new int[5];
        set = new int[4][5];
        total = new int[6];
        one = 0;
        two = 0;
        three = 0;
        four = 0;
        five = 0;
        six = 0;
    }

    /**
     * Board roll sets each total to 0, and generates each players set of die.
     * @return set which is an array of arrays containing all the dice on the
     * table.
     */
    public int[][] boardRoll() {
        one = 0;
        two = 0;
        three = 0;
        four = 0;
        five = 0;
        six = 0;
        jackRoll();
        blackRoll();
        hookRoll();
        willRoll();

        for (int i = 0; i < 5; i++) {
            set[0][i] = jackSet[i];
            set[1][i] = blackSet[i];
            set[2][i] = hookSet[i];
            set[3][i] = willSet[i];

        }
        total[0] = one;
        total[1] = two;
        total[2] = three;
        total[3] = four;
        total[4] = five;
        total[5] = six;


        return this.set;
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
     * Generates 5 random numbers between 1-6 and stores them in jackSet.
     */
    private void jackRoll() {
        for (int i = 0; i < 5; i++) {
            int roll1 = roll.nextInt(6) + 1;
            this.jackSet[i] = roll1;
            switch (roll1) {
                case 1:
                    one = one + 1;
                    break;
                case 2:
                    two = two + 1;
                    break;
                case 3:
                    three = three + 1;
                    break;
                case 4:
                    four = four + 1;
                    break;
                case 5:
                    five = five + 1;
                    break;
                case 6:
                    six = six + 1;
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * Generates 5 random numbers between 1-6 and stores them in blackSet.
     */
    private void blackRoll() {
        for (int i = 0; i < 5; i++) {
            int roll1 = roll.nextInt(6) + 1;
            blackSet[i] = roll1;
            switch (roll1) {
                case 1:
                    one = one + 1;
                    break;
                case 2:
                    two = two + 1;
                    break;
                case 3:
                    three = three + 1;
                    break;
                case 4:
                    four = four + 1;
                    break;
                case 5:
                    five = five + 1;
                    break;
                case 6:
                    six = six + 1;
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * Generates 5 random numbers between 1-6 and stores them in hookSet.
     */
    private void hookRoll() {
        for (int i = 0; i < 5; i++) {
            int roll1 = roll.nextInt(6) + 1;
            hookSet[i] = roll1;
            switch (roll1) {
                case 1:
                    one = one + 1;
                    break;
                case 2:
                    two = two + 1;
                    break;
                case 3:
                    three = three + 1;
                    break;
                case 4:
                    four = four + 1;
                    break;
                case 5:
                    five = five + 1;
                    break;
                case 6:
                    six = six + 1;
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * Generates 5 random numbers between 1-6 and stores them in willSet.
     */
    private void willRoll() {
        for (int i = 0; i < 5; i++) {
            int roll1 = roll.nextInt(6) + 1;
            willSet[i] = roll1;
            switch (roll1) {
                case 1:
                    one = one + 1;
                    break;
                case 2:
                    two = two + 1;
                    break;
                case 3:
                    three = three + 1;
                    break;
                case 4:
                    four = four + 1;
                    break;
                case 5:
                    five = five + 1;
                    break;
                case 6:
                    six = six + 1;
                    break;
                default:
                    break;
            }
        }

    }

}
