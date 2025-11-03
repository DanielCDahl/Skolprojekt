package sprint1.Greenest;

public abstract class Växt implements Vätskebehov{
    private String namn;     // inkapsling: private fält
    private double längd;    // i meter

    public Växt(String namn, double längd) {
        this.namn = namn;
        this.längd = längd;
    }

    public String getNamn() {
        return namn;
    }

    public double getLängd() {
        return längd;
    }
}