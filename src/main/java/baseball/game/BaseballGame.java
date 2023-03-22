package baseball.game;

import baseball.component.Hints;
import baseball.component.Numbers;
import baseball.component.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private static final int RESTART = 1;
    private static final int EXIT = 2;
    private boolean playing;
    private Numbers correctNumber;
    private Numbers inputNumber;
    private Hints hints;

    public void run() {
        setUp();

        while (playing) {
            inputView.showInputView();
            inputNumber = inputView.inputAndReturn();

            hints = correctNumber.compareAndGetHints(inputNumber);

            boolean success = resultView.showResultAndGetSuccessStatus(hints);
            showQuestionWhenSuccessful(success);
        }
    }

    private void setUp() {
        playing = true;
        generateRandomNumber();
    }

    private void exit() {
        playing = false;
    }

    private void generateRandomNumber() {
        correctNumber = randomNumberGenerator.generateNumber();
    }

    private void showQuestionWhenSuccessful(boolean success) {
        if (!success) {
            return;
        }

        resultView.showRestartOrExitView();
        int restartOrExit = resultView.inputAndReturnForRestartOrExit();

        if (restartOrExit == RESTART) {
            setUp();
        }
        if (restartOrExit == EXIT) {
            exit();
        }
    }
}
