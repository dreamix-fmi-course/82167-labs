package labs.entity;

/**
 * Create OrderLine which holds information for:
 * Item, enum for status, boolean specialOffer and count
 * Implement setters/getters/constructor
 */

public class OrderLine {
    private Item item;
    private boolean specialOffer;
    private long count;

    public OrderLine(Item item, boolean specialOffer, long count) {
        this.item = item;
        this.specialOffer = specialOffer;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public long getCount() {
        return count;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    public void setCount(long count) {
        this.count = count;
    }
}