package sprint3.Uppg1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Bildvisare extends JFrame implements ActionListener {
    private JLabel bildLabel;  // JLabel för att visa bilder
    private JButton knappVäxla; // JButton för att växla bild
    private int aktuellBildIndex = 0; // Håller koll på vilken bild som visas
    private List<Path> bilder; // Lista för att hålla bilderna

    // Konstruktor för att bygga GUI:t
    public Bildvisare() {
        // Ladda bilderna från mappen (med hjälp av NIO)
        bilder = laddaBilderFrånMapp(System.getProperty("user.home") + "/Desktop/Java Bilder");

        // Kontrollera om vi har bilder i mappen
        if (bilder.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingen bild hittades på angiven plats.");
            System.exit(0);
        }

        // Sätt upp layout
        setLayout(new FlowLayout());

        // Skapa en JLabel och sätt den första bilden
        bildLabel = new JLabel();
        uppdateraBild();

        // Skapa en knapp för att växla bild
        knappVäxla = new JButton("Växla bild");
        knappVäxla.addActionListener(this); // Lägg till ActionListener här

        // Lägg till komponenter i fönstret
        add(bildLabel);
        add(knappVäxla);

        // Grundinställningar för fönstret
        setTitle("Bildvisare");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrerar fönstret
    }

    // Metod för att uppdatera bilden i JLabel
    private void uppdateraBild() {
        ImageIcon bildIcon = new ImageIcon(bilder.get(aktuellBildIndex).toString());
        Image bild = bildIcon.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH); // Skala bilden
        bildLabel.setIcon(new ImageIcon(bild));
    }

    // Implementera actionPerformed-metoden från ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        // Om knappen trycks, gå till nästa bild
        if (e.getSource() == knappVäxla) {
            aktuellBildIndex = (aktuellBildIndex + 1) % bilder.size();
            uppdateraBild();
        }
    }

    // Metod för att ladda bilder från mappen (med DirectoryStream)
    private List<Path> laddaBilderFrånMapp(String mappSokvag) {
        List<Path> bilderList = new ArrayList<>();
        Path mappPath = Paths.get(mappSokvag);

        // Kontrollera om mappen finns
        if (!Files.exists(mappPath) || !Files.isDirectory(mappPath)) {
            System.err.println("Mappen finns inte eller är inte en katalog.");
            return bilderList;
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(mappPath, "*.{jpg,png}")) {
            // Loopar igenom alla bilder i mappen
            for (Path path : stream) {
                bilderList.add(path);
            }
        } catch (IOException e) {
            System.err.println("Fel vid läsning av mappen: " + e.getMessage());
        }

        return bilderList;
    }

    // Main-metod för att starta programmet
    public static void main(String[] args) {
        // Starta GUI:t på en separat tråd
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Bildvisare().setVisible(true);
            }
        });
    }
}
