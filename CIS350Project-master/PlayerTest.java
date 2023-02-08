package SuiteOfGames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void next() {
        Player jeff = Player.Jack;
        jeff = jeff.next();
        assertEquals(jeff, Player.Black);
        jeff = jeff.next();
        assertEquals(jeff, Player.Hook);
        jeff = jeff.next();
        assertEquals(jeff, Player.Will);
        jeff = jeff.next();
        assertEquals(jeff, Player.Jack);
    }
}