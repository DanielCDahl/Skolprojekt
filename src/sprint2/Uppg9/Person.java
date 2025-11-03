package sprint2.Uppg9;

public class Person {
    private final String namn;
    private final String adress;
    private final int alder;
    private final int vikt;
    private final int langd; // i cm

    public Person(String namn, String adress, int alder, int vikt, int langd) {
        this.namn = namn;
        this.adress = adress;
        this.alder = alder;
        this.vikt = vikt;
        this.langd = langd;
    }

    public int getLangd() {
        return langd;
    }

    public String getNamn() {
        return namn;
    }

    public String getAdress() {
        return adress;
    }

    public int getAlder() {
        return alder;
    }

    public int getVikt() {
        return vikt;
    }

    @Override
    public String toString() {
        return namn + ", " + adress + "\n" + alder + ", " + vikt + ", " + langd;
    }
}