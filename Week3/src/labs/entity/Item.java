package labs.entity;

import java.math.BigDecimal;

/**
 * Implement Item with description:String and price:BigDecimal
 */

public class Item {

    private final String description;
    private final BigDecimal price;

    public Item(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}