package sprint2.BestGymEver;

import java.util.Scanner;

public class GymApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrainerLog trainerLog = new TrainerLog();
        MemberRegistry registry = new MemberRegistry();
        registry.loadMembers("src/sprint2/BestGymEver/gym_medlemmar.txt");

        System.out.println("\n🏋️‍♀️ Välkommen till Best Gym Ever 🏋️‍♂️");
        System.out.println("Skriv in namn eller personnummer för att kontrollera medlemsstatus.");
        System.out.println("Skriv 'exit' för att avsluta.\n");

        while (true) {
            System.out.print("Ange namn/personnummer: ");
            String input = scanner.nextLine().trim();

            if (input.isBlank()) {
                System.out.println("⚠️ Du måste skriva in ett namn eller personnummer.\n");
                continue;
            }

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Programmet avslutas. Tack för besöket!");
                break;
            }

            //Försöker hitta medlemmen
            try {
                Member found = registry.findMember(input);

                long daysSincePayment = found.getDaysSinceLastPayment();
                System.out.println("--------------------------------------------");
                System.out.println("Namn: " + found.getName());
                System.out.println("Personnummer: " + found.getPersonalNumber());
                System.out.println("Senaste betalning: " + found.getLastPaymentDate() + " (" + daysSincePayment + " dagar sedan)");
                System.out.println("Typ av medlemskap: " + found.getMembershipType().getDisplayName());

                if (found.isActive()) {
                    System.out.println("✅ Status: Aktiv medlem – får träna.");
                    trainerLog.logVisit(found);
                } else {
                    System.out.println("ℹ️ Status: Före detta medlem – årsavgiften har gått ut.");
                }
                System.out.println("--------------------------------------------\n");

            } catch (MemberNotFoundException e) {
                System.out.println("❌ Personen finns inte i filen och har aldrig varit medlem – personen är obehörig.\n");
            }
        }
    }
}