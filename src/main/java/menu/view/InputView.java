package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validator.CoachValidator;

public class InputView {
    private static final String COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public String[] readCoach() {
        System.out.println(System.lineSeparator() + COACH);
        return getCoach();
    }

    private String[] getCoach() {
        try {
            String[] names = readWithoutSpace().split(",");
            CoachValidator.validate(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoach();
        }
    }

    private String readWithoutSpace() {
        return Console.readLine().replaceAll("\\s+", "");
    }
}
