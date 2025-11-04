package sprint3.Femtonspel;

public class GameController {
/**
  Fält:
    [ ] board : Board
    [ ] ui : GameUI
    [ ] moves : int = 0

  TODO:

  [ ] Konstruktor GameController(Board, GameUI)
        - Spara båda i fälten

  [ ] onTileClicked(r, c):
        - Försök flytta brickan genom board.moveTile(r, c)
        - Fånga ev. InvalidMoveException och ignorera (brickan ej intill tom)
        - Om flytt lyckas:
             [ ] Öka moves++
             [ ] Uppdatera UI med ui.updateBoard(board)
             [ ] Om board.isSolved() == true
                  [ ] Anropa ui.showWinMessage(moves)

  [ ] onNewGame():
        - Anropa board.shuffle()
        - Nollställ moves = 0
        - Uppdatera UI med ui.updateBoard(board)
*/
}
