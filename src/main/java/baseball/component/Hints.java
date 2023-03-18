package baseball.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hints {
    private List<Hint> hintList;
    public static final int SIZE_OF_FULL_STRIKE = 3;

    private Hints(List<Hint> hintList) {
        this.hintList = hintList;
    }

    public static Hints from(List<Hint> hintList) {
        if (hintList == null) {
            return new Hints(new ArrayList<>());
        }

        return new Hints(hintList);
    }

    public boolean hasOnlyStrike() {
        if (hintList.size() != 1) {
            return false;
        }

        Hint hint = hintList.get(0);
        Status status = hint.getStatus();

        return status.equals(Status.STRIKE);
    }

    public boolean isSizeOfStrikeEqualToFullStrike() {
        for (Hint hint : hintList) {
            Status status = hint.getStatus();
            int count = hint.getCount();
            if (status.equals(Status.STRIKE) && count == SIZE_OF_FULL_STRIKE) {
                return true;
            }
        }

        return false;
    }

    public boolean isNothing() {
        return hintList.isEmpty();
    }

    public List<Hint> getHintList() {
        return Collections.unmodifiableList(hintList);
    }
}
