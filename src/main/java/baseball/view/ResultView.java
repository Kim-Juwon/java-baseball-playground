package baseball.view;

import baseball.component.Hint;
import baseball.component.Hints;
import baseball.component.Status;

import java.util.Scanner;

public class ResultView {
    private static final String MESSAGE_FOR_SUCCESS = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String MESSAGE_FOR_QUESTION_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Scanner scanner = new Scanner(System.in);

    public boolean showResultAndGetSuccessStatus(Hints hints) {
        if (isSuccess(hints)) {
            showSuccessView();
            return true;
        }

        showHintsView(hints);
        return false;
    }

    private boolean isSuccess(Hints hints) {
        return hints.hasOnlyStrike() && hints.isSizeOfStrikeEqualToFullStrike();
    }

    private void showSuccessView() {
        System.out.printf(MESSAGE_FOR_SUCCESS, Hints.SIZE_OF_FULL_STRIKE);
    }

    public void showRestartOrExitView() {
        System.out.println(MESSAGE_FOR_QUESTION_RESTART);
    }

    public int inputAndReturnForRestartOrExit() {
        return scanner.nextInt();
    }

    private void showHintsView(Hints hints) {
        if (hints.isNothing()) {
            System.out.println(Status.NOTHING.getMeaning());
            return;
        }

        System.out.println(makeStringOfHints(hints));
    }

    private String makeStringOfHint(Hint hint) {
        return String.format("%d%s", hint.getCount(), hint.getStatus().getMeaning());
    }

    private String makeStringOfHints(Hints hints) {
        StringBuilder stringBuilder = new StringBuilder();

        hints.getHintList().forEach(hint -> {
            stringBuilder.append(makeStringOfHint(hint)).append(" ");
        });

        return stringBuilder.toString();
    }
}
