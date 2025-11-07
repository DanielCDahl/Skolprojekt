package sprint3.Femtonspel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getTile() {
        Board b = new Board();
        Tile tile = b.getTile(0, 0);
        assertNotNull(tile);
    }

    @Test
    void findEmpty() {
        Board b = new Board();
        int[] empty = b.findEmpty();
        assertArrayEquals(new int[]{3, 3}, empty); // tom ruta i löst läge
    }

    @Test
    void canMove_adjacentMoves() {
        Board b = new Board();

        // Tom ruta i (3,3) → brickor (3,2) och (2,3) ska kunna flyttas
        assertTrue(b.canMove(3, 2));
        assertTrue(b.canMove(2, 3));

        // Ej bredvid → ej giltigt
        assertFalse(b.canMove(0, 0));
        assertFalse(b.canMove(1, 1));
    }

    @Test
    void moveTile_validMove() throws InvalidMoveException {
        Board b = new Board();
        int[] beforeEmpty = b.findEmpty();

        // Flytta brickan från vänster om den tomma rutan
        b.moveTile(3, 2);

        int[] afterEmpty = b.findEmpty();
        assertArrayEquals(new int[]{3, 2}, afterEmpty);
    }

    @Test
    void moveTile_invalidMoveThrows() {
        Board b = new Board();

        // Försök flytta en bricka som ej ligger bredvid tom ruta
        assertThrows(InvalidMoveException.class,
                () -> b.moveTile(0, 0));
    }

    @Test
    void shuffle_changesBoard() {
        Board b = new Board();
        b.initSolved();

        // Kopiera värden innan blandning
        int[][] before = new int[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                before[r][c] = b.getTile(r, c).getValue();
            }
        }

        b.shuffle();

        // Kolla att åtminstone någon tile ändrats
        boolean changed = false;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (before[r][c] != b.getTile(r, c).getValue()) {
                    changed = true;
                }
            }
        }

        assertTrue(changed, "Shuffle should change the board layout");
    }

    @Test
    void isSolved_initialBoardSolved() {
        Board b = new Board();
        assertTrue(b.isSolved());
    }
}
