package sprint2.Tests.fuel;

public class FuelConsumptionTest {

    public static void main(String[] args) {
        // Test 1: Beräkning av körda mil
        double currentOdometer = 10000; // Dagens mätarställning
        double previousOdometer = 8500; // Mätarställning för ett år sedan
        double fuelConsumed = 1235.4;  // Antal liter bensin förbrukad under året

        double distance = calculateDistance(currentOdometer, previousOdometer);
        if (distance == 1500.0) {
            System.out.println("Test för körda mil passed!");
        } else {
            System.out.println("Test för körda mil failed! Förväntat: 1500, Fick: " + distance);
        }

        // Test 2: Beräkning av förbrukning per mil
        double fuelConsumptionPerMile = calculateFuelConsumptionPerMile(distance, fuelConsumed);
        if (Math.abs(fuelConsumptionPerMile - 0.8236) < 0.01) {
            System.out.println("Test för förbrukning per mil passed!");
        } else {
            System.out.println("Test för förbrukning per mil failed! Förväntat: 0.8236, Fick: " + fuelConsumptionPerMile);
        }
    }

    // Beräkna körda mil
    public static double calculateDistance(double currentOdometer, double previousOdometer) {
        return currentOdometer - previousOdometer;
    }

    // Beräkna förbrukning per mil
    public static double calculateFuelConsumptionPerMile(double distance, double fuelConsumed) {
        return fuelConsumed / distance;
    }
}
