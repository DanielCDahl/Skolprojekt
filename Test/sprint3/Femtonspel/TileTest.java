package sprint3.Femtonspel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void getValue() {
        Tile t = new Tile(7);
        assertEquals(7, t.getValue());
    }

    @Test
    void isEmpty() {
        Tile empty = new Tile(0);
        Tile nonEmpty = new Tile(5);
        assertTrue(empty.isEmpty());
        assertFalse(nonEmpty.isEmpty());
    }

    @Test
    void testToString() {
        Tile empty = new Tile(0);
        Tile t = new Tile(12);

        assertEquals("", empty.toString());
        assertEquals("12", t.toString());
    }
}