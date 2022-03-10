package labs.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a class User with list of orders
 */
public class User {
    private List<Order> basket;

    public User() {
        this.basket = new ArrayList<>();
    }

    public User(Order... orders) {
        this.basket = new ArrayList<>(orders.length);
        basket.addAll(List.of(orders));
    }

    public List<Order> getBasket() {
        return basket;
    }

    public void setBasket(List<Order> basket) {
        this.basket = basket;
    }
}