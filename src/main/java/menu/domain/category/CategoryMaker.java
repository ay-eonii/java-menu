package menu.domain.category;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.WeekDay;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CategoryMaker {
    public static Map<WeekDay, Category> run() {
        return recommendCategory();
    }

    private static Map<WeekDay, Category> recommendCategory() {
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

    private static int getOrder(Map<Integer, Integer> count) {
        int order = Randoms.pickNumberInRange(1, 5);
        Integer duplication = count.getOrDefault(order, 0);
        if (duplication >= 2) {
            return getOrder(count);
        }
        count.put(order, duplication + 1);
        return order;
    }
}
