package sprint1.Uppg2;

public class Båt extends Fordon {
    private double dödvikt;

    public Båt(double hastighet, double vikt, double dödvikt) {
        super(hastighet, vikt);
        this.dödvikt = dödvikt;
    }

    public void sväng(String riktning) {
        System.out.println("Båten svänger åt " + riktning);
    }

    @Override
    public void printMe() {
        System.out.println("Båt -> Hastighet: " + hastighet + " knop, Vikt: " + vikt +
                " ton, Dödvikt: " + dödvikt);
    }
}
