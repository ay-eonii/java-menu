package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.category.Category;
import menu.validator.CategoryValidator;
import menu.validator.CoachValidator;

public class InputView {
    private static final String COACH = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String CANNOT_EAT_MENU_ITEM = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String[] readCoachNames() {
        System.out.println(System.lineSeparator() + COACH);
        return getCoachNames();
    }

    private String[] getCoachNames() {
        try {
            String[] names = readWithoutSpace().split(",");
            CoachValidator.validate(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoachNames();
        }
    }

    public Coach readDoNotEatMenu(String coach) {
        String message = String.format(CANNOT_EAT_MENU_ITEM, coach);
        System.out.println(System.lineSeparator() + message);
        return getCoach(coach);
    }

    private Coach getCoach(String coach) {
        try {
            String[] inputs = readWithoutSpace().split(",");
            CategoryValidator.validate(inputs);
            for (String input : inputs) {
                Category.match(input);
            }
            return new Coach(coach, inputs);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoach(coach);
        }
    }



    private String readWithoutSpace() {
        return Console.readLine().replaceAll("\\s+", "");
    }
}
