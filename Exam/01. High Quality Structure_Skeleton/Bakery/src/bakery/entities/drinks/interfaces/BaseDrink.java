package bakery.entities.drinks.interfaces;

public abstract class BaseDrink implements Drink {
    private String name;
    private int portion;
    private double price;
    private String brand;

    public BaseDrink(String name, int portion, double price, String brand) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
        this.setBrand(brand);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public String toString() {
        return "BaseDrink{}";
    }
}
