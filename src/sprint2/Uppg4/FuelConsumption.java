package sprint2.Uppg4;

import java.util.Scanner;
import java.util.Locale;

public class FuelConsumption {

    public static void main(String[] args) {
        // Skapa en Scanner med Locale.US för att alltid använda punkt som decimalavskiljare
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Läs in data från användaren
        System.out.print("Ange dagens mätarställning (mil): ");
        double currentOdometer = scanner.nextDouble();  // Läs in dagens mätarställning

        System.out.print("Ange mätarställning för ett år sedan (mil): ");
        double previousOdometer = scanner.nextDouble(); // Läs in mätarställningen för ett år sedan

        System.out.print("Ange antal liter bensin förbrukade: ");
        double fuelConsumed = scanner.nextDouble(); // Läs in antal liter bensin

        // Beräkna körda mil
        double distance = calculateDistance(currentOdometer, previousOdometer);

        // Beräkna förbrukning per mil
        double fuelConsumptionPerMile = calculateFuelConsumptionPerMile(distance, fuelConsumed);

        // Skriv ut resultat
        System.out.println("Antal körda mil: " + (int) distance);  // Skriver ut körda mil som heltal
        System.out.println("Antal liter bensin: " + fuelConsumed);
        System.out.println("Förbrukning per mil: " + String.format("%.2f", fuelConsumptionPerMile));

        // Stäng Scanner när vi är klara
        scanner.close();
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