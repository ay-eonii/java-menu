package menu.domain;

import java.util.StringJoiner;

public enum WeekDay {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String korean;

    WeekDay(String korean) {
        this.korean = korean;
    }

    public static String printWeekDay() {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
        stringJoiner.add("구분");
        for (WeekDay value : values()) {
            stringJoiner.add(value.korean);
        }
        return stringJoiner.toString();
    }
}
