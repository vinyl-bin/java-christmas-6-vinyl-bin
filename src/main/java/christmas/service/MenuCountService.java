package christmas.service;

import christmas.domain.Menu;
import christmas.domain.MenuCount;
import christmas.exception.AllException;
import java.util.ArrayList;
import java.util.List;

public class MenuCountService {
    private final AllException allException = new AllException();

    public MenuCount saveMenuCount(String str) {
        List<String> menus = splitMenu(str);
        List<Integer> counts = splitCount(str);
        MenuCount menuCount = setMenuCount(menus, counts);
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

    private MenuCount setMenuCount(List<String> stringMenus, List<Integer> counts) {
        List<Menu> menus = new ArrayList<>();

        for(String stringMenu : stringMenus) {
            Menu menu = allException.stringToMenu(stringMenu);
            menus.add(menu);
        }
        allException.duplicateMenu(menus);
        allException.isOnlyBeverage(menus);
        allException.isOverLimitedCount(counts);
        MenuCount menuCount = new MenuCount(menus, counts);
        return menuCount;
    }
}
