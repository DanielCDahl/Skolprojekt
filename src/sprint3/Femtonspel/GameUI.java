package sprint3.Femtonspel;

public class GameUI {
/**
  Fält:
    [ ] frame : JFrame
    [ ] gridPanel : JPanel (GridLayout 4x4)
    [ ] buttons : JButton[4][4]
    [ ] newGameButton : JButton
    [ ] controller : GameController

  TODO:

  [ ] Konstruktor GameUI():
        - Skapa nytt JFrame("15-spelet")
        - Skapa gridPanel med GridLayout(4,4)
        - För varje rad/kolumn:
             [ ] Skapa JButton
             [ ] Lägg till actionListener som anropar controller.onTileClicked(r, c)
             [ ] Lägg till knappen i gridPanel och buttons-array
        - Skapa "Nytt spel"-knapp
             [ ] Lägg till actionListener som anropar controller.onNewGame()
        - Lägg till paneler i frame (CENTER/SOUTH)
        - pack() och setDefaultCloseOperation(EXIT_ON_CLOSE)

  [ ] setController(controller):
        - Spara controller i fältet

  [ ] updateBoard(board):
        - För varje knapp i buttons:
            [ ] Hämta tile från board
            [ ] Uppdatera knappens text till tile.toString()

  [ ] showWinMessage(moves):
        - Visa JOptionPane.showMessageDialog med "Grattis, du vann på X drag!"

  [ ] show():
        - Gör frame synlig (setVisible(true))
*/
}
