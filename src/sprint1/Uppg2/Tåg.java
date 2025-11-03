package sprint1.Uppg2;

public class Tåg extends Fordon {
    private int antalVagnar;

    public Tåg(double hastighet, double vikt, int antalVagnar) {
        super(hastighet, vikt);
        this.antalVagnar = antalVagnar;
    }

    public void kopplaVagn() {
        antalVagnar++;
        System.out.println("En vagn kopplades till. Antal vagnar: " + antalVagnar);
    }

    @Override
    public void printMe() {
        System.out.println("Tåg -> Hastighet: " + hastighet + " km/h, Vikt: " + vikt +
                " ton, Antal vagnar: " + antalVagnar);
    }
}
