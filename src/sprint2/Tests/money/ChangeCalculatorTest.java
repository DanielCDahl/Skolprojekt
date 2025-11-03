package sprint2.Tests.money;

import sprint2.Uppg6.ChangeCalculator;

public class ChangeCalculatorTest {

    public static void main(String[] args) {
        testVäxelMedVäxelFrån1000krTill654kr();
        testIngenVäxel();
        testVäxelFörLågtBelopp();
        testFormatteringAvVäxel();
        testInputOgiltig();
    }

    // Test 1: Växel från 1000 kr till 654 kr
    public static void testVäxelMedVäxelFrån1000krTill654kr() {
        double pris = 654;
        double betaltBelopp = 1000;

        System.out.println("\nTest 1: Växel från 1000 kr till 654 kr");
        ChangeCalculator.calculateChange(pris, betaltBelopp);
    }

    // Test 2: Ingen växel om vi betalar exakt
    public static void testIngenVäxel() {
        double pris = 654;
        double betaltBelopp = 654;

        System.out.println("\nTest 2: Ingen växel om vi betalar exakt");
        ChangeCalculator.calculateChange(pris, betaltBelopp);
    }

    // Test 3: För lågt belopp (vi betalar mindre än varan kostar)
    public static void testVäxelFörLågtBelopp() {
        try {
            double pris = 654;
            double betaltBelopp = 500;

            System.out.println("\nTest 3: Växel för lågt belopp (felhantering)");
            ChangeCalculator.calculateChange(pris, betaltBelopp);
        } catch (IllegalArgumentException e) {
            System.out.println("Du lämnade för lite pengar");
        }
    }

    // Test 4: Formatterad utskrift
    public static void testFormatteringAvVäxel() {
        double pris = 654;
        double betaltBelopp = 1000;

        System.out.println("\nTest 4: Formatterad utskrift för växel");
        ChangeCalculator.calculateChange(pris, betaltBelopp);
    }

    // Test 5: Testa ogiltig inläsning
    public static void testInputOgiltig() {
        ChangeCalculator.isTestMode = true; // Sätt testläge till true för att simulera inläsning

        try {
            // Vi simulerar att användaren skriver in ett ogiltigt värde
            double[] inputValues = ChangeCalculator.readInput(); // Kommer att slänga ett exception om ogiltig inmatning
        } catch (IllegalArgumentException e) {
            System.out.println("Test 5: Ogiltig inmatning fångad: " + e.getMessage());
        }
    }
}