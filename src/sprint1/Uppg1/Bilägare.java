package sprint1.Uppg1;

import java.util.ArrayList;
import java.util.List;

/**
 * Bilägare ärver från Person och håller koll på vilka bilar personen äger.
 */
public class Bilägare extends Person {
    private List<Bil> bilar; // lista över bilar som ägs

    public Bilägare(String namn, String adress, int ålder) {
        super(namn, adress, ålder);
        this.bilar = new ArrayList<>();
    }

    // Lägg till en bil i listan
    public void läggTillBil(Bil bil) {
        if (!bilar.contains(bil)) {
            bilar.add(bil);
        }
    }

    // Ta bort en bil ur listan
    public void taBortBil(Bil bil) {
        bilar.remove(bil);
    }

    public List<Bil> getBilar() {
        return bilar;
    }

    // Skriver ut bilägaren och hens bilar
    public void skrivUtBilägare() {
        System.out.println("Bilägare: " + getNamn() + " (" + getÅlder() + " år)");
        if (bilar.isEmpty()) {
            System.out.println("  Äger inga bilar just nu.");
        } else {
            System.out.println("  Äger följande bilar:");
            for (Bil bil : bilar) {
                System.out.println("    - " + bil.getMärke() + " " + bil.getModell() + " (" + bil.getRegNummer() + ")");
            }
        }
    }
}