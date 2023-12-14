package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {
    private final String name;
    private final List<String> hater;

    public Coach(String name, String[] hater) {
        this.name = name;
        this.hater = converToList(hater);
    }

    private List<String> converToList(String[] hater) {
        return Arrays.stream(hater).collect(Collectors.toList());
    }

    public boolean hate(String menu) {
        return hater.contains(menu);
    }

    public String getName() {
        return name;
    }
}
