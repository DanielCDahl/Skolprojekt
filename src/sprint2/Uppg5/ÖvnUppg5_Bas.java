package sprint2.Uppg5;

import static javax.swing.JOptionPane.*;
import java.util.*;

public class ÖvnUppg5_Bas {
    public static void main(String[] arg) {
        String indata = showInputDialog("Ange antal dagar, pris per dag samt bilmodell");

        // Kontrollera att användaren inte har lämnat fältet tomt
        if (indata == null || indata.trim().isEmpty()) {
            showMessageDialog(null, "Du måste ange alla parametrar!");
            return;  // Avsluta programmet om användaren inte har matat in något
        }

        Scanner sc = new Scanner(indata);

        try {
            // Första parameter: antal dagar (int)
            int antalDagar = sc.nextInt();

            // Andra parameter: pris per dag (double)
            double dagsPris = sc.nextDouble();

            // Tredje parameter: bilmodell (String)
            String bil = sc.next();

            // Beräkna det totala priset
            double totPris = dagsPris * antalDagar;

            // Formatera och visa resultatet
            String s = String.format("Totalt pris för %s: %.2f", bil, totPris);
            showMessageDialog(null, s);

        } catch (InputMismatchException e) {
            // Hantera felaktig inmatning av siffror (t.ex. om användaren skriver text istället för tal)
            showMessageDialog(null, "Felaktig inmatning. Vänligen ange giltiga siffror för antal dagar och pris.");
        } catch (NoSuchElementException e) {
            // Hantera fall där användaren inte anger tillräckligt med parametrar
            showMessageDialog(null, "Du måste ange både antal dagar, pris per dag och bilmodell.");
        } catch (Exception e) {
            // Fångar alla andra oväntade fel
            showMessageDialog(null, "Ett oväntat fel inträffade: " + e.getMessage());
        }
    }
}