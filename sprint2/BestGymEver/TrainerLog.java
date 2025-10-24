package sprint2.BestGymEver;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//Denna klass ansvarar för att logga när en betalande kund besöker gymmet.
//Den skriver till en separat textfil som PT:n kan använda.
public class TrainerLog {

    private static final String LOG_FILE = "src/sprint2/BestGymEver/pt_log.txt";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //Loggar en träning i filen med datum, namn och personnummer.
    public void logVisit(Member member) {
        try {
            Path logPath = Paths.get(LOG_FILE);

            if (!Files.exists(logPath)) {
                Files.createFile(logPath);
            }

            long visitCount = 0;
            if (Files.size(logPath) > 0) {
                List<String> allLines = Files.readAllLines(logPath);
                visitCount = allLines.stream()
                        .filter(line -> line.contains(member.getPersonalNumber()))
                        .count();
            }

            String logEntry = String.format("%s;%s;%s",
                    member.getName(),
                    member.getPersonalNumber(),
                    LocalDate.now().format(DATE_FORMAT));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                writer.write(logEntry);
                writer.newLine();
            }

            System.out.println("🏋️ Träningsbesök loggat för " + member.getName() +
                    ". Totalt antal besök: " + (visitCount + 1));

        } catch (IOException e) {
            System.out.println("⚠️ Fel vid loggning: " + e.getMessage());
        }
    }
}
