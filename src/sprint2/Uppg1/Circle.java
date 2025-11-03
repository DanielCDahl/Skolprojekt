package sprint2.Uppg1;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);  // Area = π * r^2
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;  // Omkrets = 2 * π * r
    }
}
