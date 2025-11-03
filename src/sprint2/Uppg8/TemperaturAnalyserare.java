package sprint2.Uppg8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TemperaturAnalyserare {

    public static void main(String[] args) {
        String filnamn = "src/sprint2/Uppg8/temp.txt";

        double summa = 0;
        int antal = 0;
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;

        try (Scanner scanner = new Scanner(new File(filnamn))) {
            while (scanner.hasNextLine()) {
                String rad = scanner.nextLine().trim();
                rad = rad.replace(",", ".");


                try {
                    double temp = Double.parseDouble(rad);

                    summa += temp;
                    antal++;

                    if (temp > maxTemp) maxTemp = temp;
                    if (temp < minTemp) minTemp = temp;

                } catch (NumberFormatException e) {
                    System.out.println("Ogiltig rad i filen: " + rad);
                }
            }

            if (antal > 0) {
                double medel = summa / antal;
                System.out.println("Lägsta temperatur: " + minTemp + "°C");
                System.out.println("Högsta temperatur: " + maxTemp + "°C");
                System.out.printf("Medeltemperatur: %.2f°C%n", medel);
            } else {
                System.out.println("Filen innehöll inga giltiga temperaturer.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta filen: " + filnamn);
        }
    }
}
