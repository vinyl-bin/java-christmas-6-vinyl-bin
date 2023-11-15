package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class SaleInfo {
    private final int beforePrice;
    private final List<Integer> saleList;
    private final int afterPrice;
    public SaleInfo(DateInfo dateInfo, MenuCount menuCount) {
        this.beforePrice = calculateBeforePrice(menuCount);
        this.saleList = calculateSaleList(beforePrice, dateInfo, menuCount);
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
            return new ArrayList<>(DateVoca.NONE_VALUE.value);
        }

        List<Integer> saleList = new ArrayList<>();
        saleList.add(dDaySale(dateInfo));
        saleList.add(weekdaySale(dateInfo, menuCount));
        saleList.add
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
}
