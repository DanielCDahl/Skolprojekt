package sprint3.Femtonspel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//Spelets logik och spelbräde
public class Board {

    private static final int SIZE = 4;
    private final Tile[][] tiles = new Tile[SIZE][SIZE];
    private final Random rnd = new Random();

    public Board() {
        initSolved();
    }

    public int getSize() {
        return SIZE;
    }

    public Tile getTile(int r, int c) {
        return tiles[r][c];
    }

    public void initSolved() {
        int val = 1;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (r == SIZE - 1 && c == SIZE - 1) {
                    tiles[r][c] = new Tile(0); // tom
                } else {
                    tiles[r][c] = new Tile(val++);
                }
            }
        }
    }

    public int[] findEmpty() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (tiles[r][c].isEmpty()) return new int[]{r, c};
            }
        }
        return new int[]{SIZE - 1, SIZE - 1};
    }

    public boolean canMove(int r, int c) {
        int[] e = findEmpty();
        int er = e[0], ec = e[1];
        return (Math.abs(er - r) == 1 && ec == c) || (Math.abs(ec - c) == 1 && er == r);
    }

    public void moveTile(int r, int c) throws InvalidMoveException {
        if (!canMove(r, c)) {
            throw new InvalidMoveException("Ogiltigt drag: brickan ligger inte bredvid den tomma rutan.");
        }
        int[] e = findEmpty();
        int er = e[0], ec = e[1];
        swap(r, c, er, ec);
    }

    private void swap(int r1, int c1, int r2, int c2) {
        Tile tmp = tiles[r1][c1];
        tiles[r1][c1] = tiles[r2][c2];
        tiles[r2][c2] = tmp;
    }

    public void shuffle() {
        initSolved();
        int steps = 1000;
        int pr, pc; // rutan börjar längst ned till höger
        for (int i = 0; i < steps; i++) {
            int[] e = findEmpty();
            pr = e[0];
            pc = e[1];
            int[][] neighbors = neighborsOf(pr, pc);
            int[] choice = neighbors[rnd.nextInt(neighbors.length)];
            // flytta vald granne in i rutan (swap)
            swap(choice[0], choice[1], pr, pc);
        }
    }

    private int[][] neighborsOf(int r, int c) {
        List<int[]> list = new ArrayList<>();
        if (r > 0) list.add(new int[]{r - 1, c});
        if (r < SIZE - 1) list.add(new int[]{r + 1, c});
        if (c > 0) list.add(new int[]{r, c - 1});
        if (c < SIZE - 1) list.add(new int[]{r, c + 1});
        return list.toArray(new int[0][]);
    }

    public boolean isSolved() {
        int expected = 1;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (r == SIZE - 1 && c == SIZE - 1) {
                    return tiles[r][c].isEmpty();
                }
                if (tiles[r][c].getValue() != expected++) return false;
            }
        }
        return true;
    }
}