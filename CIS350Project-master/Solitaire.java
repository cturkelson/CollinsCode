package SuiteOfGames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * Solitaire class builds the Solitaire game.
 * @author Christina Kidwell
 * @see CardPile
 * @see DeckPile
 * @see DiscardPile
 * @see SuitPile
 * @see TablePile
 * @see TempPile
 * @see MainMenu
 */
class Solitaire extends JFrame {
    /**
     * Int that describes the gap at the top of the frame where the menu bar
     * sits. On some monitors 70 is to big in which case it should be set
     * to 60; it is set to 70 here because it is better that the menu bar
     * has a little extra space then be half covered up.
     */
    private final int topGap = 70;
    /**Declares the deckpile.*/
    static DeckPile deckPile;
    /**Declares the discard pile.*/
    static DiscardPile discardPile;
    /**Declares the temppile.*/
    static TempPile tempPile;
    /**Declares the tableau piles.*/
    static TablePile[] tableau;
    /**Declares the suit piles.*/
    static SuitPile[] suitPile;
    /**Declares the general Card pile.*/
    static CardPile[] allPiles;
    /**Declares the value that tracks if the player is going to lose.*/
    static int loser = 0;
    /**Declares and creates the color used for the background.*/
    Color darkGreen = new Color(0, 153, 0);
    /**Declares and initializes the image for the card backs.*/
    static BufferedImage backImage = null;
    /**Declares mainMenu instance.*/
    static MainMenu mainMenu;

//    static void main(String[] args) {
//        Solitaire solitaire = new Solitaire(this);
//    }

    /**
     * Solitaire constructor hat describes the construction
     * of the Solitaire Game.
     * @param toMainMenu Instance of MainMenu
     */
    Solitaire(final MainMenu toMainMenu) {
        mainMenu = toMainMenu;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200, 900);
        setBackground(darkGreen);
        setTitle("Solitaire Game");
        setLayout(null);

        addMouseListener(new MouseKeeper());

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Menu");

        JMenuItem menuNew = new JMenuItem("New", KeyEvent.VK_N);
        menuNew.setAccelerator(KeyStroke
                .getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuNew.getAccessibleContext()
                .setAccessibleDescription("Start a New Game");
        menuNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    int i = toMainMenu.getSolitaireLose();
                    i++;
                    toMainMenu.setSolitaireLose(i);
                    init();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
                repaint();
            }
        });
        menu.add(menuNew);

        JMenuItem menuMenu = new JMenuItem("Main Menu", KeyEvent.VK_M);
        menuMenu.setAccelerator(KeyStroke
                .getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuMenu.getAccessibleContext()
                .setAccessibleDescription("Return to Main Menu");
        menuMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                 dispose();
            }
        });
        menu.add(menuMenu);
        menuBar.add(menu);

        try {
            int i = toMainMenu.getSolitaireLose();
            i++;
            toMainMenu.setSolitaireLose(i);
            init();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    /**
     * init Sets up the game with the initial card piles.
     * @see SuitPile
     * @see TablePile
     * @see CardPile
     * @throws URISyntaxException Checked exception thrown to indicate
     * that a string could not be parsed as aURI reference.
     * @throws IOException Signals that an I/O exception of
     * some sort has occurred.
     */
    void init() throws IOException, URISyntaxException {
        allPiles = new CardPile[14];
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];
        loser = 0;
        backImage = ImageIO.read(new File(getClass()
                .getResource("/resources/CardBack.png").toURI()));
        Dimension size = getBounds().getSize();
        int w = size.width;
        int gap = w / 43;
        Card.width = gap * 5;
        Card.height = Card.width * 14 / 10;

        allPiles[0] = deckPile = new DeckPile(gap, topGap);
        allPiles[1] = discardPile = new
                DiscardPile(gap * 2 + Card.width, topGap);
        for (int i = 0; i < 4; i++) {
            allPiles[2 + i] = suitPile[i] = new
                    SuitPile(gap * 4 + Card.width
                            * 3 + (Card.width + gap) * i, topGap);
        }
        for (int i = 0; i < 7; i++) {
            allPiles[6 + i] = tableau[i] = new
                    TablePile(gap + (Card.width + gap) * i,
                            Card.height + gap + topGap, i + 1);
        }
        allPiles[13] = tempPile = new
                TempPile(gap * 3 + Card.width * 2, topGap);
    }

    private class MouseKeeper extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            for (int i = 0; i < 13; i++) {
                if (allPiles[i].includes(x, y)) {
                    allPiles[i].select();
                }
                repaint();
            }

            int victory = 0;
            for (int i = 0; i < 4; i++) {
                if (!Solitaire.suitPile[i].isEmpty()) {
                    if (Solitaire.suitPile[i].top().getRank() == 12) {
                        victory++;
                    }
                }
            }
            if (victory == 4) {
                int i = Solitaire.mainMenu.getSolitaireLose();
                i--;
                mainMenu.setSolitaireLose(i);
                i = mainMenu.getSolitaireWin();
                i++;
                mainMenu.setSolitaireWin(i);
                Object[] options = {"New Game", "Main Menu"};
                int n = JOptionPane.showOptionDialog(null,
                        "You Win!", "Congradulations!",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (n == 0) {
                    try {
                        init();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                    repaint();
                } else {
                    dispose();
                }
            }

            if (loser > 2) {
                Object[] options = {"New Game", "Main Menu"};
                int n = JOptionPane.showOptionDialog(null,
                        "You Loose :(", "I'm Sorry...",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (n == 0) {
                    try {
                        init();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                    repaint();
                } else {
                    dispose();
                }
            }
        }
    }

    /**
     * paint draws everything into the frame excluding the menu bar at the top.
     * @param g add description here.
     */
    public void paint(final Graphics g) {
        super.paint(g);
        g.clearRect(0, topGap * 5 / 6, getWidth(), getHeight());
        for (int i = 0; i < 13; i++) {
            allPiles[i].display(g);
        }
    }
}
