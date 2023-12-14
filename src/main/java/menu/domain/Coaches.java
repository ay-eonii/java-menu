package menu.domain;

import menu.util.StringUtil;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public String recommend(Lunch lunch) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Coach coach : coaches) {
            List<String> recommend = lunch.getLunch(coach);
            String menu = StringUtil.join(coach.getName(), recommend);
            stringBuilder.append(menu)
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
