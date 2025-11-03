package sprint1.Uppg2;

// Abstrakt superklass
public abstract class Fordon implements Printable {
    protected double hastighet;
    protected double vikt;

    public Fordon(double hastighet, double vikt) {
        this.hastighet = hastighet;
        this.vikt = vikt;
    }

    public void ändraHastighet(double nyHastighet) {
        this.hastighet = nyHastighet;
    }
}
