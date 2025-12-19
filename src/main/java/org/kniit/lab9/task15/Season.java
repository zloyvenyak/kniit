package org.kniit.lab9.task15;

public enum Season {
    WINTER("Зима", "Холодно", "Новый год"),
    SPRING("Весна", "Тепло", "Пасха"),
    SUMMER("Лето", "Жарко", "День России"),
    AUTUMN("Осень", "Прохладно", "День знаний");

    private final String localizedName;
    private final String temperature;
    private final String holiday;

    Season(String localizedName, String temperature, String holiday) {
        this.localizedName = localizedName;
        this.temperature = temperature;
        this.holiday = holiday;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHoliday() {
        return holiday;
    }
}
