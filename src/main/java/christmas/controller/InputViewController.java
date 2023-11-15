package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.DateInfo;
import christmas.domain.MenuCount;
import christmas.service.DateInfoService;
import christmas.service.MenuCountService;

import java.util.NoSuchElementException;

public class InputViewController {
    private final DateInfoService dateInfoService = new DateInfoService();
    private final MenuCountService menuCountService = new MenuCountService();
    public DateInfo connectDateInfo() {
        DateInfo dateInfo = null;
        boolean keep = true;
        while(keep) {
            try {
                String input = Console.readLine();
                dateInfo = dateInfoService.saveDateInfo(input);
                keep = false;
            } catch (NoSuchElementException e) {
                throw e;
            } catch (Exception e){
                keep=true;
            }
        }
        return dateInfo;
    }

    public MenuCount connectMenuCount() {
        MenuCount menuCount = null;
        boolean keep = true;
        while(keep) {
            try {
                String input = Console.readLine();
                menuCount = menuCountService.saveMenuCount(input);
                keep = false;
            } catch (NoSuchElementException e) {
                throw e;
            } catch (Exception e){
                keep=true;
            }
        }
        return menuCount;
    }

}
