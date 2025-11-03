package sprint2.Tests.shapes;

import sprint2.Uppg1.Circle;

public class CircleTest {

    public static void main(String[] args) {
        // Test 1: getAreaTest
        Circle circle = new Circle(5);  // Area = π * 5^2 ≈ 78.54
        double expectedArea = Math.PI * Math.pow(5, 2); // π * r^2
        double area = circle.getArea();
        if (Math.abs(area - expectedArea) < 0.01) {
            System.out.println("getAreaTest passed!");
        } else {
            System.out.println("getAreaTest failed! Expected: " + expectedArea + ", Got: " + area);
        }

        // Test 2: getCircumferenceTest
        double expectedCircumference = 2 * Math.PI * 5; // 2 * π * r
        double circumference = circle.getCircumference();
        if (Math.abs(circumference - expectedCircumference) < 0.01) {
            System.out.println("getCircumferenceTest passed!");
        } else {
            System.out.println("getCircumferenceTest failed! Expected: " + expectedCircumference + ", Got: " + circumference);
        }
    }
}
