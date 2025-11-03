package sprint2.Uppg9;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PersonRegister {
    private final List<Person> personer = new ArrayList<>();

    public void lasInFranFil(String filnamn) throws IOException {
        Path path = Paths.get(filnamn);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String rad;

            while ((rad = reader.readLine()) != null) {
                String namnOchAdress = rad;
                String dataRad = reader.readLine();

                if (dataRad == null) {
                    System.err.println("Felaktigt format: saknas data-rad efter " + namnOchAdress);
                    continue; // hoppa över
                }

                try {
                    String[] namnDelar = namnOchAdress.split(",", 2);
                    String namn = namnDelar[0].trim();
                    String adress = namnDelar.length > 1 ? namnDelar[1].trim() : "";

                    String[] dataDelar = dataRad.split(",");
                    int alder = Integer.parseInt(dataDelar[0].trim());
                    int vikt = Integer.parseInt(dataDelar[1].trim());
                    int langd = Integer.parseInt(dataDelar[2].trim());

                    Person person = new Person(namn, adress, alder, vikt, langd);
                    personer.add(person);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Felaktig rad: " + namnOchAdress + " / " + dataRad);
                }
            }
        }
    }

    public List<Person> getLangaPersoner(int langdMinst) {
        List<Person> langa = new ArrayList<>();
        for (Person p : personer) {
            if (p.getLangd() > langdMinst) {
                langa.add(p);
            }
        }
        return langa;
    }

    public List<Person> getAllaPersoner() {
        return personer;
    }
}