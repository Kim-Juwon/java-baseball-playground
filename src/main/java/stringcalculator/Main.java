package stringcalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator();

        while (true) {
            System.out.print("계산하려는 문자열을 입력하세요 (종료하려면 exit 입력): ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            System.out.println(stringCalculator.calculate(input));
        }
    }
}
