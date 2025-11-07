package sprint3.Femtonspel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void getBoard() {
        GameController controller = new GameController();
        assertNotNull(controller.getBoard());
    }

    @Test
    void getMoves_initiallyZero() {
        GameController controller = new GameController();
        assertEquals(0, controller.getMoves());
    }

    @Test
    void newGame_resetsMoves() {
        GameController controller = new GameController();
        controller.newGame();
        assertEquals(0, controller.getMoves());
    }

    @Test
    void handleTileClick_validMoveIncrementsMoves() {
        GameController controller = new GameController();

        // Vi simulerar ett UI, men UI är inte nödvändigt för att logiken ska fungera
        controller.newGame();

        // För att garantera att vi kan flytta en bricka:
        // Placera brädet i löst läge
        controller.getBoard().initSolved();

        // Flytta brickan till vänster om tom ruta (3,2)
        controller.handleTileClick(3, 2);

        assertEquals(1, controller.getMoves());
    }

    @Test
    void handleTileClick_invalidMoveDoesNotIncrement() {
        GameController controller = new GameController();
        controller.newGame();

        // Löst läge
        controller.getBoard().initSolved();

        // Klicka på en ogiltig ruta, exempel (0,0)
        controller.handleTileClick(0, 0);

        assertEquals(0, controller.getMoves());
    }
}
