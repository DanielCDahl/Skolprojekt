package sprint1.Uppg1;

import java.util.ArrayList;
import java.util.List;

/**
 * Huvudklass för bilregistret.
 * Skapar bilägare och bilar, låter dem köpa/sälja och skriver ut resultatet.
 */
public class Main {
    private List<Bilägare> bilägareLista;
    private List<Bil> bilLista;

    // Konstruktor - all körlogik sker här
    public Main() {
        bilägareLista = new ArrayList<>();
        bilLista = new ArrayList<>();

        // Skapa några bilägare
        Bilägare anna = new Bilägare("Anna Andersson", "Storgatan 12", 35);
        Bilägare oskar = new Bilägare("Oskar Olsson", "Liljevägen 5", 42);
        Bilägare lisa = new Bilägare("Lisa Larsson", "Björkvägen 8", 28);

        bilägareLista.add(anna);
        bilägareLista.add(oskar);
        bilägareLista.add(lisa);

        // Skapa några bilar
        Bil bil1 = new Bil("ABC123", "Volvo", "XC60", anna);
        Bil bil2 = new Bil("XYZ789", "BMW", "i3", null);
        Bil bil3 = new Bil("KLM456", "Tesla", "Model 3", oskar);

        bilLista.add(bil1);
        bilLista.add(bil2);
        bilLista.add(bil3);

        // Händelser
        bil1.säljBil();          // Anna säljer sin bil
        bil2.köpBil(lisa);       // Lisa köper BMW:n
        bil3.köpBil(anna);       // Anna köper Teslan
        bil2.säljBil();          // Lisa säljer BMW:n
        bil3.köpBil(oskar);      // Oskar köper tillbaka Teslan

        // Utskrift
        System.out.println("\n--- Aktuellt bilregister ---");
        for (Bilägare b : bilägareLista) {
            b.skrivUtBilägare();
            System.out.println();
        }
    }

    // main() endast för att starta programmet
    public static void main(String[] args) {
        new Main();
    }
}