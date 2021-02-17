package onlineShop.models.products.components;

public class PowerSupply extends BaseComponent {
    public PowerSupply(int id, String manufacturer, String model, double price,
                       double overallPerformance, int generation) {

        super(id, manufacturer, model, price, overallPerformance, generation);
    }

    @Override
    public int getGeneration() {
        return 0;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getManufacturer() {
        return null;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getOverallPerformance() {
        return 0;
    }
}
