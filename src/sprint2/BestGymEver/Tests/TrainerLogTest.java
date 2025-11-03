package sprint2.BestGymEver.Tests;
import sprint2.BestGymEver.Member;
import sprint2.BestGymEver.MembershipType;
import sprint2.BestGymEver.TrainerLog;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;

public class TrainerLogTest {
    public static void main(String[] args) {
        String testFile = "src/sprint2/BestGymEver/Tests/test_pt_log.txt";

        try {
            Files.deleteIfExists(Paths.get(testFile));

            TrainerLog log = new TrainerLog();
            Member testMember = new Member("Kalle Kula", "Gymvägen 10", "kalle@mail.com",
                    "800101-1234", LocalDate.now().minusYears(1),
                    LocalDate.now().minusDays(50), MembershipType.GOLD);

            log.logVisit(testMember);

            if (Files.exists(Paths.get("src/sprint2/BestGymEver/pt_log.txt"))) {
                System.out.println("✅ testLogVisitCreatesFile: OK");
            } else {
                System.out.println("❌ testLogVisitCreatesFile: FAILED");
            }

            List<String> lines = Files.readAllLines(Paths.get("src/sprint2/BestGymEver/pt_log.txt"));
            boolean contains = lines.get(lines.size() - 1).contains("Kalle Kula");
            System.out.println(contains
                    ? "✅ testLogVisitAddsLine: OK"
                    : "❌ testLogVisitAddsLine: FAILED");

        } catch (IOException e) {
            System.out.println("⚠️ Testfel: " + e.getMessage());
        }
    }
}