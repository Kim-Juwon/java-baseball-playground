package baseball.game;

import baseball.component.Hint;
import baseball.component.Numbers;
import baseball.component.RandomNumbersGenerator;
import baseball.component.FinishingStatus;
import baseball.exception.base.NonCriticalException;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {
    private final RandomNumbersGenerator randomNumbersGenerator = RandomNumbersGenerator.create();
    private final InputView inputView = InputView.create();
    private final ResultView resultView = ResultView.create();
    private boolean playing;
    private Numbers correctNumbers;
    private Numbers inputNumbers;
    private Hint hint;

    public void run() {
        start();

        while (isPlaying()) {
            try {
                initialize();

                // 숫자 입력
                inputView.showInputMessage();
                inputNumbers = inputView.input();

                // 힌트 도출
                hint = correctNumbers.compare(inputNumbers);

                // 힌트를 통해 결과 출력
                resultView.showResultFrom(hint);

                // 성공했다면 재시작할것인지 확인
                showRestartQuestionViewIfSuccessful();
            } catch (Throwable throwable) {
                resultView.showErrorFrom(throwable);
                terminateWhenUnpredictedErrorOccurs(throwable);
            }
        }
    }

    private boolean isPlaying() {
        return playing;
    }

    private void initialize() {
        emptyInputNumbers();
        emptyHint();
    }

    private void start() {
        playing = true;
        generateRandomCorrectNumbers();
    }

    private void terminate() {
        playing = false;
    }

    private void generateRandomCorrectNumbers() {
        correctNumbers = randomNumbersGenerator.generateNumbers();
    }

    private void emptyInputNumbers() {
        inputNumbers = null;
    }

    private void emptyHint() {
        hint = null;
    }

    private boolean isSuccessful() {
        if (hint == null) {
            return false;
        }

        return hint.isThreeStrike();
    }

    private void showRestartQuestionViewIfSuccessful() {
        if (!isSuccessful()) {
            return;
        }

        resultView.showQuestion();
        decideRestartOrTerminateFrom(resultView.input());
    }

    private void decideRestartOrTerminateFrom(FinishingStatus status) {
        if (status.equals(FinishingStatus.RESTART)) {
            generateRandomCorrectNumbers();
            initialize();
        }
        if (status.equals(FinishingStatus.TERMINATE)) {
            terminate();
        }
    }

    private void terminateWhenUnpredictedErrorOccurs(Throwable throwable) {
        if (throwable instanceof NonCriticalException) {
            return;
        }

        terminate();
    }
}
