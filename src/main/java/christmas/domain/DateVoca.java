package christmas.domain;

public enum DateVoca {

     CHRISTMAS_DDAY(25),
     NONE_VALUE(-1),
     WEEKDAY(1),
     WEEKEND(2),
     SPECIAL(1);



     public final int date;

     DateVoca(int date) {
          this.date = date;
     }

}
