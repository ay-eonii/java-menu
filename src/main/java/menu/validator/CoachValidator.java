package menu.validator;


import menu.view.constant.ExceptionMessage;

public class CoachValidator {

    public static void validate(String[] inputs) {
        for (String input : inputs) {
            if (!input.matches("^[\\S]{2,4}")) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_COACH_NAME);
            }
        }
        if (inputs.length < Constraints.MIN.size || inputs.length > Constraints.MAX.size) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_COACH_NUMBER);
        }
    }

    private enum Constraints {
        MIN(2),
        MAX(5)
        ;
        private final int size;

        Constraints(int size) {
            this.size = size;
        }
    }
}
