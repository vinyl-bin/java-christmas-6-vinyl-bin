package christmas.service;

import christmas.domain.Menu;
import christmas.domain.MenuCount;
import christmas.exception.AllException;

import java.util.ArrayList;
import java.util.List;

public class MenuCountService {

    public MenuCount setMenuCount(List<String> stringMenus, List<Integer> counts) {
        List<Menu> menus = new ArrayList<>();

        for(String stringMenu : stringMenus) {
            Menu menu = stringToMenu(stringMenu);
            menus.add(menu);
        }
        MenuCount menuCount = new MenuCount(menus, counts);
        return menuCount;
    }

    private Menu stringToMenu(String stringMenu) {
        for (Menu menuItem : Menu.values()) {
            if (menuItem.name.equals(stringMenu)) {
                return menuItem;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
    }
}
