package bakery.entities.bakedFoods.interfaces;

public class Bread extends BaseFood {
    private static final int InitialBreadPortion = 200;
    public Bread(String name, double portion, double price) {
        super(name, portion, price);
    }
}
