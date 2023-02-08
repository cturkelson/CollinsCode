package SuiteOfGames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LiarsDiceGameTest {

    @Before
    public void before() throws Exception {
        System.out.println("Beginning tests");
    }

    @After
    public void after() throws Exception {
        System.out.println("Tests Complete");
    }

    @Test
    public void nextTurn() {
        LiarsDiceGame game = new LiarsDiceGame(null);
        game.nextTurn();
        assertEquals(game.returnCurrent(), Player.Black);
        assertEquals(game.returnPrev(), Player.Jack);
        game.nextTurn();
        assertEquals(game.returnCurrent(), Player.Hook);
        assertEquals(game.returnPrev(), Player.Black);
        game.nextTurn();
        assertEquals(game.returnCurrent(), Player.Will);
        assertEquals(game.returnPrev(), Player.Hook);
        game.nextTurn();
        assertEquals(game.returnCurrent(), Player.Jack);
        assertEquals(game.returnPrev(), Player.Will);


    }


    @Test
    public void reset() {
        LiarsDiceGame game = new LiarsDiceGame(null);
        game.nextTurn();
        game.reset();
        assertEquals(game.returnCurrent(), Player.Jack);
        game.nextTurn();
        game.nextTurn();
        game.reset();
        assertEquals(game.returnCurrent(), Player.Jack);
        game.nextTurn();
        game.nextTurn();
        game.nextTurn();
        game.reset();
        assertEquals(game.returnCurrent(), Player.Jack);
        game.nextTurn();
        game.nextTurn();
        game.nextTurn();
        game.nextTurn();
        game.reset();
        assertEquals(game.returnCurrent(), Player.Jack);
    }

    @Test
    public void returnCurrent() {
        LiarsDiceGame game = new LiarsDiceGame(null);
        game.nextTurn();
        assertEquals(game.returnCurrent(), Player.Black);
        game.nextTurn();
        assertEquals(game.returnCurrent(), Player.Hook);
        game.nextTurn();
        assertEquals(game.returnCurrent(), Player.Will);
        game.nextTurn();
        assertEquals(game.returnCurrent(), Player.Jack);
    }

    @Test
    public void returnPrev() {

        LiarsDiceGame game = new LiarsDiceGame(null);
        game.nextTurn();
        assertEquals(game.returnPrev(), Player.Jack);
        game.nextTurn();
        assertEquals(game.returnPrev(), Player.Black);
        game.nextTurn();
        assertEquals(game.returnPrev(), Player.Hook);
        game.nextTurn();
        assertEquals(game.returnPrev(), Player.Will);

    }

    @Test
    public void setValueGuess() {
        LiarsDiceGame game = new LiarsDiceGame(null);
        int n = 1;
        game.setValueGuess(n);
        assertEquals(game.getValueGuess(), n);
    }

    @Test
    public void setAmountGuess() {
        LiarsDiceGame game = new LiarsDiceGame(null);
        int n = 1;
        game.setAmountGuess(n);
        assertEquals(game.getAmountGuess(), n);
    }

    @Test
    public void liar() {
        LiarsDiceGame game = new LiarsDiceGame(null);
        game.setValueGuess(3);
        game.setAmountGuess(0);
        assertEquals(game.liar(), false);
        game.setAmountGuess(30);
        assertEquals(game.liar(), true);
    }
}