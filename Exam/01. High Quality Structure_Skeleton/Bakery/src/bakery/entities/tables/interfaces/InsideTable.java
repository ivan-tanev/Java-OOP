package bakery.entities.tables.interfaces;

public class InsideTable extends BaseTable {
    private static final double pricePerPerson = 2.50;
    public InsideTable(int tableNumber, int capacity, double pricePerPerson) {
        super(tableNumber, capacity, pricePerPerson);
    }
}
