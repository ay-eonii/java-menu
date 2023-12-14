package menu.domain;

import menu.domain.category.Category;
import menu.domain.category.CategoryMaker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lunch {
    private final List<Coach> coaches;
    private final Map<WeekDay, Category> categoryMap;

    public Lunch(List<Coach> coaches) {
        this.coaches = coaches;
        categoryMap = recommend();
    }

    public Map<WeekDay, Category> recommend() {
        return CategoryMaker.run();
    }
}
