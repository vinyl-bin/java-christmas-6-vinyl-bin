package christmas.service;

import christmas.domain.Menu;
import christmas.domain.MenuCount;
import christmas.exception.AllException;

import java.util.ArrayList;
import java.util.List;

public class MenuCountService {

    private final AllException allException = new AllException();

    public MenuCount setMenuCount(List<String> stringMenus, List<Integer> counts) {
        List<Menu> menus = new ArrayList<>();

        for(String stringMenu : stringMenus) {
            Menu menu = allException.stringToMenu(stringMenu);
            menus.add(menu);
        }
        allException.duplicateMenu(menus);
        MenuCount menuCount = new MenuCount(menus, counts);
        return menuCount;
    }
}
