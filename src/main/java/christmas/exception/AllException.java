package christmas.exception;

import christmas.domain.Menu;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllException {

    private final int FIRST_DAY = 1;
    private final int LAST_DAY = 31;

    /**날짜는 숫자만 입력**/
    public int stringToIntDate(String str) {
        try {
            int input = Integer.parseInt(str);
            isDate(input);
            return input;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            throw new NumberFormatException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    /**날짜는 1이상 31이하 숫자만 입력**/
    private void isDate(int input) {
        if(input < FIRST_DAY || input > LAST_DAY) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }


    /**메뉴의 개수는 숫자만 입력**/
    public int stringToIntMenu(String str) {
        try {
            int input = Integer.parseInt(str);
            isOverZero(input);
            return input;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new NumberFormatException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

    }

    /**메뉴의 개수는 1 이상의 숫자만 입력**/
    private void isOverZero(int input) {
        if (input <= 0) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    /**메뉴판에 없는 메뉴 입력하는 경우**/
    public Menu stringToMenu(String stringMenu) {
        for (Menu menuItem : Menu.values()) {
            if (menuItem.name.equals(stringMenu)) {
                return menuItem;
            }
        }
        System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    /**중복 메뉴 입력하는 경우**/
    public void duplicateMenu(List<Menu> menus) {
        Set<Menu> setMenus = new HashSet<>(menus);
        if(menus.size() != setMenus.size()) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public void isOnlyBeverage(List<Menu> menus) {
        int beverageCount = 0;
        for (Menu menu : menus) {
            if (menu.type.equals("음료")) {
                beverageCount++;
            }
        }
        if (beverageCount == menus.size()) {
            System.out.println("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
            throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
        }
    }

    public void isOverLimitedCount(List<Integer> counts) {
        int countSum = counts.stream().mapToInt(Integer::intValue).sum();
        if (countSum > 20) {
            System.out.println("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

}
