package sprint1.Greenest;

public class Kaktus extends Växt implements Vätskebehov {
    public Kaktus(String namn, double längd) {
        super(namn, längd);
    }

    @Override
    public double beräknaVätskemängd() {
        return 0.02; // 2 cl = 0.02 liter
    }

    @Override
    public Vätsketyp getVätsketyp() {
        return Vätsketyp.MINERALVATTEN;
    }
}
