package christmas.service;

import christmas.domain.DateInfo;
import christmas.exception.AllException;

public class DateInfoService {

    private final AllException allException = new AllException();

    public DateInfo saveDateInfo(String str) {
        int input = allException.stringToIntDate(str);
        DateInfo dateInfo = setDateInfo(input);
        return dateInfo;
    }

    private DateInfo setDateInfo(int input) {
        DateInfo dateInfo = new DateInfo(input);
        return dateInfo;
    }
}
