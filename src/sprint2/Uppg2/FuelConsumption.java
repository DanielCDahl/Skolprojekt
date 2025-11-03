package sprint2.Uppg2;

import javax.swing.JOptionPane;

public class FuelConsumption {

    public static void main(String[] args) {
        // Läs in data från användaren
        String currentOdometerString = JOptionPane.showInputDialog("Ange dagens mätarställning (mil):");
        String previousOdometerString = JOptionPane.showInputDialog("Ange mätarställning för ett år sedan (mil):");
        String fuelConsumedString = JOptionPane.showInputDialog("Ange antal liter bensin förbrukade:");

        // Omvandla inmatad data till double
        double currentOdometer = Double.parseDouble(currentOdometerString);
        double previousOdometer = Double.parseDouble(previousOdometerString);
        double fuelConsumed = Double.parseDouble(fuelConsumedString);

        // Beräkna körda mil
        double distance = calculateDistance(currentOdometer, previousOdometer);
        // Beräkna förbrukning per mil
        double fuelConsumptionPerMile = calculateFuelConsumptionPerMile(distance, fuelConsumed);

        // Skriv ut resultaten
        System.out.println("Antal körda mil: " + distance);
        System.out.println("Antal liter bensin: " + fuelConsumed);
        System.out.println("Förbrukning per mil: " + String.format("%.2f", fuelConsumptionPerMile));
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
