package sprint1.Uppg2;

public class Cykel extends Fordon implements Hjulburen {
    private int antalVäxlar;
    private int växelJustNu;
    private int antalHjul; // ny variabel

    public Cykel(double hastighet, double vikt, int antalVäxlar, int växelJustNu, int antalHjul) {
        super(hastighet, vikt);
        this.antalVäxlar = antalVäxlar;
        this.växelJustNu = växelJustNu;
        this.antalHjul = antalHjul;
    }

    public void växla(int nyVäxel) {
        if (nyVäxel > 0 && nyVäxel <= antalVäxlar) {
            växelJustNu = nyVäxel;
            System.out.println("Cykeln växlade till växel " + växelJustNu);
        } else {
            System.out.println("Ogiltig växel!");
        }
    }

    @Override
    public void printMe() {
        System.out.println("Cykel -> Hastighet: " + hastighet + " km/h, Vikt: " + vikt +
                " kg, Växlar: " + antalVäxlar + ", Nuvarande växel: " + växelJustNu +
                ", Hjul: " + antalHjul);
    }

    @Override
    public int getAntalHjul() {
        return antalHjul;
    }
}
