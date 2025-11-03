package sprint2.BestGymEver;

//Egen exception som används när en sökning inte hittar en medlem.
//Gör koden tydligare och mer specifik än att bara kasta "Exception".

public class MemberNotFoundException extends Exception {

    public MemberNotFoundException(String message) {
        super(message);
    }
}
