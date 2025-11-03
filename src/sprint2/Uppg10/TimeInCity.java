package sprint2.Uppg10;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Scanner;

public class TimeInCity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.print("Ange en stad: ");
            String input = scanner.nextLine();

            CityTimeZone city = CityTimeZone.fromInput(input);

            if (city != null) {
                ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of(city.getTimeZoneId()));
                String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                System.out.println("Aktuell tid i " + formatCityName(city.getCityName()) + ": " + formattedTime);
            } else {
                System.out.println("Fel: Staden \"" + input.trim() + "\" stöds inte.");
                System.out.println("Stödda städer: " + getSupportedCities());
            }

            System.out.print("Vill du söka efter en till stad? (ja/nej): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("ja")) {
                continueRunning = false;
                System.out.println("Avslutar programmet. Hej då!");
            }
        }

        scanner.close();
    }

    private static String formatCityName(String city) {
        String[] parts = city.split(" ");
        StringBuilder formatted = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                formatted.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1)).append(" ");
            }
        }
        return formatted.toString().trim();
    }

    private static String getSupportedCities() {
        StringBuilder builder = new StringBuilder();
        for (CityTimeZone city : CityTimeZone.values()) {
            builder.append(city.getCityName()).append(", ");
        }
        // Ta bort sista kommatecknet och mellanslaget
        if (builder.length() > 2) {
            builder.setLength(builder.length() - 2);
        }
        return builder.toString();
    }
}