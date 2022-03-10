package labs.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/** Create class Order that implements
 * id, status:OrderStatus, List<OrderLine> orderLines, creationDate, totalPrice, paymentMethod,
 * deliveryDueDate, user
 *
 * Implements constructors: default, by status, by id, by array of lines (use ...)
 * getters, setters, toString, isActive
 */
public class Order {
    private long id;
    private OrderStatus orderStatus;
    private List<OrderLine> orderLines;
    private LocalDate date;
    private PaymentMethod paymentMethod;

    public Order() {

    }

    public Order(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(long id) {
        this.id = id;
    }

    public Order(OrderLine... orderLines) {
        this.orderLines = Arrays.stream(orderLines).toList();
    }

    public long getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public LocalDate getDate() {
        return date;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isActive() {
        return orderStatus.equals(OrderStatus.ACTIVE);
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", orderStatus=" + orderStatus +
            ", orderLines=" + orderLines +
            ", date=" + date +
            ", paymentMethod=" + paymentMethod +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}