package sprint2.Uppg11;

public class VideoBandCalculator {

    public static boolean canRecord(VideoBand band, Recordable item) {
        return item.getDurationInMinutes() <= band.getRemainingMinutes();
    }

    // Överlagrad metod om du vill behålla kompatibilitet med tester utan objekt
    public static boolean canRecord(int totalMinutes, int usedMinutes,
                                    java.time.LocalTime start, java.time.LocalTime end) {
        VideoBand band = new VideoBand(totalMinutes, usedMinutes);
        TvProgram program = new TvProgram(start, end, ProgramType.OTHER);
        return canRecord(band, program);
    }
}
