package menu.domain;

import java.util.StringJoiner;

public enum WeekDay {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    public static String printWeekDay() {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
        stringJoiner.add("구분");
        for (WeekDay value : values()) {
            stringJoiner.add(value.name());
        }
        return stringJoiner.toString();
    }
}
