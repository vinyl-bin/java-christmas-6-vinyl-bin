package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.InputViewController;
import christmas.domain.DateInfo;
import christmas.domain.MenuCount;

public class InputView {

    private final InputViewController inputViewController = new InputViewController();
    public DateInfo readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해주세요!)");
        String input = Console.readLine();
        DateInfo dateInfo = inputViewController.connectDateInfo(input);
        return dateInfo;
    }

    public MenuCount readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        MenuCount menuCount = null;
        boolean keep = true;
        while(keep) {
            try {
                String input = Console.readLine();
                menuCount = inputViewController.connectMenuCount(input);
                keep = false;
            } catch (Exception e){
                keep=true;
            }
        }
        return menuCount;
    }
}
