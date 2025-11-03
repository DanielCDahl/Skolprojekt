package sprint2.Tests.shapes;

import sprint2.Uppg1.Triangle;

public class TriangleTest {

    public static void main(String[] args) {
        // Test 1: getAreaTest
        Triangle triangle = new Triangle(6, 4);  // Area = 6 * 4 / 2 = 12
        double area = triangle.getArea();
        if (area == 12) {
            System.out.println("getAreaTest passed!");
        } else {
            System.out.println("getAreaTest failed! Expected: 12, Got: " + area);
        }

        // Test 2: getCircumferenceTest
        double sideLength = Math.sqrt(Math.pow(6 / 2.0, 2) + Math.pow(4, 2)); // Sidolängd = 5
        double circumference = triangle.getCircumference();  // Omkrets = 6 + 2 * 5 = 16
        if (circumference == 16) {
            System.out.println("getCircumferenceTest passed!");
        } else {
            System.out.println("getCircumferenceTest failed! Expected: 16, Got: " + circumference);
        }
    }
}
