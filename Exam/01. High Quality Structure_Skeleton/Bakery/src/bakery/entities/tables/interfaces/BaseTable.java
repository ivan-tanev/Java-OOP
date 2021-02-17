package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.BaseFood;
import bakery.entities.drinks.interfaces.BaseDrink;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
    private Collection<BaseFood> foodOrders;
    private Collection<BaseDrink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();

    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return 0;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public int getNumberOfPeople() {
        return 0;
    }

    @Override
    public double getPricePerPerson() {
        return 0;
    }

    @Override
    public boolean isReserved() {
        return false;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void reserve(int numberOfPeople) {

    }

    @Override
    public void orderFood(BakedFood food) {

    }

    @Override
    public void orderDrink(Drink drink) {

    }

    @Override
    public double getBill() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getFreeTableInfo() {
        return null;
    }
}
