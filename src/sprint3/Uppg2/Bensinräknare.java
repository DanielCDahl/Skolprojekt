package sprint3.Uppg2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Bensinräknare extends JFrame {
    private JTextField mätarställningNuField, mätarställningFörEttÅrSedanField, bensinFörbrukningField;
    private JLabel resultatLabel;

    // Konstruktor för att skapa GUI:t
    public Bensinräknare() {
        // Layout
        setLayout(new BorderLayout(10, 10)); // Använder BorderLayout för att organisera komponenter

        // Skapa ett panel för att hålla textfält och etiketter
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10)); // GridLayout för input

        // Skapa etiketter och textfält
        inputPanel.add(new JLabel("Ange mätarställning nu:"));
        mätarställningNuField = new JTextField();
        inputPanel.add(mätarställningNuField);

        inputPanel.add(new JLabel("Ange mätarställning för ett år sedan:"));
        mätarställningFörEttÅrSedanField = new JTextField();
        inputPanel.add(mätarställningFörEttÅrSedanField);

        inputPanel.add(new JLabel("Ange antal liter förbrukad bensin:"));
        bensinFörbrukningField = new JTextField();
        inputPanel.add(bensinFörbrukningField);

        // Lägg till panelen för inmatning i fönstret
        add(inputPanel, BorderLayout.NORTH);

        // Resultatlabel som visas längst ner
        resultatLabel = new JLabel("Antal körda mil: 0   Antal liter bensin: 0   Förbrukning per mil: 0,0", JLabel.CENTER);
        add(resultatLabel, BorderLayout.CENTER);

        // Skapa en knapp och lägg till ActionListener
        JButton beräknaButton = new JButton("Beräkna");
        beräknaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beräknaFörbrukning();
            }
        });

        // Lägg till knappen längst ner
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrerar knappen
        buttonPanel.add(beräknaButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Grundinställningar för fönstret
        setTitle("Bensinräknare");
        setSize(450, 300);  // Öka storleken på fönstret för bättre passform
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrerar fönstret
    }

    // Metod för att beräkna och visa resultat
    private void beräknaFörbrukning() {
        try {
            // Hämta inmatade värden och konvertera till double
            double mätarställningNu = Double.parseDouble(mätarställningNuField.getText());
            double mätarställningFörEttÅrSedan = Double.parseDouble(mätarställningFörEttÅrSedanField.getText());
            double bensinFörbrukning = Double.parseDouble(bensinFörbrukningField.getText());

            // Beräkna antal körda mil
            double antalKördaMil = mätarställningNu - mätarställningFörEttÅrSedan;

            // Beräkna förbrukning per mil
            double förbrukningPerMil = bensinFörbrukning / antalKördaMil;

            // Formatera resultat
            DecimalFormat df = new DecimalFormat("#,##0.0");
            resultatLabel.setText("<html>Antal körda mil: " + df.format(antalKördaMil) +
                    "   Antal liter bensin: " + df.format(bensinFörbrukning) +
                    "   Förbrukning per mil: " + df.format(förbrukningPerMil) + "</html>");
        } catch (NumberFormatException ex) {
            // Hantera fel vid ogiltig inmatning
            JOptionPane.showMessageDialog(this, "Vänligen fyll i alla fält korrekt!", "Fel", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main-metod för att starta programmet
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bensinräknare().setVisible(true);
            }
        });
    }
}
