package sprint2.Uppg11;

public class VideoBand {
    private final int totalMinutes;
    private final int usedMinutes;

    public VideoBand(int totalMinutes, int usedMinutes) {
        if (totalMinutes < 0 || usedMinutes < 0 || usedMinutes > totalMinutes) {
            throw new IllegalArgumentException("Ogiltiga värden för bandlängd eller använd tid.");
        }

        this.totalMinutes = totalMinutes;
        this.usedMinutes = usedMinutes;
    }

    public int getRemainingMinutes() {
        return totalMinutes - usedMinutes;
    }

    @Override
    public String toString() {
        return "Videoband: " + totalMinutes + " min, Använt: " + usedMinutes +
                " min, Kvar: " + getRemainingMinutes() + " min";
    }
}
