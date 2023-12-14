package menu.controller;


import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    public void execute() {
        outputView.printGreetings();
    }
}
