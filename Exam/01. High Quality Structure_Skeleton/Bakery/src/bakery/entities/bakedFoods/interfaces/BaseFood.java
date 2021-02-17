package bakery.entities.bakedFoods.interfaces;

public abstract class BaseFood implements BakedFood {
    private String name;
    private double portion;
    private double price;

    public BaseFood(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPortion(double portion) {
        this.portion = portion;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "BaseFood{}";
    }
}
