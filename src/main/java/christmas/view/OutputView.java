package christmas.view;

import christmas.domain.DateInfo;
import christmas.domain.DateVoca;
import christmas.domain.MenuCount;
import christmas.domain.SaleInfo;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    DecimalFormat decimalFormat = new DecimalFormat("#,###");

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
            System.out.print(menuCount.getMenus().get(i).name);
            System.out.println(String.format(" %d개", menuCount.getCounts().get(i)));
        }
    }

    public void printMenuPrice(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format(" %s원", decimalFormat.format(saleInfo.getBeforePrice())));
    }

    public void printPresentMenu(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        List<Integer> saleList = saleInfo.getSaleList();
        if (saleList.get(DateVoca.PRESENT_SALE_INDEX.value) == DateVoca.PRESENT_SALE_PRICE.value) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public void printBenefitListIntro(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<혜택 내역>");
        printBenefitList(saleInfo);
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
            System.out.println(String.format("%s: -%s원", IndexValue.SALE_LIST.value.get(i), decimalFormat.format(saleInfo.getSaleList().get(i))));
        }
        if (checkEmpty == saleInfo.getSaleList().size()) {
            System.out.println("없음");
        }
    }

    public int printBenefitPrice(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        int benefitPriceSum = 0;
        List<Integer> saleList = saleInfo.getSaleList();
        for(int i = 0; i < saleList.size(); i++) {
            if (saleList.get(i) != 0 && saleList.get(i) != DateVoca.NONE_VALUE.value) {
                benefitPriceSum += saleList.get(i);
            }
        }
        if (benefitPriceSum != 0) {
            System.out.println(String.format("-%d원", benefitPriceSum));
            return benefitPriceSum;
        }
        System.out.println("0원");
        return 0;
    }

    public void printAfterPrice(SaleInfo saleInfo) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%d원", saleInfo.getAfterPrice()));
    }

    public void printBadge(int benefitPrice) {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        if (benefitPrice >= Badge.SANTA.price) {
            System.out.println(Badge.SANTA.name);
            return;
        }
        if (benefitPrice >= Badge.TREE.price) {
            System.out.println(Badge.TREE.name);
            return;
        }
        if (benefitPrice >= Badge.STAR.price) {
            System.out.println(Badge.STAR.name);
            return;
        }
        System.out.println("없음");
    }
 }
