package christmas.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.domain.Menu;
import christmas.domain.MenuCount;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuCountServiceTest extends NsTest {

    @Test
    void MenuCount_분류_테스트() {
        //given
        String stringMenuCount = "타파스-1,제로콜라-1";

        //when
        MenuCountService menuCountService = new MenuCountService();
        MenuCount menuCount = menuCountService.saveMenuCount(stringMenuCount);

        //then
        assertTrue(menuCount.getMenus().contains(Menu.TAPAS));
        assertTrue(menuCount.getMenus().contains(Menu.COKE));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}