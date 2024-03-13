package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Coffee> coffees;

    public Order() {
        coffees = new ArrayList<>();
    }

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void removeCoffee(int index) {
        coffees.remove(index);
    }

    public void removeAllCoffees() {
        coffees.clear();
    }
}

