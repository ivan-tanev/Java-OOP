package bakery.entities.tables.interfaces;

public class OutsideTable extends BaseTable {
    private static final double pricePerPerson = 3.50;
    public OutsideTable(int tableNumber, int capacity, double pricePerPerson) {
        super(tableNumber, capacity, pricePerPerson);
    }
}
