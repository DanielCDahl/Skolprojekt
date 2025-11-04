package sprint3.Femtonspel;

public class Board {
/**
  Fält:
    [ ] rows : int = 4
    [ ] cols : int = 4
    [ ] tiles : Tile[4][4]

  TODO:

  [ ] Konstruktor:
        - Anropa initSolved()

  [ ] initSolved():
        - Fyll brädet med brickor i nummerordning 1–15
        - Sista positionen (3,3) ska vara tom (id = 0)

  [ ] getTile(r, c):
        - Returnera tiles[r][c]

  [ ] findEmpty():
        - Loopa igenom alla positioner
        - Returnera (r, c) för brickan som är tom (id == 0)

  [ ] canMove(r, c):
        - Hämta tomma brickans koordinater (emptyR, emptyC)
        - Returnera true om (r, c) ligger precis intill tomma brickan
          d.v.s. |emptyR - r| == 1 och emptyC == c
                  eller |emptyC - c| == 1 och emptyR == r

  [ ] moveTile(r, c):
        - Om canMove(r, c) == false → kasta InvalidMoveException
        - Annars byt plats på tiles[r][c] och den tomma brickan
        - Returnera true efter bytet

  [ ] shuffle():
        - Anropa initSolved() för att börja från korrekt ordning
        - Upprepa t.ex. 1000 gånger:
            [ ] Hitta tom ruta
            [ ] Lista giltiga grannar (upp, ner, vänster, höger)
            [ ] Välj slumpmässig granne
            [ ] Anropa moveTile() på den grannen (få giltig blandning)

  [ ] isSolved():
        - expected = 1
       - Loopa över alla positioner
            [ ] Om r==3 och c==3 → kontrollera att id == 0
            [ ] Annars → kontrollera att id == expected
            [ ] Om något inte stämmer → returnera false
            [ ] Öka expected
        - Returnera true om allt stämmer
*/
}
