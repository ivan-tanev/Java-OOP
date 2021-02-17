package onlineShop.models.products;

public abstract class BaseProduct implements Product {

    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;


    protected BaseProduct(int id, String manufacturer, String model,
                       double price, double overallPerformance) {
        this.setId(id);
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setOverallPerformance(overallPerformance);
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setOverallPerformance(double overallPerformance) {
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getOverallPerformance() {
        return overallPerformance;
    }

    @Override
    public String toString() {
        return "BaseProduct{}";
    }
}
