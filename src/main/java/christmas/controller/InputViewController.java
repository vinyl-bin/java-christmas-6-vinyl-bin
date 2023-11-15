package christmas.controller;

import christmas.domain.DateInfo;
import christmas.exception.AllException;
import christmas.service.DateInfoService;

public class InputViewController {

    private final AllException allException = new AllException();
    private final DateInfoService dateInfoService = new DateInfoService();

    public DateInfo connectDateInfo(String str) {
        int input = allException.stringToInt(str);
        DateInfo dateInfo = dateInfoService.setDateInfo(input);
        return dateInfo;
    }
}
