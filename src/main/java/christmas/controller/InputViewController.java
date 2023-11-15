package christmas.controller;

import christmas.domain.DateInfo;
import christmas.domain.MenuCount;
import christmas.exception.AllException;
import christmas.service.DateInfoService;
import christmas.service.MenuCountService;

import java.util.ArrayList;
import java.util.List;

public class InputViewController {

    private final AllException allException = new AllException();
    private final DateInfoService dateInfoService = new DateInfoService();
    private final MenuCountService menuCountService = new MenuCountService();

    public DateInfo connectDateInfo(String str) {
        int input = allException.stringToIntDate(str);
        DateInfo dateInfo = dateInfoService.setDateInfo(input);
        return dateInfo;
    }

    public MenuCount connectMenuCount(String str) {
        List<String> menus = splitMenu(str);
        List<Integer> counts = splitCount(str);
        MenuCount menuCount = menuCountService.setMenuCount(menus, counts);
        return menuCount;
    }

    private List<String> splitMenu(String str) {
        List<String> menus = new ArrayList<>();
        String[] menuCounts = str.split(",");

        for (String menuCount : menuCounts) {
            String menu = menuCount.split("-")[0];
            menus.add(menu);
        }
        return menus;
    }

    private List<Integer> splitCount(String str) {
        List<Integer> counts = new ArrayList<>();
        String[] menuCounts = str.split(",");

        for (String menuCount : menuCounts) {
            String strCount = menuCount.split("-")[1];
            int count = allException.stringToIntMenu(strCount);
            counts.add(count);
        }
        return counts;
    }
}
