package sprint2.Uppg9;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PersonFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bygg filvägen till indatafilen dynamiskt från content root
        Path contentRoot = Paths.get(System.getProperty("user.dir"));
        Path inputPath = contentRoot.resolve("src/sprint2/Uppg9/Personuppgifter.txt");

        // Be användaren om filnamn (utan sökväg)
        System.out.print("Ange namn på utdatafil (t.ex. langaPersoner.txt): ");
        String utFilNamn = scanner.nextLine();

        // Skapa fullständig path till utdatafilen i samma mapp som indatafilen
        Path outputPath = inputPath.getParent().resolve(utFilNamn);

        PersonRegister register = new PersonRegister();

        try {
            // Använd den dynamiska filvägen
            register.lasInFranFil(inputPath.toString());
        } catch (IOException e) {
            System.out.println("Kunde inte läsa filen: " + e.getMessage());
            return;
        }

        List<Person> langaPersoner = register.getLangaPersoner(200);

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            for (Person p : langaPersoner) {
                writer.write(p.toString());
                writer.newLine();
            }
            System.out.println("Skrev " + langaPersoner.size() + " långa personer till " + outputPath.toString());
        } catch (IOException e) {
            System.out.println("Fel vid skrivning: " + e.getMessage());
        }
    }
}