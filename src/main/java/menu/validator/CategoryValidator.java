package menu.validator;


import menu.view.constant.ExceptionMessage;

public class CategoryValidator {

    public static void validate(String[] inputs) {
        if (inputs.length > Constraints.MAX.size) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_HATE_NUMBER);
        }
    }

    private enum Constraints {
        MAX(2);
        private final int size;

        Constraints(int size) {
            this.size = size;
        }
    }
}
