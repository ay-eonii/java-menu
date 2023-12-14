package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.category.Category;
import menu.domain.category.CategoryMaker;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Lunch {
    private final Map<WeekDay, Category> categoryMap;

    public Lunch() {
        categoryMap = recommendCategory();
    }

    public Map<WeekDay, Category> recommendCategory() {
        return CategoryMaker.run();
    }

    public List<String> getLunch(Coach coach) {
        List<String> lunch = new LinkedList<>();
        for (WeekDay weekDay : categoryMap.keySet()) {
            Category category = categoryMap.get(weekDay);
            String menu = recommendMenu(coach, category, lunch);
            lunch.add(menu);
        }
        return lunch;
    }

    private String recommendMenu(Coach coach, Category category, List<String> lunch) {
        String menu = Randoms.shuffle(category.getMenus()).get(0);
        long uniqueCount = lunch.stream()
                .distinct()
                .count();
        if (coach.hate(menu) || uniqueCount != lunch.size()) {
            return recommendMenu(coach, category, lunch);
        }
        return menu;
    }

    public String getWeekdayCategory() {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
        stringJoiner.add("카테고리");
        for (WeekDay weekDay : categoryMap.keySet()) {
            Category category = categoryMap.get(weekDay);
            stringJoiner.add(category.getKorean());
        }
        return stringJoiner.toString();
    }
}
