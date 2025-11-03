package sprint1.Greenest;

public class KöttätandeVäxt extends Växt implements Vätskebehov {
    public KöttätandeVäxt(String namn, double längd) {
        super(namn, längd);
    }

    @Override
    public double beräknaVätskemängd() {
        return 0.1 + (0.2 * getLängd());
    }

    @Override
    public Vätsketyp getVätsketyp() {
        return Vätsketyp.PROTEINDRYCK;
    }
}
