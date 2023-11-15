package christmas.view;

import christmas.domain.DateInfo;
import christmas.domain.DateVoca;
import christmas.domain.MenuCount;
import christmas.domain.SaleInfo;

import java.util.List;

public class OutputView {

    public void printIntro() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printBenefit(DateInfo dateInfo) {
        System.out.println(String.format("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", dateInfo.getDate()));
    }

    public void printMenu(MenuCount menuCount) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (int i = 0; i < menuCount.getMenus().size(); i++) {
            System.out.print(menuCount.getMenus());
            System.out.println(String.format(" %d개", menuCount.getCounts()));
        }
    }

    public void printMenuPrice(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format(" %d개", saleInfo.getBeforePrice()));
    }

    public void printPresentMenu(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        List<Integer> saleList = saleInfo.getSaleList();
        if (saleList.get(DateVoca.PRESENT_SALE_INDEX.value) == DateVoca.NONE_VALUE.value) {
            System.out.println("없음");
        }
        if (saleList.get(DateVoca.PRESENT_SALE_INDEX.value) == DateVoca.PRESENT_SALE_PRICE.value) {
            System.out.println("샴페인 1개");
        }
    }

    public void printBenefitListIntro(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<혜택 내역>");
        if (saleInfo.getSaleList().size() == DateVoca.SALE_LIST_EMPTY_SIZE.value) {
            System.out.println("없음");
        }
        if (saleInfo.getSaleList().size() != DateVoca.SALE_LIST_EMPTY_SIZE.value) {
            printBenefitList(saleInfo);
        }
    }

    private void printBenefitList(SaleInfo saleInfo) {
        int checkEmpty = 0;
        for (int i = 0; i < saleInfo.getSaleList().size(); i++) {
            if (saleInfo.getSaleList().get(i) == DateVoca.NONE_VALUE.value) {
                checkEmpty += 1;
                continue;
            }
            if (saleInfo.getSaleList().get(i) == 0) {
                checkEmpty += 1;
                continue;
            }
            if (checkEmpty == saleInfo.getSaleList().size()) {
                System.out.println("없음");
            }
            System.out.println(String.format("%s: -%d원", IndexValue.SALE_LIST.value.get(i), saleInfo.getSaleList().get(i)));
        }
    }
 }
