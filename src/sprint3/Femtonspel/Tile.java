package sprint3.Femtonspel;
//Representerar varje enskild bricka i spelet
public class Tile {
    private final int value;

    public Tile(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    @Override
    public String toString() {
        return isEmpty() ? "" : String.valueOf(value);
    }
}