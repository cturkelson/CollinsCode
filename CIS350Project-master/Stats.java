package SuiteOfGames;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFrame.*;
import javax.swing.SwingConstants;

/**
 * Describes the construction of the Statistics Panel.
 * @author Christina Kidwell
 *
 */
class Stats extends JPanel {
    private static final long serialVersionUID = 1L;

    /**Declares the JLabel for Solitaire Wins.*/
    static JLabel solWon;
    /**Declares the JLabel for Solitaire loses.*/
    static JLabel solLost;
    /**Declares the JLabel for sparrow wins.*/
    static JLabel sparrowWon;
    /**Declares the JLabel for sparrow loses.*/
    static JLabel sparrowLoss;
    /**Declares the JLabel for blackbeard wins.*/
    static JLabel blackbeardWon;
    /**Declares the JLabel for blackbeard loses.*/
    static JLabel blackbeardLoss;
    /**Declares the JLabel for hook wins.*/
    static JLabel hookWon;
    /**Declares the JLabel for hook loses.*/
    static JLabel hooksLoss;
    /**Declares the JLabel for turner wins.*/
    static JLabel turnerWon;
    /**Declares the JLabel for turner loses.*/
    static JLabel turnerLoss;
    /**Declares the JLabel for 9-Men's Morris wins.*/
    static JLabel morisWon;
    /**Declares the JLabel for 9-Men's Morris loses.*/
    static JLabel morisLost;
    /**Declares the JButton for the Back button.*/
    private JButton btnBack;

    /**
     * Stats constructor that describes the construction
     * of the Statistics Panel.
     * @param toMainMenu Instance of MainMenu
     * @see MainMenu
     */
    Stats(final MainMenu toMainMenu) {
        setSize(600, 350);
        setLayout(null);

        JLabel lblStatistics = new JLabel("Statistics ");
        lblStatistics.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 22));
        lblStatistics.setBounds(25, 11, 136, 32);
        add(lblStatistics);

        JLabel lblSolitare = new JLabel("Solitare:");
        lblSolitare.setFont(new Font("Georgia", Font.PLAIN, 13));
        lblSolitare.setBounds(70, 88, 59, 14);
        add(lblSolitare);

        solWon = new JLabel("Games Won");
        solWon.setFont(new Font("Georgia", Font.PLAIN, 12));
        solWon.setBounds(70, 122, 90, 14);
        add(solWon);

        solLost = new JLabel("Games Lost");
        solLost.setFont(new Font("Georgia", Font.PLAIN, 12));
        solLost.setBounds(70, 135, 90, 14);
        add(solLost);

        JLabel lblLiarsDice = new JLabel("Liar's Dice:");
        lblLiarsDice.setFont(new Font("Georgia", Font.PLAIN, 13));
        lblLiarsDice.setBounds(236, 88, 79, 14);
        add(lblLiarsDice);

        sparrowWon = new JLabel("Sparrow's Wins: "
        + toMainMenu.getSparrowWin());
        sparrowWon.setFont(new Font("Georgia", Font.PLAIN, 12));
        sparrowWon.setBounds(236, 122, 110, 14);
        add(sparrowWon);

        sparrowLoss = new JLabel("Sparrow's Loss: "
        + toMainMenu.getSparrowLoss());
        sparrowLoss.setFont(new Font("Georgia", Font.PLAIN, 12));
        sparrowLoss.setBounds(236, 135, 110, 14);
        add(sparrowLoss);

        blackbeardWon = new JLabel("Blackbeard Wins: "
        + toMainMenu.getBlackbeardWin());
        blackbeardWon.setFont(new Font("Georgia", Font.PLAIN, 12));
        blackbeardWon.setBounds(236, 148, 110, 14);
        add(blackbeardWon);

        blackbeardLoss = new JLabel("Blackbeard Loss: "
        + toMainMenu.getBlackbeardLoss());
        blackbeardLoss.setFont(new Font("Georgia", Font.PLAIN, 12));
        blackbeardLoss.setBounds(236, 161, 110, 14);
        add(blackbeardLoss);

        hookWon = new JLabel("Hook's Wins: " + toMainMenu.getHookWin());
        hookWon.setFont(new Font("Georgia", Font.PLAIN, 12));
        hookWon.setBounds(236, 174, 110, 14);
        add(hookWon);

        hooksLoss = new JLabel("Hook's Loss: " + toMainMenu.getHookLoss());
        hooksLoss.setFont(new Font("Georgia", Font.PLAIN, 12));
        hooksLoss.setBounds(236, 187, 110, 14);
        add(hooksLoss);

        turnerWon = new JLabel("Turner's Wins: " + toMainMenu.getTurnerWin());
        turnerWon.setFont(new Font("Georgia", Font.PLAIN, 12));
        turnerWon.setBounds(236, 200, 110, 14);
        add(turnerWon);

        turnerLoss = new JLabel("Turner's Loss: " + toMainMenu.getTurnerLoss());
        turnerLoss.setFont(new Font("Georgia", Font.PLAIN, 12));
        turnerLoss.setBounds(236, 213, 110, 14);
        add(turnerLoss);

        JLabel lblmensMorris = new JLabel("9-Mens Morris:");
        lblmensMorris.setFont(new Font("Georgia", Font.PLAIN, 13));
        lblmensMorris.setBounds(389, 88, 112, 14);
        add(lblmensMorris);

        morisWon = new JLabel("Games Won");
        morisWon.setFont(new Font("Georgia", Font.PLAIN, 12));
        morisWon.setBounds(389, 122, 90, 14);
        add(morisWon);

        morisLost = new JLabel("Games Lost");
        morisLost.setFont(new Font("Georgia", Font.PLAIN, 12));
        morisLost.setBounds(389, 135, 90, 14);
        add(morisLost);

        btnBack = new JButton("Back");
        btnBack.setVerticalAlignment(SwingConstants.TOP);
        btnBack.setFont(new Font("Georgia", Font.PLAIN, 14));
        btnBack.setBounds(240, 240, 100, 25);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                toMainMenu.setContentPane(toMainMenu.menuPanel);
                toMainMenu.setVisible(true);
                toMainMenu.revalidate();
                toMainMenu.repaint();
            }
        });

        add(btnBack);
    }
}
