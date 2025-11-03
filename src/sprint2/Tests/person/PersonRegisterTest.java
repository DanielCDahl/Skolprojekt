package sprint2.Tests.person;

import sprint2.Uppg9.PersonRegister;
import sprint2.Uppg9.Person;
import java.io.IOException;
import java.util.List;

public class PersonRegisterTest {

    public static void main(String[] args) {
        PersonRegisterTest test = new PersonRegisterTest();
        test.testLangaPersoner();
        test.testFelaktigFil();
    }

    public void testLangaPersoner() {
        System.out.println("Test: testLangaPersoner");

        PersonRegister register = new PersonRegister();

        try {
            register.lasInFranFil("src/sprint2/Uppg9/Personuppgifter.txt"); // ändra sökväg om nödvändigt
            List<Person> langa = register.getLangaPersoner(200);

            if (langa.isEmpty()) {
                System.out.println("❌ Test misslyckades: inga långa personer hittades");
            } else {
                boolean allaLanga = true;
                for (Person p : langa) {
                    if (p.getLangd() <= 200) {
                        allaLanga = false;
                        break;
                    }
                }

                if (allaLanga) {
                    System.out.println("✅ Test lyckades: alla personer var längre än 200 cm");
                } else {
                    System.out.println("❌ Test misslyckades: någon person var inte längre än 200 cm");
                }
            }

        } catch (IOException e) {
            System.out.println("❌ Test misslyckades: kunde inte läsa testfilen");
            e.printStackTrace();
        }
    }

    public void testFelaktigFil() {
        System.out.println("Test: testFelaktigFil");

        PersonRegister register = new PersonRegister();

        try {
            register.lasInFranFil("fil_som_inte_finns.txt");
            System.out.println("❌ Test misslyckades: filen borde inte existera men lästes utan fel");
        } catch (IOException e) {
            System.out.println("✅ Test lyckades: IOException kastades som förväntat");
        }
    }
}