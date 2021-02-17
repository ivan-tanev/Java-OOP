package bakery.entities.bakedFoods.interfaces;

public class Cake extends BaseFood {
    private static final int InitialBreadPortion = 245;
    public Cake(String name, double portion, double price) {
        super(name, portion, price);
    }
}
