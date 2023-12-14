package menu.controller;


import menu.domain.Coach;
import menu.domain.Lunch;
import menu.domain.WeekDay;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void execute() {
        outputView.printGreetings();
        String[] coachNames = inputView.readCoachNames();

        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(inputView.readDoNotEatMenu(coachName));
        }
        Lunch lunch = new Lunch(coaches);
        outputView.printResult(WeekDay.printWeekDay(), lunch.getWeekdayCategory());
        for (Coach coach : coaches) {
            List<String> recommend = lunch.getLunch(coach);
            outputView.printRecommend(coach.getName(), recommend);
        }
    }
}
