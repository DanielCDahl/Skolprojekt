package sprint2.Uppg11;

import java.time.Duration;
import java.time.LocalTime;

public class TvProgram implements Recordable {
    private final LocalTime start;
    private final LocalTime end;
    private final ProgramType type;

    public TvProgram(LocalTime start, LocalTime end, ProgramType type) {
        if (start == null || end == null || type == null) {
            throw new IllegalArgumentException("Starttid, sluttid och programtyp får inte vara null.");
        }
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("Sluttid måste vara efter starttid.");
        }

        this.start = start;
        this.end = end;
        this.type = type;
    }

    @Override
    public long getDurationInMinutes() {
        return Duration.between(start, end).toMinutes();
    }

    public ProgramType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TvProgram (" + type + ") från " + start + " till " + end +
                " (" + getDurationInMinutes() + " minuter)";
    }
}
