package menu.util;

import java.util.List;
import java.util.StringJoiner;

public class StringUtil {
    public static String join(String coachName, List<String> recommends) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
        stringJoiner.add(coachName);
        for (String recommend : recommends) {
            stringJoiner.add(recommend);
        }
        return stringJoiner.toString();
    }
}
