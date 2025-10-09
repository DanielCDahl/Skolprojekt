package sprint1.Greenest;

import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Skapa växterna
        List<Vätskebehov> växter = new ArrayList<>();
        växter.add(new Kaktus("Igge", 0.20));           // 20 cm = 0.20 m
        växter.add(new Palm("Laura", 5.0));             // 5 meter
        växter.add(new KöttätandeVäxt("Meatloaf", 0.7));// 0.7 meter
        växter.add(new Palm("Olof", 1.0));              // 1 meter

        // Fråga användaren
        String namn = JOptionPane.showInputDialog(null, "Vilken växt ska få vätska?");

        boolean hittad = false;
        for (Vätskebehov växt : växter) {
            if (((Växt) växt).getNamn().equalsIgnoreCase(namn)) {
                double mängd = växt.beräknaVätskemängd();
                Vätsketyp typ = växt.getVätsketyp();

                String meddelande = ((Växt) växt).getNamn() + " ska få "
                        + String.format("%.2f", mängd) + " liter "
                        + typ.toString().toLowerCase();

                JOptionPane.showMessageDialog(null, meddelande);
                hittad = true;
                break;
            }
        }

        if (!hittad) {
            JOptionPane.showMessageDialog(null, "Växten finns inte på hotellet!");
        }
    }
}
