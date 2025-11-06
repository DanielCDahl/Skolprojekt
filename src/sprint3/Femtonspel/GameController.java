package sprint3.Femtonspel;

public class GameController { //
    private final Board board;
    private GameUI ui;
    private int moves = 0;

    public GameController() {
        this.board = new Board();
    }

    public void setUI(GameUI ui) {
        this.ui = ui;
    }

    public Board getBoard() {
        return board;
    }

    public int getMoves() {
        return moves;
    }

    public void newGame() {
        board.shuffle();
        moves = 0;
        if (ui != null) ui.updateBoard();
    }

    public void handleTileClick(int row, int col) {
        try {
            board.moveTile(row, col);
            moves++;
            if (ui != null) ui.updateBoard();
            if (board.isSolved()) {
                if (ui != null) ui.showWinMessage(moves);
            }
        } catch (InvalidMoveException ex) {
            if (ui != null) ui.showError(ex.getMessage());
        }
    }
}
