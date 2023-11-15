package christmas.domain;

import java.util.List;

public class MenuCount {
    private final List<Menu> menus;
    private final List<Integer> counts;

    public MenuCount(List<Menu> menus, List<Integer> counts) {
        this.menus = menus;
        this.counts = counts;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public List<Integer> getCounts() {
        return counts;
    }
}
