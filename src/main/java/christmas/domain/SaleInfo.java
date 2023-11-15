package christmas.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaleInfo {
    private final int beforePrice;
    private final List<Integer> saleList;
    private final int afterPrice;
    public SaleInfo(DateInfo dateInfo, MenuCount menuCount) {
        this.beforePrice = calculateBeforePrice(menuCount);
        this.saleList = calculateSaleList(beforePrice, dateInfo, menuCount);
        this.afterPrice = calculateAfterPrice(beforePrice, saleList);
    }

    private int calculateBeforePrice(MenuCount menuCount) {
        int sum = 0;
        for (int i = 0; i < menuCount.getMenus().size(); i++) {
            int menuPrice = menuCount.getMenus().get(i).price;
            sum += menuPrice*menuCount.getCounts().get(i);
        }
        return sum;
    }

    private List<Integer> calculateSaleList(int beforePrice, DateInfo dateInfo, MenuCount menuCount) {
        if (beforePrice < DateVoca.LIMITIED_PRICE.value) {
            return new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        }

        List<Integer> saleList = new ArrayList<>();
        saleList.add(dDaySale(dateInfo));
        saleList.add(weekdaySale(dateInfo, menuCount));
        saleList.add(weekendSale(dateInfo, menuCount));
        saleList.add(specialSale(dateInfo));
        saleList.add(presentSale(beforePrice));

        return saleList;
    }

    private int dDaySale(DateInfo dateInfo) {
        if(dateInfo.getDday() == DateVoca.NONE_VALUE.value) {
            return DateVoca.NONE_VALUE.value;
        }
        int date = dateInfo.getDday();
        return DateVoca.START_PRICE.value+(date*DateVoca.ADD_PRICE.value);
    }

    private int weekdaySale(DateInfo dateInfo, MenuCount menuCount) {
        if (dateInfo.getIsWeekdayWeekend() != DateVoca.WEEKDAY.value) {
            return DateVoca.NONE_VALUE.value;
        }
        int sum = 0;
        for (Menu menu : menuCount.getMenus()) {
            if (menu.type.equals("디저트")) {
                sum += DateVoca.WEEK_SALE_PRICE.value;
            }
        }
        return sum;
    }

    private int weekendSale(DateInfo dateInfo, MenuCount menuCount) {
        if (dateInfo.getIsWeekdayWeekend() != DateVoca.WEEKEND.value) {
            return DateVoca.NONE_VALUE.value;
        }
        int sum = 0;
        for (Menu menu : menuCount.getMenus()) {
            if (menu.type.equals("메인")) {
                sum += DateVoca.WEEK_SALE_PRICE.value;
            }
        }
        return sum;
    }

    private int specialSale(DateInfo dateInfo) {
        if(dateInfo.getIsSpecial() != DateVoca.SPECIAL.value) {
            return DateVoca.NONE_VALUE.value;
        }
        return DateVoca.SPECIAL_SALE_PRICE.value;
    }

    private int presentSale(int beforePrice) {
        if (beforePrice < DateVoca.PRESENT_LIMITIED_PRICE.value) {
            return DateVoca.NONE_VALUE.value;
        }
        return DateVoca.PRESENT_SALE_PRICE.value;
    }

    private int calculateAfterPrice(int beforePrice, List<Integer> saleList){
        int minusValue = 0;
        for(int i = 0; i < saleList.size(); i++) {
            if (saleList.get(i) == 0) {
                continue;
            }
            if (saleList.get(i) == DateVoca.NONE_VALUE.value) {
                continue;
            }
            if (i == DateVoca.PRESENT_SALE_INDEX.value) {
                continue;
            }
            minusValue += saleList.get(i);
        }
        return beforePrice - minusValue;
    }

    public int getBeforePrice() {
        return beforePrice;
    }

    public List<Integer> getSaleList() {
        return saleList;
    }

    public int getAfterPrice() {
        return afterPrice;
    }
}
