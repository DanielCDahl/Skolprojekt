package sprint1.Greenest;

public class Palm extends Växt implements Vätskebehov {
    public Palm(String namn, double längd) {
        super(namn, längd);
    }

    @Override
    public double beräknaVätskemängd() {
        return 0.5 * getLängd();
    }

    @Override
    public Vätsketyp getVätsketyp() {
        return Vätsketyp.KRANVATTEN;
    }
}