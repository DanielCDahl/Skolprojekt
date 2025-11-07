package sprint3.Femtonspel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Sköter användargränssnittet med hjälp av Swing
public class GameUI extends JFrame {
    private final GameController controller;
    private final JButton[][] buttons = new JButton[4][4];
    private final JPanel boardPanel = new JPanel(new GridLayout(4, 4, 5, 5));
    private final JLabel status = new JLabel(" ", SwingConstants.CENTER);

    public GameUI(GameController controller) {
        this.controller = controller;
        setTitle("15-spelet");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 500);
        setLocationRelativeTo(null);

        // Grid med knappar
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                JButton btn = new JButton();
                btn.setFont(new Font("Arial", Font.BOLD, 24));
                btn.addActionListener(new TileClickListener(r, c));
                buttons[r][c] = btn;
                boardPanel.add(btn);
            }
        }

        // Kontrollpanel
        JPanel controls = new JPanel(new BorderLayout());
        JButton newGame = new JButton("Nytt spel");
        newGame.addActionListener(e -> controller.newGame());
        controls.add(newGame, BorderLayout.CENTER);
        controls.add(status, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout(8, 8));
        getContentPane().add(boardPanel, BorderLayout.CENTER);
        getContentPane().add(controls, BorderLayout.SOUTH);
    }

    public void updateBoard() {
        Board board = controller.getBoard();
        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                Tile t = board.getTile(r, c);
                JButton b = buttons[r][c];
                b.setText(t.isEmpty() ? "" : String.valueOf(t.getValue()));
                b.setEnabled(!t.isEmpty());
            }
        }
        status.setText("Drag: " + controller.getMoves());
        repaint();
    }

    public void showWinMessage(int moves) {
        JOptionPane.showMessageDialog(this, "Grattis, du vann! Drag: " + moves);
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Fel", JOptionPane.WARNING_MESSAGE);
    }

    private class TileClickListener implements ActionListener {
        private final int row, col;

        private TileClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.handleTileClick(row, col);
        }
    }
}