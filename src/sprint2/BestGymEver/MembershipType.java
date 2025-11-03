package sprint2.BestGymEver;

//Enum som beskriver olika typer av medlemskap.
//Ger tydlighet och förhindrar felstavningar i textinmatning.
public enum MembershipType {
    STANDARD("Standard"),
    GOLD("Guld"),
    PLATINUM("Platina");

    private final String displayName;

    MembershipType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    //Omvandlar text från fil till korrekt enum-värde
    public static MembershipType fromString(String type) {
        switch (type.trim().toUpperCase()) {
            case "PLATINA":
                return PLATINUM;
            case "GULD":
                return GOLD;
            default:
                return STANDARD;
        }
    }
}
