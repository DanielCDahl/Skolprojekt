package sprint1.Uppg1;

public class Person {
    private String namn;
    private String adress;
    private int ålder;

    public Person(String namn, String adress, int ålder) {
        this.namn = namn;
        this.adress = adress;
        this.ålder = ålder;
    }

    public String getNamn() {
        return namn;
    }

    public String getAdress() {
        return adress;
    }

    public int getÅlder() {
        return ålder;
    }

    public void skrivUtInfo() {
        System.out.println("Namn: " + namn + ", Adress: " + adress + ", Ålder: " + ålder);
    }
}