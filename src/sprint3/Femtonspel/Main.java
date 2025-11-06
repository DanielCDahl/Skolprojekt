package sprint3.Femtonspel;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameController controller = new GameController();
            GameUI ui = new GameUI(controller);
            controller.setUI(ui);
            controller.newGame();
            ui.setVisible(true);
        });
    }
}