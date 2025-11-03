package sprint2.Uppg10;

public enum CityTimeZone {
    STOCKHOLM("stockholm", "Europe/Stockholm"),
    TORONTO("toronto", "America/Toronto"),
    SHANGHAI("shanghai", "Asia/Shanghai"),
    BUENOS_AIRES("buenos aires", "Argentina/Buenos_Aires"),
    TOKYO("tokyo", "Asia/Tokyo"),
    LONDON("london", "Europe/London"),
    SYDNEY("sydney", "Australia/Sydney"),
    CAPE_TOWN("cape town", "Africa/Johannesburg");

    private final String cityName;
    private final String timeZoneId;

    CityTimeZone(String cityName, String timeZoneId) {
        this.cityName = cityName;
        this.timeZoneId = timeZoneId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public static CityTimeZone fromInput(String input) {
        String cleanedInput = input.trim().toLowerCase().replaceAll("\\s+", " ");
        for (CityTimeZone city : CityTimeZone.values()) {
            if (city.cityName.equals(cleanedInput)) {
                return city;
            }
        }
        return null;
    }
}