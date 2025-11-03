package sprint2.Tests.shapes;

import sprint2.Uppg1.Square;

public class SquareTest {

    public static void main(String[] args) {
        // Test 1: getAreaTest
        Square square = new Square(5, 4);  // Area = 5 * 4 = 20
        double area = square.getArea();
        if (area == 20) {
            System.out.println("getAreaTest passed!");
        } else {
            System.out.println("getAreaTest failed! Expected: 20, Got: " + area);
        }

        // Test 2: getCircumferenceTest
        double circumference = square.getCircumference();  // Omkrets = 2 * (5 + 4) = 18
        if (circumference == 18) {
            System.out.println("getCircumferenceTest passed!");
        } else {
            System.out.println("getCircumferenceTest failed! Expected: 18, Got: " + circumference);
        }
    }
}
