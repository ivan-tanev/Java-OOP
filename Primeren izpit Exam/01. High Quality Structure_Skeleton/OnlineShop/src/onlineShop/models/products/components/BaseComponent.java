package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;

public abstract class BaseComponent extends BaseProduct implements Component {
    private int generation;

    public BaseComponent(int id, String manufacturer, String model,
                         double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public String toString() {
        return "BaseComponent";
    }
}
//•	CentralProcessingUnit - multiplier is 1.25
//•	Motherboard – multiplier is 1.25
//•	PowerSupply – multiplier is 1.05
//•	RandomAccessMemory – multiplier is 1.20
//•	SolidStateDrive – multiplier is 1.20
//•	VideoCard – multiplier is 1.15