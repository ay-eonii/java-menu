package menu.domain.category;

import menu.domain.WeekDay;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CategoryMaker {
    private static final int DUPLICATION_LIMIT = 2;
    private final CategoryRandomGenerator categoryRandomGenerator;

    public CategoryMaker(CategoryRandomGenerator categoryRandomGenerator) {
        this.categoryRandomGenerator = categoryRandomGenerator;
    }

    public Map<WeekDay, Category> run() {
        return recommendCategory();
    }

    private Map<WeekDay, Category> recommendCategory() {
        Map<WeekDay, Category> recommend = new LinkedHashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        WeekDay[] weekDays = WeekDay.values();
        for (WeekDay weekDay : weekDays) {
            int order = getOrder(count);
            Category category = Category.match(order);
            recommend.put(weekDay, category);
        }
        return recommend;
    }

    private int getOrder(Map<Integer, Integer> count) {
        int order = categoryRandomGenerator.run();
        Integer duplication = count.getOrDefault(order, 0);
        if (duplication >= DUPLICATION_LIMIT) {
            return getOrder(count);
        }
        count.put(order, duplication + 1);
        return order;
    }
}
