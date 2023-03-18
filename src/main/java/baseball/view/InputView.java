package baseball.view;

import baseball.component.Number;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public void showInputView() {
        System.out.print(INPUT_MESSAGE);
    }

    public Number inputAndReturn() {
        return Number.from(scanner.nextLine());
    }
}
