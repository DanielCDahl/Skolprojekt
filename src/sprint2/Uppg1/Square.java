package sprint2.Uppg1;

public class Square implements Figure {
    private int length;
    private int width;

    public Square(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getCircumference() {
        return 2 * (length + width);
    }
}
