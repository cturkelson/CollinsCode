package AllGames;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*****************************************************************
 *
 * Maintains the GUI for the Nine Men's Morris Game.
 *
 *****************************************************************/

public class NMMGUI extends JFrame implements ActionListener {
    /**
     * Menu item for a button that will take the user back to the main menu.
     **/
    private JMenuItem exitToMainMenu;
    /**
     * Menu Item that will undo the user's last move.
     **/
    private JMenuItem undo;
    /**
     * Menu Item that will start a new game.
     **/
    private JMenuItem newGame;
    /**
     * Menu Item that will end the current game.
     **/
    private JMenuItem quitGame;
    /**
     * Rule Menu Item that creates a pop-up explaining the goals of the game.
     **/
    private JMenuItem basicsOfTheGame;
    /**
     * Rule Menu item that creates a pop-up explaining the initial phase of the
     * game.
     **/
    private JMenuItem beginningTheGame;
    /**
     * Rule Menu item that explains the second and third phases of the game.
     **/
    private JMenuItem slidingAndMovingPieces;
    /**
     * Rule Menu item that outline's some strategies for the game.
     **/
    private JMenuItem tipsAndTricks;
    /**
     * Instance of the Main Menu class that is created for passing win/loss
     * statistics to the Main Menu.
     */
    private static MainMenu mainMenu;
    /**
     * Instance of the NMMPanel in order to call the instance created in the
     * constructor from other methods.
     */
    private NMMPanel gamePanel = new NMMPanel();

    JFrame frame = new JFrame();

    /**
     * A constructor that starts a new NMMGUI for the Nine Men's Morris Game.
     * First it creates and names the frame, sets the default close operation,
     * and then instantiates a new NMMPanel that it adds to the frame. It
     * creates a JMenu called "File" and adds the necessary JMenuItems to it.
     * It does the same for a JMenu called "Rules." It adds ActionListeners to
     * all of the menu items. It then sets the size of the frame and makes it
     * visible.
     * @param toMainMenu instance of the Main Menu class that is used to pass
     *                   win/loss statistics to the Main Menu.
     */
    NMMGUI(MainMenu toMainMenu) {
        mainMenu = toMainMenu;
        frame = new JFrame("Nine Men's Morris");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gamePanel = new NMMPanel();
        JMenuBar menus = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem ruleMenu = new JMenu("Rules");
        newGame = new JMenuItem("New Game");
        exitToMainMenu = new JMenuItem("Exit to Main Menu");
        quitGame = new JMenuItem("Quit Game");

        basicsOfTheGame = new JMenuItem("Basics of the Game");
        beginningTheGame = new JMenuItem("Beginning the Game");
        slidingAndMovingPieces = new JMenuItem("Sliding and Moving Pieces");
        tipsAndTricks = new JMenuItem("Tips and Strategy");

        fileMenu.add(newGame);
        fileMenu.add(exitToMainMenu);
        fileMenu.add(quitGame);

        ruleMenu.add(basicsOfTheGame);
        ruleMenu.add(beginningTheGame);
        ruleMenu.add(slidingAndMovingPieces);
        ruleMenu.add(tipsAndTricks);

        menus.add(fileMenu);
        menus.add(ruleMenu);

        newGame.addActionListener(this::actionPerformed);
        exitToMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        basicsOfTheGame.addActionListener(this::actionPerformed);
        beginningTheGame.addActionListener(this::actionPerformed);
        slidingAndMovingPieces.addActionListener(this);
        tipsAndTricks.addActionListener(this);

        frame.getContentPane().add(gamePanel);

        frame.setJMenuBar(menus);
        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(800, 700));
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Method used by the GUI to reset the board when the user clicks the "New
     * Game" button in the drop down file menu.
     */
    private void endGame() {
        gamePanel.endGame();
        gamePanel.repaint();
        this.repaint();
    }
    /**
     * This is the ActionListener that handles events from the "File" menu and
     * the "Rules" menu.
     * @param e the source of the event.
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        NMMRules rules = new NMMRules();

        /*if (e.getSource() == exitToMainMenu) {
            exitFrame();*/
        if (e.getSource() == newGame) {
            int test = JOptionPane.showConfirmDialog(null,
                    "Are you sure?", null, JOptionPane.YES_NO_OPTION);
            switch (test) {
                case 0:
                    endGame();
                    gamePanel.revalidate();
                    return;
                case 1:
                    dispose();
                default:
                    break;
            }
        } else if (e.getSource() == basicsOfTheGame) {
            JOptionPane.showMessageDialog(this, rules.basicsOfTheGame(),
                    "Basics of the Game", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == beginningTheGame) {
            JOptionPane.showMessageDialog(this, rules.beginningTheGame(),
                    "Beginning the Game", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == slidingAndMovingPieces) {
            JOptionPane.showMessageDialog(this, rules.slidingAndMoving(),
                    "Placing & Moving Pieces", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == tipsAndTricks) {
            JOptionPane.showMessageDialog(this, rules.tipsAndTricks(),
                    "Tips and Tricks", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
