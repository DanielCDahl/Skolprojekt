package sprint2.Uppg1;

public class Triangle implements Figure {
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (base * height) / 2.0;  // Area = bas * höjd / 2
    }

    @Override
    public double getCircumference() {
        // Beräkna sidlängden på de lika sidorna (från basen och höjden) via Pythagoras sats
        double sideLength = Math.sqrt(Math.pow(base / 2.0, 2) + Math.pow(height, 2));  // Hypotenusan
        return base + 2 * sideLength;  // Omkrets = bas + 2 * sidolängd
    }
}
