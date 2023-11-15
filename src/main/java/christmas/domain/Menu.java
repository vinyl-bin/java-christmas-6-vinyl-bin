package christmas.domain;

public enum Menu {
    /**애피타이저**/
    SOUP("양송이수프", "애피타이저", 6000),
    TAPAS("타파스", "애피타이저", 5500),
    SALAD("시저샐러드", "애피타이저", 8000),

    /**메인**/
    STAKE("티본스테이크", "메인", 55000),
    RIB("바비큐립", "메인", 54000),
    SEAFOOD_PASTA("해산물파스타", "메인", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", "메인", 25000),

    /**디저트**/
    CAKE("초코케이크", "디저트", 15000),
    ICECREAM("아이스크림", "디저트", 5000),

    /**음료**/
    COKE("제로콜라", "음료", 3000),
    WINE("레드와인", "음료", 60000),
    SHAMPAGNE("샴페인", "음료", 25000);

    public final String name;
    private final String type;
    private final int price;

    Menu(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
