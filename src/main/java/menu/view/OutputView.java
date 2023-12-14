package menu.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String GREETINGS = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT = "메뉴 추천 결과입니다.";

    public void printGreetings() {
        System.out.println(GREETINGS);
    }

    public void printResult(String weekday, String category) {
        System.out.println(System.lineSeparator());
        System.out.println(RESULT);
        System.out.println(weekday);
        System.out.println(category);
    }

    public void printRecommend(String coachName, List<String> recommends) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
        stringJoiner.add(coachName);
        for (String recommend : recommends) {
            stringJoiner.add(recommend);
        }
        System.out.println(stringJoiner);
    }
}
