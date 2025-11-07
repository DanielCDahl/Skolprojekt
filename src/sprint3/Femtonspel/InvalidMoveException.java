package sprint3.Femtonspel;
//En egen undantagsklass för ogiltiga drag, separerar felhantering från spel-logiken
public class InvalidMoveException extends Exception {
    public InvalidMoveException(String message) {
        super(message);
    }
}
