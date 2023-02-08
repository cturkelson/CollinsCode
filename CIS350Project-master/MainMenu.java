package SuiteOfGames;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * MainMenu creates the main menu and is also where
 * the program is launched from.
 * @author Christina Kidwell
 * @version Final
 * @see Solitaire
 */
class MainMenu extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    /**Declares the main menu panel.*/
    JPanel menuPanel;
    /**Declares Solitaire.*/
    private Solitaire solitaire;
    /**Declares the text field.*/
    private JFormattedTextField frmtdtxtfldSuiteOfGames;
    /**Declares the 9-Men Morris button.*/
    private JButton btnmenMorris;
    /**Declares the Solitaire button.*/
    private JButton btnSolitaire;
    /**Declares the Liar's Dice button.*/
    private JButton btnLiarsDice;
    /**Declares the Statistics button.*/
    private JButton btnStats;
    /**Declares the stats panel.*/
    private JPanel statsPanel;

    /**Declares solitaireWin and initializes it to 0.*/
    private int solitaireWin = 0;
    /**Declares solitaireLose and initializes it to 0.*/
    private int solitaireLose = 0;
    /**Declares sparrowWin and initializes it to 0.*/
    private int sparrowWin = 0;
    /**Declares sparrowLoss and initializes it to 0.*/
    private int sparrowLoss = 0;
    /**Declares blackbeardWin and initializes it to 0.*/
    private int blackbeardWin = 0;
    /**Declares blackbeardLoss and initializes it to 0.*/
    private int blackbeardLoss = 0;
    /**Declares hookWin and initializes it to 0.*/
    private int hookWin = 0;
    /**Declares hookLoss and initializes it to 0.*/
    private int hookLoss = 0;
    /**Declares turnerWin and initializes it to 0.*/
    private int turnerWin = 0;
    /**Declares turnerLoss and initializes it to 0.*/
    private int turnerLoss = 0;
    /**Declares nineMenWin and initializes it to 0.*/
    private int nineMenWin = 0;
    /**Declares nineMenLose and initializes it to 0.*/
    private int nineMenLose = 0;

    /**
     * MainMenu constructor that creates the Main menu panel. This also
     * creates the instance of the Stats panel.
     */
    MainMenu() {
        statsPanel = new Stats(this);
        setTitle("Suite of Games");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 350);
        menuPanel = new JPanel();
        menuPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(menuPanel);
        menuPanel.setLayout(null);

        frmtdtxtfldSuiteOfGames = new JFormattedTextField();
        frmtdtxtfldSuiteOfGames
        .setFocusLostBehavior(JFormattedTextField.PERSIST);
        frmtdtxtfldSuiteOfGames.setEditable(false);
        frmtdtxtfldSuiteOfGames.setBounds(25, 11, 529, 32);
        frmtdtxtfldSuiteOfGames.setHorizontalAlignment(SwingConstants.CENTER);
        frmtdtxtfldSuiteOfGames.setFont(new Font("Georgia", Font.ITALIC, 22));
        frmtdtxtfldSuiteOfGames.setText("Suite of Games");
        menuPanel.add(frmtdtxtfldSuiteOfGames);

        btnSolitaire = new JButton("Solitaire");
        btnSolitaire.addActionListener(this);
        btnSolitaire.setBounds(50, 80, 125, 100);
        btnSolitaire.setFont(new Font("Georgia", Font.PLAIN, 16));
        menuPanel.add(btnSolitaire);

        btnLiarsDice = new JButton("<html><center>Liar's Dice </html>");
        btnLiarsDice.addActionListener(this);
        btnLiarsDice.setBounds(225, 80, 125, 100);
        btnLiarsDice.setFont(new Font("Georgia", Font.PLAIN, 16));
        menuPanel.add(btnLiarsDice);

        btnmenMorris = new JButton("<html><center>9-Mens Morris </html>");
        btnmenMorris.addActionListener(this);
        btnmenMorris.setBounds(400, 80, 125, 100);
        btnmenMorris.setFont(new Font("Georgia", Font.PLAIN, 16));
        menuPanel.add(btnmenMorris);

        btnStats = new JButton("Statistics");
        btnStats.addActionListener(this);
        btnStats.setFont(new Font("Georgia", Font.PLAIN, 14));
        btnStats.setBounds(240, 240, 100, 25);
        menuPanel.add(btnStats);
    }

    /**
     * Processes when a button is clicked.
     * @param event the button that was clicked.
     * @see NMMGUI
     * @see LiarsGUI
     */
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == btnmenMorris) {
            NMMGUI nineMensMorris = new NMMGUI(null);
        } else if (event.getSource() == btnSolitaire) {
            solitaire = new Solitaire(this);
        } else if (event.getSource() == btnLiarsDice) {
            LiarsGUI liarsDice = new LiarsGUI(null);

        } else if (event.getSource() == btnStats) {

            String str = Integer.toString(this.getSolitaireWin());
            Stats.solWon.setText("Games Won: " + str);
            str = Integer.toString(this.getSolitaireLose());
            Stats.solLost.setText("Games lost: " + str);

            str = Integer.toString(this.getSparrowWin());
            Stats.sparrowWon.setText("Sparrow Won: " + str);
            str = Integer.toString(this.getSparrowLoss());
            Stats.sparrowLoss.setText("Sparrow Loss: " + str);
            str = Integer.toString(this.getBlackbeardWin());
            Stats.blackbeardWon.setText("Blackbeard Won: " + str);
            str = Integer.toString(this.getBlackbeardLoss());
            Stats.blackbeardLoss.setText("Blackbeard Loss: " + str);
            str = Integer.toString(this.getHookWin());
            Stats.hookWon.setText("Hook Won: " + str);
            str = Integer.toString(this.getHookLoss());
            Stats.hooksLoss.setText("Hook Loss: " + str);
            str = Integer.toString(this.getTurnerWin());
            Stats.turnerWon.setText("Turner Won: " + str);
            str = Integer.toString(this.getTurnerLoss());
            Stats.turnerLoss.setText("Turner Loss: " + str);

            str = Integer.toString(this.getNineMenWin());
            Stats.morisWon.setText("Games Won: " + str);
            str = Integer.toString(this.getNineMenLose());
            Stats.morisLost.setText("Games lost: " + str);
            setContentPane(statsPanel);
            statsPanel.setVisible(true);
            statsPanel.revalidate();
            statsPanel.repaint();
        }
    }

    /**
     * Returns the number of Solitaire wins.
     * @return the number of Solitaire wins.
     */
    int getSolitaireWin() {
        return solitaireWin;
    }

    /**
     * Sets the value of Solitaire wins.
     * @param solWin value of Solitaire wins.
     */
    void setSolitaireWin(final int solWin) {
        solitaireWin = solWin;
    }

    /**
     * Returns the number of Solitaire losses.
     * @return the number of Solitaire losses.
     */
    int getSolitaireLose() {
        return solitaireLose;
    }

    /**
     * Sets the value of Solitaire losses.
     * @param solLose value of Solitaire losses.
     */
    void setSolitaireLose(final int solLose) {
        solitaireLose = solLose;
    }

    /**
     * Returns the number of 9-Men's Morris wins.
     * @return the number of 9-Men's Morris wins.
     */
    int getNineMenWin() {
        return nineMenWin;
    }

    /**
     * Sets the value of 9-Men's Morris wins.
     * @param nineWin value of 9-Men's Morris wins.
     */
     void setNineMenWin(final int nineWin) {
        nineMenWin = nineWin;
    }

    /**
     * Returns the number of 9-Men's Morris Losses.
     * @return the number of 9-Men's Morris Losses.
     */
     int getNineMenLose() {
        return nineMenLose;
    }

    /**
     * Sets the value of 9-Men's Morris Losses.
     * @param nineLose value of 9-Men's Morris Losses.
     */
     void setNineMenLose(final int nineLose) {
        nineMenLose = nineLose;
    }

    /**
     * Returns the number of times Sparrow has won Liar's Dice.
     * @return Times Sparrow has won Liar's Dice.
     */
     int getSparrowWin() {
        return sparrowWin;
    }

    /**
     * Sets the value of times Sparrow has won Liar's Dice.
     * @param sparrowWin Times Sparrow has won Liar's Dice.
     */
     void incSparrowWin(int sparrowWin) {
        sparrowWin++;
    }

    /**
     * Returns the number of times Sparrow has lost Liar's Dice.
     * @return number of times Sparrow has lost Liar's Dice.
     */
     int getSparrowLoss() {
        return sparrowLoss;
    }

    /**
     * Sets the value of times Sparrow has lost Liar's Dice.
     * @param sparrowLoss times Sparrow has lost Liar's Dice.
     */
     void incSparrowLoss(int sparrowLoss) {
        sparrowLoss++;
    }

    /**
     * Returns the number of times Blackbeard has won Liar's Dice.
     * @return times Blackbeard has won Liar's Dice.
     */
    int getBlackbeardWin() {
        return blackbeardWin;
    }

    /**
     * Sets the value of times Blackbeard has won Liar's Dice.
     * @param blackbeardWin times Blackbeard has won Liar's Dice.
     */
    void incBlackbeardWin(int blackbeardWin) {
        blackbeardWin++;
    }

    /**
     * Returns the number of times Blackbeard has lost Liar's Dice.
     * @return number of times Blackbeard has lost Liar's Dice.
     */
    int getBlackbeardLoss() {
        return blackbeardLoss;
    }

    /**
     * Sets the value of times Blackbeard has lost Liar's Dice.
     * @param blackbeardLoss times Blackbeard has lost Liar's Dice.
     */
    void incBlackbeardLoss(int blackbeardLoss) {
        blackbeardLoss++;
    }


    /**
     * Returns the number of times Hook has won Liar's Dice.
     * @return number of times Hook has won Liar's Dice.
     */
    int getHookWin() {
        return hookWin;
    }

    /**
     * Sets the value of times Hook has won Liar's Dice.
     * @param hookWin times Hook has won Liar's Dice.
     */
    void incHookWin(int hookWin) {
        hookWin++;
    }

    /**
     * Returns the number of times Hook has lost Liar's Dice.
     * @return number of times Hook has lost Liar's Dice.
     */
    int getHookLoss() {
        return hookLoss;
    }

    /**
     * Sets the value of times Hook has lost Liar's Dice.
     * @param hookLoss times Hook has lost Liar's Dice.
     */
    void incHookLoss(int hookLoss) {
        hookLoss++;
    }

    /**
     * Returns the number of times Turner has won Liar's Dice.
     * @return number of times Turner has won Liar's Dice.
     */
    int getTurnerWin() {
        return turnerWin;
    }

    /**
     * Sets the value of times Turner has won Liar's Dice.
     * @param turnerWin times Turner has won Liar's Dice.
     */
    void incTurnerWin(int turnerWin) {
        turnerWin++;
    }

    /**
     * Returns the number of times Turner has lost Liar's Dice.
     * @return number of times Turner has lost Liar's Dice.
     */
    int getTurnerLoss() {
        return turnerLoss;
    }

    /**
     * Sets the value of times Turner has lost Liar's Dice.
     * @param turnerLoss times Turner has lost Liar's Dice.
     */
    void incTurnerLoss(int turnerLoss) {
        turnerLoss++;
    }

    /**
     * Launch the program.
     * @param args Arguments of the program.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainMenu frame = new MainMenu();
                    frame.setVisible(true);
                } catch (Exception FailedToLoad) {
                    FailedToLoad.printStackTrace();
                }
            }
        });
    }
}
