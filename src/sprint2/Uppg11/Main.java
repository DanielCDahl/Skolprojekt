package sprint2.Uppg11;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Videobandets längd
            System.out.print("Ange videobandets totala längd (i minuter): ");
            int totalMinutes = Integer.parseInt(scanner.nextLine());

            // 2. Använd tid
            System.out.print("Ange hur mycket tid som redan är använd (i minuter): ");
            int usedMinutes = Integer.parseInt(scanner.nextLine());

            // 3. Starttid
            System.out.print("När börjar tv-programmet? (tt:mm): ");
            LocalTime startTime = LocalTime.parse(scanner.nextLine());

            // 4. Sluttid
            System.out.print("När slutar tv-programmet? (tt:mm): ");
            LocalTime endTime = LocalTime.parse(scanner.nextLine());

            // 5. Programtyp
            System.out.print("Ange programtyp (MOVIE, DOCUMENTARY, SPORTS, NEWS, COMEDY, OTHER): ");
            ProgramType type = ProgramType.valueOf(scanner.nextLine().toUpperCase());

            // Skapa objekt
            VideoBand band = new VideoBand(totalMinutes, usedMinutes);
            TvProgram program = new TvProgram(startTime, endTime, type);

            // Skriv ut info
            System.out.println("\n--- Sammanfattning ---");
            System.out.println(band);
            System.out.println(program);

            if (VideoBandCalculator.canRecord(band, program)) {
                System.out.println("✅ Programmet får plats på bandet.");

            // Beräkna återstående tid efter inspelning
            int remainingAfterRecording = band.getRemainingMinutes() - (int) program.getDurationInMinutes();
                System.out.println("📼 Plats kvar på bandet efter inspelning: " + remainingAfterRecording + " minuter");

            } else {
                System.out.println("❌ Programmet får INTE plats på bandet.");
            }

        } catch (Exception e) {
            System.out.println("\n⚠️ Fel: " + e.getMessage());
        }

        scanner.close();
    }
}
