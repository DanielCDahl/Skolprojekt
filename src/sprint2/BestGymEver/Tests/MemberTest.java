package sprint2.BestGymEver.Tests;
import sprint2.BestGymEver.Member;
import sprint2.BestGymEver.MembershipType;

import java.time.LocalDate;

public class MemberTest {
    public static void main(String[] args) {
        testIsActiveTrue();
        testIsActiveFalse();
        testGetDaysSinceLastPayment();
    }

    private static void testIsActiveTrue() {
        Member member = new Member("Test", "Testvägen 1", "test@mail.com",
                "123456-7890", LocalDate.now().minusYears(2),
                LocalDate.now().minusDays(200), MembershipType.GOLD);
        if (member.isActive()) {
            System.out.println("✅ testIsActiveTrue: OK");
        } else {
            System.out.println("❌ testIsActiveTrue: FAILED");
        }
    }

    private static void testIsActiveFalse() {
        Member member = new Member("Test", "Testvägen 1", "test@mail.com",
                "123456-7890", LocalDate.now().minusYears(2),
                LocalDate.now().minusDays(400), MembershipType.STANDARD);
        if (!member.isActive()) {
            System.out.println("✅ testIsActiveFalse: OK");
        } else {
            System.out.println("❌ testIsActiveFalse: FAILED");
        }
    }

    private static void testGetDaysSinceLastPayment() {
        Member member = new Member("Test", "Testvägen 1", "test@mail.com",
                "123456-7890", LocalDate.now().minusYears(2),
                LocalDate.now().minusDays(100), MembershipType.PLATINUM);
        if (member.getDaysSinceLastPayment() == 100) {
            System.out.println("✅ testGetDaysSinceLastPayment: OK");
        } else {
            System.out.println("❌ testGetDaysSinceLastPayment: FAILED");
        }
    }
}
