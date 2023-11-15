package christmas.service;

import christmas.domain.DateInfo;

public class DateInfoService {


    public DateInfo setDateInfo(int input) {
        DateInfo dateInfo = new DateInfo(input);
        return dateInfo;
    }
}
