package SuiteOfGames;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import javax.swing.JButton;
import java.util.Random;

import java.awt.*;

import static org.junit.Assert.*;

/** 
* NineMensMorrisGame Tester. 
* 
* @author <Authors name> 
* @since <pre>Dec 5, 2019</pre> 
* @version 1.0 
*/ 
public class NineMensMorrisGameTest {
    NMMPanel testPanel = new NMMPanel();
    int[] possibleNums = new int[7];
@Before
public void before() throws Exception {
    System.out.println("Beginning tests");
} 

@After
public void after() throws Exception {
    System.out.println("Tests Complete");
} 

/** 
* 
* Method: whosTurn() 
* 
*/ 
@Test
public void testWhosTurn() throws Exception { 
//TODO: Test goes here... 
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    assertEquals(gameLogic.whosTurn(), gameLogic.getPlayer1());
}

    /**
* 
* Method: getOtherPlayer() 
* 
*/ 
@Test
public void testGetOtherPlayer() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    assertEquals(gameLogic.getOtherPlayer(), gameLogic.getPlayer2());
} 

/** 
* 
* Method: changeTurn(final NineMensMorrisPlayer currentPlayer) 
* 
*/ 
@Test
public void testChangeTurn() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    gameLogic.changeTurn(gameLogic.whosTurn());
    assertEquals(gameLogic.whosTurn(), gameLogic.getPlayer2());
} 

/** 
* 
* Method: placePiecePlayer(final JButton btn) 
* 
*/ 
@Test
public void testPlacePiecePlayer() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    JButton btn = new JButton();
    gameLogic.placePiecePlayer(btn);
    assertEquals(gameLogic.getPlacedPieces().get(gameLogic.getPlacedPieces().indexOf(btn)), btn);
} 

/** 
* 
* Method: slidePiece(final JButton startBtn, final JButton endBtn) 
* 
*/ 
@Test
public void testSlidePiece() throws Exception {
//TODO: Test goes here...

    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    JButton startBtn = new JButton();
    JButton goodEndBtn = new JButton();
    JButton badEndBtn = new JButton();
    gameLogic.placePiecePlayer(startBtn);
    gameLogic.slidePiece(startBtn, goodEndBtn);
    assertEquals(goodEndBtn, gameLogic.getPlayer1().getMyPlacedPieces().get(gameLogic.getPlayer1().getMyPlacedPieces().indexOf(goodEndBtn)));
    gameLogic.placePieceWhite(badEndBtn);
    gameLogic.slidePiece(startBtn, badEndBtn);
    assertNotEquals(gameLogic.getPlayer1(), gameLogic.whosPiece(badEndBtn));
}

/** 
* 
* Method: movePiece(final JButton startBtn, final JButton endBtn) 
* 
*/ 
@Test
public void testMovePiece() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    JButton startBtn = new JButton();
    JButton goodEndBtn = new JButton();
    JButton badEndBtn = new JButton();
    gameLogic.placePiecePlayer(startBtn);
    gameLogic.movePiece(startBtn, goodEndBtn);
    assertEquals(goodEndBtn, gameLogic.getPlayer1().getMyPlacedPieces().get(gameLogic.getPlayer1().getMyPlacedPieces().indexOf(goodEndBtn)));
    gameLogic.placePieceWhite(badEndBtn);
    gameLogic.movePiece(startBtn, badEndBtn);
    assertNotEquals(gameLogic.getPlayer1(), gameLogic.whosPiece(badEndBtn));
} 

/** 
* 
* Method: openSpot(final JButton btn) 
* 
*/ 
@Test
public void testOpenSpot() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame testGame = new NineMensMorrisGame();
    NineMensMorrisPlayer player1 = testGame.getPlayer1();
    JButton btn = new JButton();
    btn.setBackground(Color.BLACK);
    testGame.placePiecePlayer(btn);
    assertEquals(testGame.getPlacedPieces().size(), 1);
    assertEquals(player1.getMyPlacedPieces().get(player1.getMyPlacedPieces().indexOf(btn)), btn);
} 

/** 
* 
* Method: checkLegalSlide(final JButton startBtn, final JButton endBtn) 
* 
*/ 
@Test
public void testCheckLegalSlide() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    JButton startBtn = new JButton();
    JButton goodEndBtn = new JButton();
    JButton badEndBtn = new JButton();
    gameLogic.placePiecePlayer(startBtn);
    assertEquals(true, gameLogic.checkLegalSlide(startBtn, goodEndBtn));
    gameLogic.placePieceWhite(badEndBtn);
    assertEquals(false, gameLogic.checkLegalSlide(startBtn, badEndBtn));
} 

/** 
* 
* Method: removePiece(final JButton btn) 
* 
*/ 
@Test
public void testRemovePiece() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    JButton btn1 = new JButton();
    gameLogic.placePieceBlack(btn1);
    gameLogic.removePiece(btn1);
    assertEquals(false, gameLogic.getPlayer1().checkIfMyPiece(btn1));
} 

/** 
* 
* Method: getPlacedPieces() 
* 
*/ 
@Test
public void testGetPlacedPieces() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    int random = new Random().nextInt(9);
    for (int i = 0; i < random; i++){
        JButton btn = new JButton();
        gameLogic.placePiecePlayer(btn);
    }
    assertEquals(random, gameLogic.getPlacedPieces().size());
} 

/** 
* 
* Method: whosPiece(final JButton btn) 
* 
*/ 
@Test
public void testWhosPiece() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    JButton btn1 = new JButton();
    JButton btn2 = new JButton();

    gameLogic.placePiecePlayer(btn1);
    gameLogic.placePieceWhite(btn2);
    assertEquals(gameLogic.getPlayer1(), gameLogic.whosPiece(btn1));
    assertEquals(gameLogic.getPlayer2(), gameLogic.whosPiece(btn2));
} 

/** 
* 
* Method: gameOver() 
* 
*/ 
@Test
public void testGameOver() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    gameLogic.getPlayer1().setTurnCounter(11);
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.getPlayer2().setTurnCounter(11);
    gameLogic.placePieceWhite(new JButton());
    gameLogic.placePieceWhite(new JButton());

    assertEquals(true, gameLogic.gameOver());
} 

/** 
* 
* Method: winningPlayer() 
* 
*/ 
@Test
public void testWinningPlayer() throws Exception {
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();
    gameLogic.getPlayer1().setTurnCounter(11);
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.getPlayer2().setTurnCounter(11);
    gameLogic.placePieceWhite(new JButton());
    gameLogic.placePieceWhite(new JButton());

    assertEquals(gameLogic.getPlayer1(), gameLogic.winningPlayer());
} 

/** 
* 
* Method: reset() 
* 
*/ 
@Test
public void testReset() throws Exception { 
//TODO: Test goes here...
    NineMensMorrisGame gameLogic = new NineMensMorrisGame();

    gameLogic.getPlayer1().setTurnCounter(11);
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.placePieceBlack(new JButton());
    gameLogic.getPlayer2().setTurnCounter(11);
    gameLogic.placePieceWhite(new JButton());
    gameLogic.placePieceWhite(new JButton());

    gameLogic.reset();

    assertEquals(false, gameLogic.getPlayer2().isTurnStatus());
    assertEquals(true, gameLogic.getPlayer1().isTurnStatus());
    assertEquals(0, gameLogic.getPlacedPieces().size());
    assertEquals(0, gameLogic.getPlayer1().getMyPlacedPieces().size());
    assertEquals(0, gameLogic.getPlayer2().getMyPlacedPieces().size());

} 


} 
