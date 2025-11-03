package sprint1.Uppg2;

public class Main {
    public static void main(String[] args) {
        // Fordon som implementerar Printable
        Printable bil = new Bil(120, 1500, 6, 3, 4);
        Printable cykel = new Cykel(25, 15, 7, 2, 2);
        Printable båt = new Båt(35, 12000, 4000);
        Printable tåg = new Tåg(100, 90000, 12);

        Printable[] allaFordon = {bil, cykel, båt, tåg};

        System.out.println("=== Utskrift via Printable ===");
        skrivUtAlla(allaFordon);

        // Fordon som implementerar Hjulburen
        Hjulburen bilHjul = (Hjulburen) bil;
        Hjulburen cykelHjul = (Hjulburen) cykel;

        Hjulburen[] hjulFordon = {bilHjul, cykelHjul};

        System.out.println("\n=== Utskrift via Hjulburen ===");
        skrivUtAntalHjul(hjulFordon);
    }

    public static void skrivUtAlla(Printable[] objekt) {
        for (Printable p : objekt) {
            p.printMe();
        }
    }

    public static void skrivUtAntalHjul(Hjulburen[] fordon) {
        for (Hjulburen h : fordon) {
            System.out.println("Detta fordon har " + h.getAntalHjul() + " hjul.");
        }
    }
}
