package christmas;

import christmas.domain.DateInfo;
import christmas.domain.MenuCount;
import christmas.domain.SaleInfo;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printIntro();
        DateInfo dateInfo = inputView.readDate();
        MenuCount menuCount = inputView.readMenu();
        SaleInfo saleInfo = new SaleInfo(dateInfo, menuCount);
        outputView.printBenefit(dateInfo);
        outputView.printMenu(menuCount);
        outputView.printMenuPrice(saleInfo);
        outputView.printPresentMenu(saleInfo);
        outputView.printBenefitListIntro(saleInfo);
        int benefitPrice = outputView.printBenefitPrice(saleInfo);
        outputView.printAfterPrice(saleInfo);
        outputView.printBadge(benefitPrice);
    }
}
