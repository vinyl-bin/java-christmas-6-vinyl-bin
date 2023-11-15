package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printIntro();
        inputView.readDate();
        inputView.readMenu();
    }
}
