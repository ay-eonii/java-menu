package menu.domain.category;

import camp.nextstep.edu.missionutils.Randoms;

public class CategoryRandomGenerator implements CategoryGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 5;

    @Override
    public int run() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }
}
