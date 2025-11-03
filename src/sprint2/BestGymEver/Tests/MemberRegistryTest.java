package sprint2.BestGymEver.Tests;
import sprint2.BestGymEver.Member;
import sprint2.BestGymEver.MemberNotFoundException;
import sprint2.BestGymEver.MemberRegistry;

import java.io.FileWriter;
import java.io.IOException;

public class MemberRegistryTest {
    public static void main(String[] args) {
        try {
            String testFile = "src/sprint2/BestGymEver/Tests/test_members.txt";
            createTestFile(testFile);

            MemberRegistry registry = new MemberRegistry();
            registry.loadMembers(testFile);

            if (registry.getMembers().size() == 2) {
                System.out.println("✅ testLoadMembers: OK");
            } else {
                System.out.println("❌ testLoadMembers: FAILED");
            }

            try {
                Member found = registry.findMember("Anna Andersson");
                if (found.getName().equals("Anna Andersson")) {
                    System.out.println("✅ testFindMember: OK");
                } else {
                    System.out.println("❌ testFindMember: FAILED");
                }
            } catch (MemberNotFoundException e) {
                System.out.println("❌ testFindMember: FAILED – kastade undantag");
            }

            try {
                registry.findMember("Ingen Namn");
                System.out.println("❌ testFindMemberThrowsException: FAILED");
            } catch (MemberNotFoundException e) {
                System.out.println("✅ testFindMemberThrowsException: OK");
            }

        } catch (IOException e) {
            System.out.println("⚠️ Kunde inte skapa testfil: " + e.getMessage());
        }
    }

    private static void createTestFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Namn;Adress;Email;Personnummer;Start;Senast;Typ\n");
            writer.write("Anna Andersson;Storgatan 1;anna@mail.com;900101-1234;2020-01-01;2025-01-01;Guld\n");
            writer.write("Bertil Berg;Parkvägen 3;bert@mail.com;850101-5678;2019-01-01;2020-01-01;Standard\n");
        }
    }
}
