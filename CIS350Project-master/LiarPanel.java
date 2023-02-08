package SuiteOfGames;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * LiarPanel holds each player button, the liar and guess buttons,
 * table label along with status and state labels, and combo boxes.
 *
 * @author Collin Turkelson
 */
public class LiarPanel extends JPanel implements ActionListener {
    /**
     * Label under the diceBox combo box.
     */
    private JLabel valueLabel;

    /**
     * Label under the valueAmount combo box.
     */
    private JLabel amountLabel;

    /**
     * Set of dice array for each player.
     */
    private JButton[] setOfDiceArray = new JButton[5];

    /**
     * Panel that holds each players set of dice.
     */
    private JPanel dicePanel;

    /**
     * Liar's Button.
     */
    private JButton liar;

    /**
     * Label stating what the guess is.
     */
    private JLabel status;

    /**
     * Label containing the variables of the current guess.
     */
    private JLabel status2;

    /**
     * Int that changes when a guess is made.
     * Adds functionality to the liar button.
     */
    private int guessed;

    /**
     * diceOne bufferedImage is the object the pulls the dice png.
     */
    private BufferedImage diceOne;

    /**
     * dice1 will resize to the dice value 1.
     * Used a bufferImage to get a subimage of the dice.
     */
    private BufferedImage dice1;

    /**
     * dice1Icon is what dice1 will be converted to.
     * This imageIcon will be set to whatever player rolls a 1.
     */
    private ImageIcon dice1Icon;

    /**
     * diceButton1 what holds the icon for the first dice value.
     */
    private JButton diceButton1;

    /**
     * diceTwo bufferedImage is the object the pulls the dice png.
     */
    private BufferedImage diceTwo;

    /**
     * dice2 will resize to the dice value 2.
     * Used a bufferImage to get a subimage of the dice.
     */
    private BufferedImage dice2;

    /**
     * dice2Icon is what dice1 will be converted to.
     * This imageIcon will be set to whatever player rolls a 2.
     */
    private ImageIcon dice2Icon;

    /**
     * diceButton2 what holds the icon for the second dice value.
     */
    private JButton diceButton2;

    /**
     * diceThree bufferedImage is the object the pulls the dice png.
     */
    private BufferedImage diceThree;

    /**
     * dice3 will resize to the dice value 3.
     * Used a bufferImage to get a subimage of the dice.
     */
    private BufferedImage dice3;

    /**
     * dice3Icon is what dice1 will be converted to.
     * This imageIcon will be set to whatever player rolls a 3.
     */
    private ImageIcon dice3Icon;

    /**
     * diceButton3 what holds the icon for the third dice value.
     */
    private JButton diceButton3;

    /**
     * diceFour bufferedImage is the object the pulls the dice png.
     */
    private BufferedImage diceFour;

    /**
     * dice4 will resize to the dice value 4.
     * Used a bufferImage to get a subimage of the dice.
     */
    private BufferedImage dice4;

    /**
     * dice4Icon is what dice1 will be converted to.
     * This imageIcon will be set to whatever player rolls a 4.
     */
    private ImageIcon dice4Icon;

    /**
     * diceButton4 what holds the icon for the fourth dice value.
     */
    private JButton diceButton4;

    /**
     * diceFive bufferedImage is the object the pulls the dice png.
     */
    private BufferedImage diceFive;

    /**
     * dice5 will resize to the dice value 5.
     * Used a bufferImage to get a subimage of the dice.
     */
    private BufferedImage dice5;

    /**
     * dice5Icon is what dice1 will be converted to.
     * This imageIcon will be set to whatever player rolls a 5.
     */
    private ImageIcon dice5Icon;

    /**
     * diceButton5 what holds the icon for the fifth dice value.
     */
    private JButton diceButton5;

    /**
     * diceSix bufferedImage is the object the pulls the dice png.
     */
    private BufferedImage diceSix;

    /**
     * dice6 will resize to the dice value 6.
     * Used a bufferImage to get a subimage of the dice.
     */
    private BufferedImage dice6;

    /**
     * dice6Icon is what dice1 will be converted to.
     * This imageIcon will be set to whatever player rolls a 6.
     */
    private ImageIcon dice6Icon;

    /**
     * Combo box for dice value.
     */
    private JComboBox diceBox;

    /**
     * Combo box for value amount.
     */
    private JComboBox valueAmount;

    /**
     * Button for each player to make a guess.
     */
    private JButton guess;

    /**
     * Button that contains jacks set of die.
     */
    private JButton jack;

    /**
     * Button that contains wills set of die.
     */
    private JButton will;

    /**
     * Button that contains hooks set of die.
     */
    private JButton hook;

    /**
     * Button that contains blacks set of die.
     */
    private JButton black;

    /**
     * Rolling each players dice.
     * Calls on game class which holds the dice information.
     */
    private int[][]roll;

    /**
     * The display for each players dice.
     * Holds 5 buttons, each with the icon of the stored dice value.
     */
    private JFrame setOfDie;

    /**
     * Color for the liar button.
     */
    private Color red;

    /**
     * Color for the current player.
     */
    private Color blue;

    /**
     * Game's functionality class.
     * Holds the games functional data.
     */
    private LiarsDiceGame game;

    /**
     * Int containing the amount of the dice value was guessed.
     * Converts an object into an int.
     */
    private int amountGuess;

    /**
     * Int containing the value of the dice which was guessed.
     * Converts an object into an int.
     */
    private int valueGuess;

    /**
     * JLabel stating whose turn it is.
     * Changes as each player makes a guess.
     */
    private JLabel state;

    /**
     * Value that was previously guessed.
     * Used to compare to the value attempting to be guessed.
     */
    private int oldValue;

    /**
     * Amount that was previously guessed.
     * Used to compare to the amount attempting to be guessed.
     */
    private int oldAmount;

    /**
     * Int array containing the dice value on the board.
     * Holds 6 characters, each index is -1 from the face value.
     */
    private int[] totals;

    /**
     * Constructor for the class LiarPanel.
     */
    public LiarPanel(MainMenu menu) {
        //Initialize game and dice value
        game = new LiarsDiceGame(menu);
        roll = game.getRoll();
        oldValue = 1;
        totals = game.getTotal();
        guessed = 0;

        //Initialize liar and current player button colors
        red = new Color(255, 55, 55);
        blue = new Color(55, 200, 255);

        //Initialize dice Panel
        dicePanel = new JPanel();

        // Frame showing the players set of dice
        setOfDie = new JFrame();

        //setting the icons
        setIcon();

        //Initalizing the jlabels
        amountLabel = new JLabel("The Amount of 1");
        valueLabel = new JLabel("Dice Value");

        //Status label
        status = new JLabel("Current guess" + "\t");
        status2 = new JLabel();

        //Initialize state
        state = new JLabel("It is " + game.returnCurrent() + "'s turn");

        //Button set up
        setUpButtons();

        //layout details
        setPreferredSize(new Dimension(1250, 750));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Setting the labels and buttons
        setUpLabelButton();

        //array of integers containing value amounts
        String[] vAmounts = {"3", "4", "5", "6", "7", "8", "9", "10"};
        valueAmount = new JComboBox(vAmounts);
        c.gridwidth = 2;
        c.gridheight = 1;
        c.gridx = 4;
        c.gridy = 10;
        add(valueAmount, c);

        c.gridy = 15;
        add(amountLabel, c);

        //array of integers containing dice values
        String[] dValue = {"1", "2", "3", "4", "5", "6"};
        diceBox = new JComboBox(dValue);
        c.gridwidth = 2;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 10;
        add(diceBox, c);

        c.gridy = 15;
        add(valueLabel, c);

        //itemListener for diceBox
        diceBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
            amountLabel.setText("The Amount of " + diceBox.getSelectedItem());
                oldAmount =
                        Integer.parseInt((String) diceBox.getSelectedItem());
                    if (oldAmount != oldValue || guessed == 0) {
                        valueAmount.removeAllItems();
                        valueAmount.addItem("3");
                        valueAmount.addItem("4");
                        valueAmount.addItem("5");
                        valueAmount.addItem("6");
                        valueAmount.addItem("7");
                        valueAmount.addItem("8");
                        valueAmount.addItem("9");
                        valueAmount.addItem("10");
                        valueAmount.setSelectedIndex(0);
                    } else {
                        switch (amountGuess) {
                            case 3:
                                valueAmount.removeAllItems();
                                valueAmount.addItem("4");
                                valueAmount.addItem("5");
                                valueAmount.addItem("6");
                                valueAmount.addItem("7");
                                valueAmount.addItem("8");
                                valueAmount.addItem("9");
                                valueAmount.addItem("10");
                                valueAmount.addItem("11");
                                valueAmount.addItem("12");
                                break;
                            case 4:
                                valueAmount.removeAllItems();
                                valueAmount.addItem("5");
                                valueAmount.addItem("6");
                                valueAmount.addItem("7");
                                valueAmount.addItem("8");
                                valueAmount.addItem("9");
                                valueAmount.addItem("10");
                                break;
                            case 5:
                                valueAmount.removeAllItems();
                                valueAmount.addItem("6");
                                valueAmount.addItem("7");
                                valueAmount.addItem("8");
                                valueAmount.addItem("9");
                                valueAmount.addItem("10");
                                break;
                            case 6:
                                valueAmount.removeAllItems();
                                valueAmount.addItem("7");
                                valueAmount.addItem("8");
                                valueAmount.addItem("9");
                                valueAmount.addItem("10");
                                break;
                            case 7:
                                valueAmount.removeAllItems();
                                valueAmount.addItem("8");
                                valueAmount.addItem("9");
                                valueAmount.addItem("10");
                                break;
                            case 8:
                                valueAmount.removeAllItems();
                                valueAmount.addItem("9");
                                valueAmount.addItem("10");
                                break;
                            case 9:
                                valueAmount.removeAllItems();
                                valueAmount.addItem("10");
                            case 10:
                                valueAmount.removeAllItems();
                                valueAmount.addItem("10");
                            default:
                                break;
                        }
                    }


            }
        });

    }

    /**
     * Sets each dice value icon, table icon, and intialize te setOfDice array.
     * This function is only run in the constructor, used to lower
     * the amount of lines in the constructor.
     */
    private void setIcon() {
        //Dice 1 Icon
        try {
            diceOne = ImageIO.read(new File("resources/dice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dice1 = diceOne.getSubimage(7, 8, 96, 96);
        dice1Icon = new ImageIcon(dice1);
        diceButton1 = new JButton();

        //Dice 2 Icon
        try {
            diceTwo = ImageIO.read(new File("resources/dice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dice2 = diceTwo.getSubimage(127, 8, 96, 96);
        dice2Icon = new ImageIcon(dice2);
        diceButton2 = new JButton();

        //Dice 3 Icon
        try {
            diceThree = ImageIO.read(new File("resources/dice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dice3 = diceThree.getSubimage(246, 8, 96, 96);
        dice3Icon = new ImageIcon(dice3);
        diceButton3 = new JButton();

        //Dice 4 Icon
        try {
            diceFour = ImageIO.read(new File("resources/dice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dice4 = diceFour.getSubimage(7, 127, 96, 96);
        dice4Icon = new ImageIcon(dice4);
        diceButton4 = new JButton();

        //Dice 5 Icon
        try {
            diceFive = ImageIO.read(new File("resources/dice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dice5 = diceFive.getSubimage(126, 127, 96, 96);
        dice5Icon = new ImageIcon(dice5);
        diceButton5 = new JButton();

        //Dice 6 Icon
        try {
            diceSix = ImageIO.read(new File("resources/dice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dice6 = diceSix.getSubimage(246, 127, 96, 96);
        dice6Icon = new ImageIcon(dice6);

        //Button Array
        setOfDiceArray[0] = diceButton1;
        setOfDiceArray[1] = diceButton2;
        setOfDiceArray[2] = diceButton3;
        setOfDiceArray[3] = diceButton4;
        setOfDiceArray[4] = diceButton5;
    }

    /**
     * Initializes all the buttons on the panel.
     * This function is only run in the constructor, used to lower
     * the amount of lines in the constructor.
     */
    private void setUpButtons() {
        //Liars button
        int size = 150;
        liar = new JButton("Liar");
        liar.setPreferredSize(new Dimension(size, size / 4));
        liar.addActionListener(this);
        liar.setBackground(red);


        //Guess button
        guess = new JButton("Guess");
        guess.setPreferredSize(new Dimension(size / 2, size / 2));
        guess.addActionListener(this);


        //Jacks button
        jack = new JButton("Jack");
        jack.setPreferredSize(new Dimension(size, size));
        jack.addActionListener(this);
        jack.setBackground(blue);

        //Blacks button
        black = new JButton("Black");
        black.setPreferredSize(new Dimension(size, size));
        black.addActionListener(this);

        //hooks button
        hook = new JButton("Hook");
        hook.setPreferredSize(new Dimension(size, size));
        hook.addActionListener(this);

        //wills button
        will = new JButton("Will");
        will.setPreferredSize(new Dimension(size, size));
        will.addActionListener(this);

    }

    /**
     * Sets the buttons and labels in the correct position on the panel.
     * This function is only run in the constructor, used to lower
     * the amount of lines in the constructor.
     */
    private void setUpLabelButton() {
        //Constraints setter
            GridBagConstraints c = new GridBagConstraints();

            //setting liar button
            c.gridx = 0;
            c.gridy = 15;
            add(liar, c);

            //setting status label
            c.gridx = 0;
            c.gridy = 3;
            add(status, c);

            //setting status label
            c.gridx = 0;
            c.gridy = 4;
            add(status2, c);

            //setting jacks button
            c.gridx = 1;
            c.gridy = 3;
            add(jack, c);

            //setting blacks button
            c.gridx = 5;
            c.gridy = 3;
            add(black, c);

            //setting wills button
            c.gridx = 1;
            c.gridy = 30;
            add(will, c);

            //setting hooks button
            c.gridx = 5;
            c.gridy = 30;
            add(hook, c);

            //setting the the label stating whose turn it is
            c.gridx = 1;
            c.gridy = 0;
            c.gridheight = 1;
            add(state, c);

            //setting the guess button
            c.gridx = 3;
            c.gridy = 20;
            guess.setBackground(Color.BLUE);
            add(guess, c);
        }


    /**
     * Comparing the button pressed to different player, or functional options.
     * @param e reads which button has been pressed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
           String call = e.getActionCommand();
           if (call.compareTo("Jack") == 0) {
               jackListener();
           }
           if (call.compareTo("Black") == 0) {
               blackListener();
           }
           if (call.compareTo("Hook") == 0) {
               hookListener();
           }
           if (call.compareTo("Will") == 0) {
               willListener();
           }
           if (call.compareTo("Guess") == 0) {
               guessListener();
           }
           if (call.compareTo("Liar") == 0) {
               liarListener();
           }
       }

    /**
     * Button listener that produces jacks set of dice.
     */
    private void jackListener() {
        setOfDie = new JFrame("Jacks Set of Die");
        if (roll[0][0] == 1) {
            setOfDiceArray[0].setIcon(dice1Icon);
        }
        if (roll[0][0] == 2) {
            setOfDiceArray[0].setIcon(dice2Icon);
        }
        if (roll[0][0] == 3) {
            setOfDiceArray[0].setIcon(dice3Icon);
        }
        if (roll[0][0] == 4) {
            setOfDiceArray[0].setIcon(dice4Icon);
        }
        if (roll[0][0] == 5) {
            setOfDiceArray[0].setIcon(dice5Icon);
        }
        if (roll[0][0] == 6) {
            setOfDiceArray[0].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[0]);
        if (roll[0][1] == 1) {
            setOfDiceArray[1].setIcon(dice1Icon);
        }
        if (roll[0][1] == 2) {
            setOfDiceArray[1].setIcon(dice2Icon);
        }
        if (roll[0][1] == 3) {
            setOfDiceArray[1].setIcon(dice3Icon);
        }
        if (roll[0][1] == 4) {
            setOfDiceArray[1].setIcon(dice4Icon);
        }
        if (roll[0][1] == 5) {
            setOfDiceArray[1].setIcon(dice5Icon);
        }
        if (roll[0][1] == 6) {
            setOfDiceArray[1].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[1]);
        if (roll[0][2] == 1) {
            setOfDiceArray[2].setIcon(dice1Icon);
        }
        if (roll[0][2] == 2) {
            setOfDiceArray[2].setIcon(dice2Icon);
        }
        if (roll[0][2] == 3) {
            setOfDiceArray[2].setIcon(dice3Icon);
        }
        if (roll[0][2] == 4) {
            setOfDiceArray[2].setIcon(dice4Icon);
        }
        if (roll[0][2] == 5) {
            setOfDiceArray[2].setIcon(dice5Icon);
        }
        if (roll[0][2] == 6) {
            setOfDiceArray[2].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[2]);
        if (roll[0][3] == 1) {
            setOfDiceArray[3].setIcon(dice1Icon);
        }
        if (roll[0][3] == 2) {
            setOfDiceArray[3].setIcon(dice2Icon);
        }
        if (roll[0][3] == 3) {
            setOfDiceArray[3].setIcon(dice3Icon);
        }
        if (roll[0][3] == 4) {
            setOfDiceArray[3].setIcon(dice4Icon);
        }
        if (roll[0][3] == 5) {
            setOfDiceArray[3].setIcon(dice5Icon);
        }
        if (roll[0][3] == 6) {
            setOfDiceArray[3].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[3]);
        if (roll[0][4] == 1) {
            setOfDiceArray[4].setIcon(dice1Icon);
        }
        if (roll[0][4] == 2) {
            setOfDiceArray[4].setIcon(dice2Icon);
        }
        if (roll[0][4] == 3) {
            setOfDiceArray[4].setIcon(dice3Icon);
        }
        if (roll[0][4] == 4) {
            setOfDiceArray[4].setIcon(dice4Icon);
        }
        if (roll[0][4] == 5) {
            setOfDiceArray[4].setIcon(dice5Icon);
        }
        if (roll[0][4] == 6) {
            setOfDiceArray[4].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[4]);
        setOfDie.add(dicePanel);
        setOfDie.pack();
        setOfDie.setVisible(true);
    }

    /**
     * Button listener that produces blacks set of dice.
     */
    private void blackListener() {
        setOfDie = new JFrame("Blacks Set of Die");
        for (int i = 0; i < 5; i++) {
            if (roll[1][i] == 1) {
                setOfDiceArray[i].setIcon(dice1Icon);
            }
            if (roll[1][i] == 2) {
                setOfDiceArray[i].setIcon(dice2Icon);
            }
            if (roll[1][i] == 3) {
                setOfDiceArray[i].setIcon(dice3Icon);
            }
            if (roll[1][i] == 4) {
                setOfDiceArray[i].setIcon(dice4Icon);
            }
            if (roll[1][i] == 5) {
                setOfDiceArray[i].setIcon(dice5Icon);
            }
            if (roll[1][i] == 6) {
                setOfDiceArray[i].setIcon(dice6Icon);
            }
            dicePanel.add(setOfDiceArray[i]);
        }
        setOfDie.add(dicePanel);
        setOfDie.pack();
        setOfDie.setVisible(true);
    }

    /**
     * Button listener that produces hooks set of dice.
     */
    private void hookListener() {
        setOfDie = new JFrame("Hooks Set of Die");
        if (roll[2][0] == 1) {
            setOfDiceArray[0].setIcon(dice1Icon);
        }
        if (roll[2][0] == 2) {
            setOfDiceArray[0].setIcon(dice2Icon);
        }
        if (roll[2][0] == 3) {
            setOfDiceArray[0].setIcon(dice3Icon);
        }
        if (roll[2][0] == 4) {
            setOfDiceArray[0].setIcon(dice4Icon);
        }
        if (roll[2][0] == 5) {
            setOfDiceArray[0].setIcon(dice5Icon);
        }
        if (roll[2][0] == 6) {
            setOfDiceArray[0].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[0]);
        if (roll[2][1] == 1) {
            setOfDiceArray[1].setIcon(dice1Icon);
        }
        if (roll[2][1] == 2) {
            setOfDiceArray[1].setIcon(dice2Icon);
        }
        if (roll[2][1] == 3) {
            setOfDiceArray[1].setIcon(dice3Icon);
        }
        if (roll[2][1] == 4) {
            setOfDiceArray[1].setIcon(dice4Icon);
        }
        if (roll[2][1] == 5) {
            setOfDiceArray[1].setIcon(dice5Icon);
        }
        if (roll[2][1] == 6) {
            setOfDiceArray[1].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[1]);
        if (roll[2][2] == 1) {
            setOfDiceArray[2].setIcon(dice1Icon);
        }
        if (roll[2][2] == 2) {
            setOfDiceArray[2].setIcon(dice2Icon);
        }
        if (roll[2][2] == 3) {
            setOfDiceArray[2].setIcon(dice3Icon);
        }
        if (roll[2][2] == 4) {
            setOfDiceArray[2].setIcon(dice4Icon);
        }
        if (roll[2][2] == 5) {
            setOfDiceArray[2].setIcon(dice5Icon);
        }
        if (roll[2][2] == 6) {
            setOfDiceArray[2].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[2]);
        if (roll[2][3] == 1) {
            setOfDiceArray[3].setIcon(dice1Icon);
        }
        if (roll[2][3] == 2) {
            setOfDiceArray[3].setIcon(dice2Icon);
        }
        if (roll[2][3] == 3) {
            setOfDiceArray[3].setIcon(dice3Icon);
        }
        if (roll[2][3] == 4) {
            setOfDiceArray[3].setIcon(dice4Icon);
        }
        if (roll[2][3] == 5) {
            setOfDiceArray[3].setIcon(dice5Icon);
        }
        if (roll[2][3] == 6) {
            setOfDiceArray[3].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[3]);
        if (roll[2][4] == 1) {
            setOfDiceArray[4].setIcon(dice1Icon);
        }
        if (roll[2][4] == 2) {
            setOfDiceArray[4].setIcon(dice2Icon);
        }
        if (roll[2][4] == 3) {
            setOfDiceArray[4].setIcon(dice3Icon);
        }
        if (roll[2][4] == 4) {
            setOfDiceArray[4].setIcon(dice4Icon);
        }
        if (roll[2][4] == 5) {
            setOfDiceArray[4].setIcon(dice5Icon);
        }
        if (roll[2][4] == 6) {
            setOfDiceArray[4].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[4]);
        setOfDie.add(dicePanel);
        setOfDie.pack();
        setOfDie.setVisible(true);
    }

    /**
     * Button listener that produces wills set of dice.
     */
    private void willListener() {
        setOfDie = new JFrame("Wills Set of Die");
        if (roll[3][0] == 1) {
            setOfDiceArray[0].setIcon(dice1Icon);
        }
        if (roll[3][0] == 2) {
            setOfDiceArray[0].setIcon(dice2Icon);
        }
        if (roll[3][0] == 3) {
            setOfDiceArray[0].setIcon(dice3Icon);
        }
        if (roll[3][0] == 4) {
            setOfDiceArray[0].setIcon(dice4Icon);
        }
        if (roll[3][0] == 5) {
            setOfDiceArray[0].setIcon(dice5Icon);
        }
        if (roll[3][0] == 6) {
            setOfDiceArray[0].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[0]);
        if (roll[3][1] == 1) {
            setOfDiceArray[1].setIcon(dice1Icon);
        }
        if (roll[3][1] == 2) {
            setOfDiceArray[1].setIcon(dice2Icon);
        }
        if (roll[3][1] == 3) {
            setOfDiceArray[1].setIcon(dice3Icon);
        }
        if (roll[3][1] == 4) {
            setOfDiceArray[1].setIcon(dice4Icon);
        }
        if (roll[3][1] == 5) {
            setOfDiceArray[1].setIcon(dice5Icon);
        }
        if (roll[3][1] == 6) {
            setOfDiceArray[1].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[1]);
        if (roll[3][2] == 1) {
            setOfDiceArray[2].setIcon(dice1Icon);
        }
        if (roll[3][2] == 2) {
            setOfDiceArray[2].setIcon(dice2Icon);
        }
        if (roll[3][2] == 3) {
            setOfDiceArray[2].setIcon(dice3Icon);
        }
        if (roll[3][2] == 4) {
            setOfDiceArray[2].setIcon(dice4Icon);
        }
        if (roll[3][2] == 5) {
            setOfDiceArray[2].setIcon(dice5Icon);
        }
        if (roll[3][2] == 6) {
            setOfDiceArray[2].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[2]);
        if (roll[3][3] == 1) {
            setOfDiceArray[3].setIcon(dice1Icon);
        }
        if (roll[3][3] == 2) {
            setOfDiceArray[3].setIcon(dice2Icon);
        }
        if (roll[3][3] == 3) {
            setOfDiceArray[3].setIcon(dice3Icon);
        }
        if (roll[3][3] == 4) {
            setOfDiceArray[3].setIcon(dice4Icon);
        }
        if (roll[3][3] == 5) {
            setOfDiceArray[3].setIcon(dice5Icon);
        }
        if (roll[3][3] == 6) {
            setOfDiceArray[3].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[3]);
        if (roll[3][4] == 1) {
            setOfDiceArray[4].setIcon(dice1Icon);
        }
        if (roll[3][4] == 2) {
            setOfDiceArray[4].setIcon(dice2Icon);
        }
        if (roll[3][4] == 3) {
            setOfDiceArray[4].setIcon(dice3Icon);
        }
        if (roll[3][4] == 4) {
            setOfDiceArray[4].setIcon(dice4Icon);
        }
        if (roll[3][4] == 5) {
            setOfDiceArray[4].setIcon(dice5Icon);
        }
        if (roll[3][4] == 6) {
            setOfDiceArray[4].setIcon(dice6Icon);
        }
        dicePanel.add(setOfDiceArray[4]);
        setOfDie.add(dicePanel);
        setOfDie.pack();
        setOfDie.setVisible(true);

    }

    /**
     * Button listener that reads the inputs for the guess.
     * Decides if the dice value is higher than the value previously
     * guessed.
     */
    private void guessListener() {
        valueGuess = Integer.parseInt((String) diceBox.getSelectedItem());
        if (valueGuess < oldValue) {
            JOptionPane.showMessageDialog(null,
                    "You need to guess a equal to or higher dice value than "
                    + oldValue);
            valueGuess = oldValue;
        } else {
            guessed = 1;
            game.setValueGuess(valueGuess);

            if (game.returnCurrent() == Player.Jack) {
                jack.setBackground(Color.white);
                black.setBackground(blue);
            }
            if (game.returnCurrent() == Player.Black) {
                black.setBackground(Color.white);
                hook.setBackground(blue);
            }
            if (game.returnCurrent() == Player.Hook) {
                hook.setBackground(Color.white);
                will.setBackground(blue);
            }
            if (game.returnCurrent() == Player.Will) {
                will.setBackground(Color.white);
                jack.setBackground(blue);
            }

            amountGuess =
                    Integer.valueOf((String) valueAmount.getSelectedItem());
            game.setAmountGuess(amountGuess);
                switch (amountGuess) {
                    case 3:
                        valueAmount.removeAllItems();
                        valueAmount.addItem("4");
                        valueAmount.addItem("5");
                        valueAmount.addItem("6");
                        valueAmount.addItem("7");
                        valueAmount.addItem("8");
                        valueAmount.addItem("9");
                        valueAmount.addItem("10");
                        break;
                    case 4:
                        valueAmount.removeAllItems();
                        valueAmount.addItem("5");
                        valueAmount.addItem("6");
                        valueAmount.addItem("7");
                        valueAmount.addItem("8");
                        valueAmount.addItem("9");
                        valueAmount.addItem("10");
                        break;
                    case 5:
                        valueAmount.removeAllItems();
                        valueAmount.addItem("6");
                        valueAmount.addItem("7");
                        valueAmount.addItem("8");
                        valueAmount.addItem("9");
                        valueAmount.addItem("10");
                        break;
                    case 6:
                        valueAmount.removeAllItems();
                        valueAmount.addItem("7");
                        valueAmount.addItem("8");
                        valueAmount.addItem("9");
                        valueAmount.addItem("10");
                        break;
                    case 7:
                        valueAmount.removeAllItems();
                        valueAmount.addItem("8");
                        valueAmount.addItem("9");
                        valueAmount.addItem("10");
                        break;
                    case 8:
                        valueAmount.removeAllItems();
                        valueAmount.addItem("9");
                        valueAmount.addItem("10");
                        break;
                    case 9:
                        valueAmount.removeAllItems();
                        valueAmount.addItem("10");
                    case 10:
                        valueAmount.removeAllItems();
                        valueAmount.addItem("10");
                        break;
                    default:
                        break;
                }

            oldValue = valueGuess;


            game.nextTurn();
            state.setText("It is " + game.returnCurrent() + "'s turn");
            status.setText("Current guess");
            status2.setText(amountGuess + " " + valueGuess + "'s");
        }
    }

    /**
     * Button listener that decides if the player who guessed lied or not.
     * This button will display a JOptionPane telling who won and lost.
     * This function also resets the board, the turn counter, and the guesses.
     */
    private void liarListener() {
        if (guessed != 0) {
            if (game.liar()) {
                JOptionPane.showMessageDialog(null,
                        game.returnCurrent() + " Wins and "
                                + game.returnPrev() + " Loses" + "\n"
                                + game.returnPrev() + " called " + amountGuess
                                + " " + oldValue + "'s" + "\n"
                                + "There are only " + totals[oldValue - 1]
                                + " " + oldValue + "'s", game.returnPrev()
                                + " was lying",
                                JOptionPane.INFORMATION_MESSAGE);
                game.stats(game.returnCurrent(), game.returnPrev());
            } else {
                JOptionPane.showMessageDialog(null,
                        game.returnPrev() + " Wins and "
                                + game.returnCurrent() + " Loses" + "\n"
                                + game.returnPrev() + " called " + amountGuess
                                + " " + oldValue + "'s" + "\n"
                                + "There are " + totals[oldValue - 1]
                                + " " + oldValue + "'s", game.returnPrev()
                                + " was not lying",
                        JOptionPane.INFORMATION_MESSAGE);
                game.stats(game.returnPrev(), game.returnCurrent());
            }
            reset();

        }
    }

    /**
     * Function called by the liar button to reset the board for a new game.
     * Resets the functional class, as well as the labels on the board.
     * Also resets the valueAmount comboBox.
     */
    private void reset() {
        game.reset();
        roll = game.getRoll();
        oldValue = 1;
        totals = game.getTotal();
        guessed = 0;
        state.setText("It is " + game.returnCurrent() + "'s turn");
        status.setText("Current guess");
        status2.setText(amountGuess + " " + valueGuess + "'s");

        diceBox.setSelectedIndex(0);
        valueAmount.removeAllItems();
        valueAmount.addItem("3");
        valueAmount.addItem("4");
        valueAmount.addItem("5");
        valueAmount.addItem("6");
        valueAmount.addItem("7");
        valueAmount.addItem("8");
        valueAmount.addItem("9");
        valueAmount.addItem("10");

    }
}

