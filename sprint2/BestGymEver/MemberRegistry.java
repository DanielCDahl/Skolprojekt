package sprint2.BestGymEver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

//Ansvarar för inläsning, lagring och sökning av medlemmar.
//Innehåller en lista över alla medlemmar som laddas från textfilen.
public class MemberRegistry {

    private final List<Member> members = new ArrayList<>();

    public List<Member> getMembers() {
        return members;
    }

     //Läser in alla medlemmar från textfilen.
     //Try-with-resources används för att garantera att filen stängs korrekt.
    public void loadMembers(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // hoppa över header-raden
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 7) {
                    Member member = createMemberFromData(data);
                    members.add(member);
                }
            }
        } catch (IOException e) {
            System.out.println("Fel vid inläsning av filen: " + e.getMessage());
        }
    }

    private Member createMemberFromData(String[] data) {
        String name = data[0].trim();
        String address = data[1].trim();
        String email = data[2].trim();
        String personalNumber = data[3].trim();
        LocalDate startDate = LocalDate.parse(data[4].trim());
        LocalDate lastPaymentDate = LocalDate.parse(data[5].trim());

        String typeString = data[6].trim().toUpperCase();
        MembershipType type;
        switch (typeString) {
            case "PLATINA" -> type = MembershipType.PLATINUM;
            case "GULD" -> type = MembershipType.GOLD;
            default -> type = MembershipType.STANDARD;
        }

        return new Member(name, address, email, personalNumber, startDate, lastPaymentDate, type);
    }

    //Söker efter en medlem baserat på namn eller personnummer.
    //Om ingen hittas kastas en egen exception (MemberNotFoundException).
    public Member findMember(String input) throws MemberNotFoundException {
        for (Member m : members) {
            if (m.getName().equalsIgnoreCase(input) ||
                    m.getPersonalNumber().equalsIgnoreCase(input)) {
                return m;
            }
        }
        throw new MemberNotFoundException("Ingen medlem hittades med: " + input);
    }
}
