package SuiteOfGames;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * LiarGUI holds the JFrame that will be seen by the code, and whats executed
 * to start the program.
 *
 *@author Collin Turkelson
 */
public final class LiarsGUI {

    /**
     * Panel that holds the information for the board.
     */
    private LiarPanel boardPanel;
    /**
     * Panel that holds the information for the rules.
     */
    private JPanel rule;
    /**
     * First label for the rules.
     */
    private JLabel rule1;
    /**
     * Second label for the rules.
     */
    private JLabel rule2;
    /**
     * Third label for the rules.
     */
    private JLabel rule3;
    /**
     * Fourth label for the rules.
     */
    private JLabel rule4;
    /**
     * Fifth label for the rules.
     */
    private JLabel rule5;
    /**
     * Sixth label for the rules.
     */
    private JLabel rule6;
    /**
     * Seventh label for the rules.
     */
    private JLabel rule7;
    /**
     * Eighth label for the rules.
     */
    private JLabel rule8;
    /**
     * Ninth label for the rules.
     */
    private JLabel rule9;
    /**
     * Tenth label for the rules.
     */
    private JLabel rule10;
    /**
     * Eleventh label for the rules.
     */
    private JLabel rule11;
    /**
     * Twelfth label for the rules.
     */
    private JLabel rule12;
    /**
     * Thirteenth label for the rules.
     */
    private JLabel rule13;
    /**
     * Fourteenth label for the rules.
     */
    private JLabel rule14;
    /**
     * The window for the game.
     */
    private JFrame board;
    /**
     * The window explaining the rules.
     */
    private JFrame rules;
    /**
     * Background color for the JFrame.
     */
    private Color darkGreen;
    /**
     * Constructor making the window of the game.
     */
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:MagicNumber"})
    public LiarsGUI(MainMenu menu) {
        //Initializing color
        darkGreen = new Color(0, 153, 0);
        //Initializing panel
        boardPanel = new LiarPanel(menu);
        //Initializing frame
        board  = new JFrame();
        //Initializing Rules frame and the items in it
        rules = new JFrame("Rules");
        rule1 = new JLabel();
        rule2 = new JLabel();
        rule3 = new JLabel();
        rule4 = new JLabel();
        rule5 = new JLabel();
        rule6 = new JLabel();
        rule7 = new JLabel();
        rule8 = new JLabel();
        rule9 = new JLabel();
        rule10 = new JLabel();
        rule11 = new JLabel();
        rule12 = new JLabel();
        rule13 = new JLabel();
        rule14 = new JLabel();
        rule = new JPanel();
        //Making the rules pane
        rulesPanel();
        //Adding the panel to the frame
        board.getContentPane().add(boardPanel);
        rules.getContentPane().add(rule);
        //setting the board and rules visible
        board.setVisible(true);
        rules.setVisible(true);
        rules.pack();

        //Setting the board size
        board.setSize(1000, 1000);
        //board.pack();
        //setting the boards background color
        board.setBackground(darkGreen);


    }
    private void rulesPanel() {
        rule.setLayout(new BoxLayout(rule, BoxLayout.PAGE_AXIS));
        rule1.setText("The Rules Of Liars Dice: ");
        rule2.setText("Each player has a set of 5"
                + " dice that only they can see.");
        rule3.setText("To play a player will guess"
                + " a quantity of a dice value.");
        rule4.setText("The player will be guessing on the total quantity"
                + " of a dice value among the players.");
        rule5.setText("Every game will start with jack, and rotate clockwise"
               + " as each player takes their turn.");
        rule6.setText("After jack starts Blackbeard can either make"
               + " another guess, or call jack a liar.");
        rule7.setText("If Blackbeard makes another guess he can either:");
        rule8.setText("          Increment the quantity of the dice value"
                + " already guessed");
        rule9.setText("                           or");
        rule10.setText("           Increase the dice value which will"
                + " reset the amount that Blackbeard can guess");
         rule11.setText("If Blackbeard calls jack a liar:");
         rule12.setText("          Jacks guess will be compared to the total"
                + " amount on the board.");
         rule13.setText("          If Jacks guess is less than or equal to"
                + " the total Jack wins and Blackbeard loses.");
         rule14.setText("          If Jacks guess is more than the total Jack"
                + " loses and Blackbeard wins.");
         rule.add(rule1);
         rule.add(rule2);
         rule.add(rule3);
         rule.add(rule4);
         rule.add(rule5);
         rule.add(rule6);
         rule.add(rule7);
         rule.add(rule8);
         rule.add(rule9);
         rule.add(rule10);
         rule.add(rule11);
         rule.add(rule12);
         rule.add(rule13);
         rule.add(rule14);

    }
}