package sprint2.Uppg7;

import java.util.Scanner;

public class RäntaPåRänta {

    public static void main(String[] args) {
        // Skapa en Scanner för att läsa input
        Scanner scanner = new Scanner(System.in);

        // Läs in användarens input
        System.out.print("Ange startkapital: ");
        double startkapital = scanner.nextDouble();

        System.out.print("Ange räntesats (i procent): ");
        double ränta = scanner.nextDouble();

        System.out.print("Ange antal år: ");
        int antalAr = scanner.nextInt();

        // Skriver ut tabellrubriker med svenska bokstäver
        System.out.println("\nÅr\tSumma");
        System.out.println("-------------------------");

        // Beräkna ränta på ränta för varje år och skriv ut resultatet
        double kapital = startkapital;
        for (int år = 0; år <= antalAr; år++) {
            // Skriv ut året och beloppet för det året, formaterat till 2 decimaler
            System.out.printf("%-5d%14.2f kr\n", år, kapital);

            // Beräkna kapitalet för nästa år
            kapital *= (1 + ränta / 100);
        }

        scanner.close();
    }
}
