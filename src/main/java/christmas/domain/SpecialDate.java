package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum SpecialDate {
    /** 특별할인 날짜 **/
    SPECIAL_DATE(Arrays.asList(3, 10, 17, 24, 25, 31));

    private final List<Integer> dates;

    SpecialDate(List<Integer> dates) {
        this.dates = dates;
    }

    public List<Integer> getDates() {
        return dates;
    }
}
