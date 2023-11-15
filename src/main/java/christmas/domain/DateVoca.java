package christmas.domain;

public enum DateVoca {

     LIMITIED_PRICE (10000),
     CHRISTMAS_DDAY(25),
     START_PRICE(1000),
     ADD_PRICE(100),
     NONE_VALUE(-1),
     WEEKDAY(1),
     WEEKEND(2),
     SPECIAL(1);



     public final int value;

     DateVoca(int value) {
          this.value = value;
     }

}
