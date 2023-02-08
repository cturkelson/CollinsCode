package SuiteOfGames;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/** 
* NineMensMorrisPlayer Tester. 
* 
* @author <Eric Evelye>
* @since <pre>Dec 5, 2019</pre> 
* @version 1.0 
*/ 
public class NineMensMorrisPlayerTest { 

@Before
public void before() throws Exception {
    System.out.println("Beginning Player Class tests");
} 

@After
public void after() throws Exception {
    System.out.println("Player Class Tests Complete");
}

/** 
* 
* Method: setTurnCounter(final int turnCounter) 
* 
*/ 
@Test
public void testSetTurnCounter() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();
    int random = new Random().nextInt(50);
    player.setTurnCounter(random);
    assertEquals(random, player.getTurnCounter());
} 

/** 
* 
* Method: clearMyPlacedPieces() 
* 
*/ 
@Test
public void testClearMyPlacedPieces() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();
    int random = new Random().nextInt(9);
    for (int i = 0; i < random; i++) {
        player.placePiece(new JButton());
    }
    player.clearMyPlacedPieces();
    assertEquals(0, player.getMyPlacedPieces().size());
} 

/** 
* 
* Method: getMyPlacedPieces() 
* 
*/ 
@Test
public void testGetMyPlacedPieces() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();
    ArrayList<JButton> test = new ArrayList<>();
    int random = new Random().nextInt(9);
    for (int i = 0; i < random; i++) {
        JButton btn = new JButton();
        player.placePiece(btn);
        test.add(btn);
    }
    assertEquals(test, player.getMyPlacedPieces());
} 

/** 
* 
* Method: getPlayerColor() 
* 
*/ 
@Test
public void testGetPlayerColor() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer(Color.BLACK);
    assertEquals(Color.BLACK, player.getPlayerColor());
}

/**
*
* Method: getPiecesPlacedCount()
*
*/
@Test
public void testGetPiecesPlacedCount() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();
    int random = new Random().nextInt(9);
    for (int i = 0; i < random; i++) {
        player.placePiece(new JButton());
    }
    assertEquals(random, player.getPiecesPlacedCount());

}
/** 
* 
* Method: isTurnStatus() 
* 
*/ 
@Test
public void testIsTurnStatus() throws Exception {
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    int random = new Random().nextInt(20);
    for (int i = 0; i < (random - (random % 2)); i++) {
        gameLogic.changeTurn(gameLogic.whosTurn());
    }
    assertEquals(true, gameLogic.getPlayer1().isTurnStatus());
} 

/** 
* 
* Method: setTurnStatus(final boolean turnStatus) 
* 
*/ 
@Test
public void testSetTurnStatus() throws Exception {
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    int random = new Random().nextInt(20);
    for (int i = 0; i < (random - (random % 2)); i++) {
        gameLogic.changeTurn(gameLogic.whosTurn());
    }
    gameLogic.getPlayer2().setTurnStatus(true);
    assertEquals(true, gameLogic.getPlayer2().isTurnStatus());
} 

/** 
* 
* Method: getTurnCounter() 
* 
*/ 
@Test
public void testGetTurnCounter() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();
    int random = new Random().nextInt(99);
    player.setTurnCounter(random);
    assertEquals(random, player.getTurnCounter());
}
/** 
* 
* Method: placePiece(final JButton lastMove) 
* 
*/ 
@Test
public void testPlacePiece() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();
    int random = new Random().nextInt(9);
    for (int i = 0; i < random; i++) {
        player.placePiece(new JButton());
    }
    assertEquals(random, player.getMyPlacedPieces().size());
} 

/** 
* 
* Method: getNumberOfMyPieces() 
* 
*/ 
@Test
public void testGetNumberOfMyPieces() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();
    int random = new Random().nextInt(9);
    for (int i = 0; i < random; i++) {
        player.placePiece(new JButton());
    }
    assertEquals(random, player.getNumberOfMyPieces());
} 

/** 
* 
* Method: checkIfMyPiece(final JButton btn) 
* 
*/ 
@Test
public void testCheckIfMyPiece() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();

    JButton good = new JButton();
    JButton bad = new JButton();

    player.placePiece(good);
    assertEquals(true, player.checkIfMyPiece(good));
    assertEquals(false, player.checkIfMyPiece(bad));
} 

/** 
* 
* Method: replacePiece(final JButton startBtn, final JButton endBtn) 
* 
*/ 
@Test
public void testReplacePiece() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();

    JButton good = new JButton();
    JButton bad = new JButton();

    player.placePiece(good);
    player.replacePiece(good,bad);
    assertEquals(true, player.checkIfMyPiece(bad));
    assertEquals(false, player.checkIfMyPiece(good));
} 

/** 
* 
* Method: removePiece(final JButton byeByeBtn) 
* 
*/ 
@Test
public void testRemovePiece() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();

    JButton good = new JButton();

    player.placePiece(good);
    player.removePiece(good);
    assertEquals(false, player.checkIfMyPiece(good));
} 

/** 
* 
* Method: printPlayerColor() 
* 
*/ 
@Test
public void testPrintPlayerColor() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer(Color.BLACK);

    assertEquals("Black", player.printPlayerColor());
} 

/** 
* 
* Method: reset() 
* 
*/ 
@Test
public void testReset() throws Exception {
    NineMensMorrisPlayer player = new NineMensMorrisPlayer();
    int random = new Random().nextInt(9);
    for (int i = 0; i < random; i++) {
        player.placePiece(new JButton());
    }
    player.reset();
    assertEquals(0, player.getMyPlacedPieces().size());
    assertEquals(0, player.getTurnCounter());
}
}
