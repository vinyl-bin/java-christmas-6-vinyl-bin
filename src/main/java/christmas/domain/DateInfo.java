package christmas.domain;

public class DateInfo {
    private final int date;
    private final int dday;
    private final int isWeekdayWeekend;
    private final int isSpecial;

    public DateInfo(int date) {
        this.date = date;
        this.dday = Dday(date);
        this.isWeekdayWeekend = IsWeekdayWeekend(date);
        this.isSpecial = IsSpecial(date);
    }

    private int Dday(int date) {
        if (date > DateVoca.CHRISTMAS_DDAY.date ) {
            return DateVoca.NONE_VALUE.date;
        }
        return date-1;
    }

    private int IsWeekdayWeekend(int date) {
        if (date%7 == 1 || date%7 == 2) {
            return DateVoca.WEEKEND.date;
        }
        return DateVoca.WEEKDAY.date;
    }

    private int IsSpecial(int date) {
        if (SpecialDate.SPECIAL_DATE.dates.contains(date)) {
            return DateVoca.SPECIAL.date;
        }
        return DateVoca.NONE_VALUE.date;
    }

    public int getDate() {
        return date;
    }
    public int getDday() {
        return dday;
    }

    public int getIsWeekdayWeekend() {
        return isWeekdayWeekend;
    }

    public int getIsSpecial() {
        return isSpecial;
    }
}
