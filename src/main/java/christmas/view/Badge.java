package christmas.view;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    public final String name;
    public final int price;

    Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
