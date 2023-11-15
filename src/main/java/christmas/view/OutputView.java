package christmas.view;

import christmas.controller.OutputViewController;
import christmas.domain.DateInfo;
import christmas.domain.MenuCount;
import christmas.domain.SaleInfo;

public class OutputView {

    private final OutputViewController outputViewController = new OutputViewController();

    public void printIntro() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printResult(DateInfo dateInfo, MenuCount menuCount, SaleInfo saleInfo) {
        printBenefitMessage(dateInfo);
        printMenu(menuCount);
        printMenuPrice(saleInfo);
        printPresentMenu(saleInfo);
        printBenefitList(saleInfo);
        int benefitPrice = printBenefitPrice(saleInfo);
        printAfterPrice(saleInfo);
        printBadge(benefitPrice);
    }

    private void printBenefitMessage(DateInfo dateInfo) {
        System.out.println(outputViewController.benefitMessage(dateInfo));
    }

    private void printMenu(MenuCount menuCount) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        outputViewController.menus(menuCount);
    }

    private void printMenuPrice(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(outputViewController.menuPrice(saleInfo));
    }

    private void printPresentMenu(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        outputViewController.presentMenu(saleInfo);
    }

    private void printBenefitList(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<혜택 내역>");
        outputViewController.benefitList(saleInfo);
    }

    private int printBenefitPrice(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        return outputViewController.benefitPrice(saleInfo);
    }

    private void printAfterPrice(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(outputViewController.afterPrice(saleInfo));
    }

    private void printBadge(int benefitPrice) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        outputViewController.badge(benefitPrice);
    }
 }
