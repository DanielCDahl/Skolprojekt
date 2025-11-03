package sprint2.Uppg6;

import java.util.Scanner;

public class ChangeCalculator {

    // Testparameter
    public static boolean isTestMode = false;

    // Lista med alla valörer, från högsta till lägsta
    public static final int[] DENOMINATIONS = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
    // Lista med ord för varje valör
    private static final String[] VALOR_NAMES = {
            "lappar", "lappar", "lappar", "lappar", "lappar",
            "lappar", "kronor", "kronor", "kronor", "kronor"
    };

    // Metod för att läsa in värden
    public static double[] readInput() {
        Scanner scanner = new Scanner(System.in);

        double[] inputValues = new double[2];

        try {
            // Läs pris och betalt belopp från användaren
            System.out.print("Ange priset: ");
            inputValues[0] = Double.parseDouble(scanner.nextLine());

            System.out.print("Ange betalt belopp: ");
            inputValues[1] = Double.parseDouble(scanner.nextLine());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ogiltig inmatning. Ange ett giltigt nummer.");
        }

        return inputValues;
    }

    // Metod för att beräkna växel
    public static void calculateChange(double pris, double betaltBelopp) {
        StringBuilder sb = new StringBuilder();  // StringBuilder för att samla alla utskrifter

        if (betaltBelopp < pris) {
            sb.append("Du lämnade för lite pengar");
            System.out.println(sb.toString());
            return;
        }

        // Om vi betalar exakt
        if (betaltBelopp == pris) {
            sb.append("Det blev ingen växel");
            System.out.println(sb.toString());
            return;
        }

        // Beräkna växeln som ska ges tillbaka
        double change = betaltBelopp - pris;
        int[] changeArray = new int[DENOMINATIONS.length];

        // Beräkna växel för varje valör
        for (int i = 0; i < DENOMINATIONS.length; i++) {
            changeArray[i] = (int)(change / DENOMINATIONS[i]);
            change -= changeArray[i] * DENOMINATIONS[i];
            change = Math.round(change * 100.0) / 100.0;  // Hantera avrundning
        }

        // Lägg till varje rad i StringBuildern
        for (int i = 0; i < DENOMINATIONS.length; i++) {
            if (changeArray[i] > 0) {
                String valörName = (DENOMINATIONS[i] > 10) ? VALOR_NAMES[i] : "kronor";
                sb.append("Antal " + DENOMINATIONS[i] + "-" + valörName + ": " + changeArray[i] + "\n");
            }
        }

        // Skriv ut resultatet
        System.out.println(sb.toString());
    }

    // Main-metod, där vi skiljer på testläge och produktion
    public static void main(String[] args) {
        if (isTestMode) {
            // För testläge kan vi här simulera inläsning utan att be om användarinmatning
            double[] mockInput = {654, 1000};  // Mockade värden
            calculateChange(mockInput[0], mockInput[1]);
        } else {
            try {
                double[] inputValues = readInput();  // Läs in data från användaren
                calculateChange(inputValues[0], inputValues[1]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
