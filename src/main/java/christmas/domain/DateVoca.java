package christmas.domain;

public enum DateVoca {

     LIMITIED_PRICE (10000),
     CHRISTMAS_DDAY(25),
     START_PRICE(1000),
     ADD_PRICE(100),
     NONE_VALUE(-1),
     WEEKDAY(1),
     WEEKEND(2),
     WEEK_SALE_PRICE(2023),
     SPECIAL_SALE_PRICE(1000),
     PRESENT_LIMITIED_PRICE(120000),
     PRESENT_SALE_PRICE(25000),
     PRESENT_SALE_INDEX(4),
     SPECIAL(1);



     public final int value;

     DateVoca(int value) {
          this.value = value;
     }

}
