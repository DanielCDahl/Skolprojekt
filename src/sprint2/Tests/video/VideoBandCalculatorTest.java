package sprint2.Tests.video;
import sprint2.Uppg11.ProgramType;
import sprint2.Uppg11.TvProgram;
import sprint2.Uppg11.VideoBandCalculator;
import sprint2.Uppg11.VideoBand;

import java.time.LocalTime;

public class VideoBandCalculatorTest {
    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;

        // Testfall 1: ...
        try {
            // ...
        } catch (Exception e) {
            // ...
        }

        // ...

        // Testfall 5: Objektbaserad
        try {
            VideoBand band = new VideoBand(120, 30);
            TvProgram program = new TvProgram(LocalTime.of(20, 0), LocalTime.of(21, 0), ProgramType.OTHER);
            boolean result = VideoBandCalculator.canRecord(band, program);
            assertTrue(result, "Test 5: Objektbaserad - Bandet har plats");
            passed++;
        } catch (Exception e) {
            failed++;
            System.out.println("Test 5 FEL: " + e.getMessage());
        }

        System.out.println("\nTester klara: " + passed + " lyckades, " + failed + " misslyckades.");
    }

    private static void assertTrue(boolean condition, String message) {
        if (condition) {
            System.out.println("OK: " + message);
        } else {
            System.out.println("FEL: " + message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (!condition) {
            System.out.println("OK: " + message);
        } else {
            System.out.println("FEL: " + message);
        }
    }
}
