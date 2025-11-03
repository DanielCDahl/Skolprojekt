package sprint1.Uppg1;

/**
 * Klassen Bil representerar en bil med registreringsnummer, märke, modell och ägare.
 */
public class Bil {
    private String regNummer;
    private String märke;
    private String modell;
    private Bilägare ägare;

    public Bil(String regNummer, String märke, String modell, Bilägare ägare) {
        this.regNummer = regNummer;
        this.märke = märke;
        this.modell = modell;
        this.ägare = ägare;

        // Lägg till bilen hos ägaren om en sådan finns
        if (ägare != null) {
            ägare.läggTillBil(this);
        }
    }

    public String getRegNummer() {
        return regNummer;
    }

    public String getMärke() {
        return märke;
    }

    public String getModell() {
        return modell;
    }

    public Bilägare getÄgare() {
        return ägare;
    }

    // Metod för att köpa bil (byter ägare)
    public void köpBil(Bilägare nyÄgare) {
        if (this.ägare != null) {
            this.ägare.taBortBil(this);
        }
        this.ägare = nyÄgare;
        nyÄgare.läggTillBil(this);
        System.out.println(nyÄgare.getNamn() + " har köpt bilen " + märke + " (" + regNummer + ").");
    }

    // Metod för att sälja bil (tar bort ägare)
    public void säljBil() {
        if (this.ägare != null) {
            System.out.println(this.ägare.getNamn() + " har sålt bilen " + märke + " (" + regNummer + ").");
            this.ägare.taBortBil(this);
            this.ägare = null;
        } else {
            System.out.println("Bilen har ingen ägare att sälja från.");
        }
    }
}