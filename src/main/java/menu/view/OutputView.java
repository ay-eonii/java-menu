package menu.view;

public class OutputView {
    private static final String GREETINGS = "점심 메뉴 추천을 시작합니다.";
    private static final String RESULT = "메뉴 추천 결과입니다.";
    private static final String END = "추천을 완료했습니다.";


    public void printGreetings() {
        System.out.println(GREETINGS);
    }

    public void printResult(String weekday, String category) {
        System.out.println(System.lineSeparator());
        System.out.println(RESULT);
        System.out.println(weekday);
        System.out.println(category);
    }

    public void printRecommend(String recommend) {
        System.out.println(recommend);
    }

    public void printEnd() {
        System.out.println(END);
    }
}
