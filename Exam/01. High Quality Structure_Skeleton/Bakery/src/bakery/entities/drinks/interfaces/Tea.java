package bakery.entities.drinks.interfaces;

public class Tea extends BaseDrink {
    private static final double teaPrice = 2.50;
    public Tea(String name, int portion, double price, String brand) {
        super(name, portion, price, brand);
    }
}
