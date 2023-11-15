package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.InputViewController;
import christmas.domain.DateInfo;

public class InputView {

    private final InputViewController inputViewController = new InputViewController();
    public DateInfo readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)");
        String input = Console.readLine();
        DateInfo dateInfo = inputViewController.connectDateInfo(input);
        return dateInfo;
    }
}
