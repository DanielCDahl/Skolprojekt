package sprint2.BestGymEver;

import java.time.LocalDate;
import java.time.Period;

//Representerar en medlem i gymmet.
public class Member {

    private String name;
    private String address;
    private String email;
    private String personalNumber;
    private LocalDate membershipStartDate;
    private LocalDate lastPaymentDate;
    private MembershipType membershipType;

    //Konstruktor som används när en medlem läses in från fil
    public Member(String name, String address, String email,
                  String personalNumber, LocalDate membershipStartDate,
                  LocalDate lastPaymentDate, MembershipType membershipType) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.personalNumber = personalNumber;
        this.membershipStartDate = membershipStartDate;
        this.lastPaymentDate = lastPaymentDate;
        this.membershipType = membershipType;
    }

    //Returnerar true om personen betalat sin årsavgift under de senaste 365 dagarna
    public boolean isActive() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(lastPaymentDate, today);
        return period.getYears() < 1;
    }

    //Beräknar hur många dagar det gått sedan senaste betalningen
    public long getDaysSinceLastPayment() {
        return java.time.temporal.ChronoUnit.DAYS.between(lastPaymentDate, LocalDate.now());
    }

    //Getters (inkapsling)
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPersonalNumber() {
        return personalNumber;
    }
    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }
    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }
    public MembershipType getMembershipType() {
        return membershipType;
    }

    @Override
    public String toString() {
        return name + " (" + personalNumber + ") - " + membershipType +
                " | Senaste betalning: " + lastPaymentDate;
    }
}