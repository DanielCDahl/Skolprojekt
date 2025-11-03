package sprint2.Uppg3;

import java.util.Scanner;

public class Mimic {

    public static void main(String[] args) {
        // Skapar en Scanner för att läsa in input från kommandoraden
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv något (eller 'exit' för att avsluta):");

        // Loopar för att läsa in och skriva ut användarens input tills användaren skriver 'exit'
        while (true) {
            // Läser in en rad från användaren
            String input = scanner.nextLine();

            // Om användaren skriver 'exit', avsluta programmet
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Programmet avslutas.");
                break;
            }

            // Skriver ut det användaren skrev
            System.out.println("Du skrev: " + input);
        }

        // Stänger scannern när programmet är klart
        scanner.close();
    }
}
