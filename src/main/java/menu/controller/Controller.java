package menu.controller;


import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Lunch;
import menu.domain.WeekDay;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Lunch lunch = new Lunch();

    public void execute() {
        outputView.printGreetings();
        String[] coachNames = inputView.readCoachNames();

        Coaches coaches = getCoaches(coachNames);
        outputView.printResult(WeekDay.printWeekDay(), lunch.getWeekdayCategory());

        String recommend = coaches.recommend(lunch);
        outputView.printRecommend(recommend);
        outputView.printEnd();
    }

    private Coaches getCoaches(String[] coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String coachName : coachNames) {
            coaches.add(inputView.readDoNotEatMenu(coachName));
        }
        return new Coaches(coaches);
    }
}
