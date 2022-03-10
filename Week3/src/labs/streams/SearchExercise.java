package labs.streams;

import labs.entity.Order;
import labs.entity.OrderLine;
import labs.entity.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SearchExercise {

    private static final String ORDER_NOT_FOUND_ERROR_FORMAT = "Order with id: %d, was not found.";

    /**
     * extract all active orders
     *
     * @param user
     * @return List<Order>
     */
    public List<Order> getActiveOrders(User user) {
        Objects.requireNonNull(user);

        if (user.getBasket() == null || user.getBasket().isEmpty()) {
            return List.of();
        }

        return user.getBasket()
            .stream()
            .filter(Order::isActive)
            .toList();
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        Objects.requireNonNull(user);

        if (user.getBasket() == null || user.getBasket().isEmpty()) {
            return List.of();
        }

        List<Order> result = new ArrayList<>();

        for (Order order : user.getBasket()) {
            result.add(order);
        }

        return List.copyOf(result);
    }

    /**
     * Return order by a specific id
     *
     * @param orders
     * @param orderId
     * @return Order
     */
    public Order getOrderById(List<Order> orders, long orderId) {
        Objects.requireNonNull(orders);

        return orders.stream()
            .dropWhile(order -> order.getId() != orderId)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                String.format(ORDER_NOT_FOUND_ERROR_FORMAT, orderId)
            ));
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        Objects.requireNonNull(orders);

        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }

        throw new IllegalArgumentException(String.format(ORDER_NOT_FOUND_ERROR_FORMAT, orderId));
    }

    /**
     * Return orders that have specific description for item
     *
     * @param user
     * @param description
     * @return List<Order>
     */
    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        Objects.requireNonNull(user);
        Objects.requireNonNull(description);

        if (user.getBasket() == null || user.getBasket().isEmpty()) {
            return List.of();
        }

        return user.getBasket()
            .stream()
            .filter(order -> order.getOrderLines()
                .stream()
                .map(OrderLine::getItem)
                .dropWhile(item -> !item.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null) != null
            )
            .toList();
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {
        Objects.requireNonNull(user);

        if (user.getBasket() == null || user.getBasket().isEmpty()) {
            return false;
        }

        return user.getBasket()
            .stream()
            .anyMatch(Order::isActive);
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        Objects.requireNonNull(order);

        if (order.getOrderLines() == null || order.getOrderLines().isEmpty()) {
            return true;
        }

        return order.getOrderLines()
            .stream()
            .noneMatch(OrderLine::isSpecialOffer);
    }

    /**
     * Return the order with maximum total price
     *
     * @param user
     * @return
     */
    public Optional<Order> getMaxPriceOrder(User user) {
        Objects.requireNonNull(user);

        if (user.getBasket() == null || user.getBasket().isEmpty()) {
            return Optional.empty();
        }

        return user.getBasket()
            .stream()
            .max(Comparator.comparing(SearchExercise::getOrderPrice));
    }

    private static BigDecimal getOrderPrice(Order order) {
        Objects.requireNonNull(order);

        if (order.getOrderLines() == null || order.getOrderLines().isEmpty()) {
            return BigDecimal.ZERO;
        }

        return order.getOrderLines()
            .stream()
            .map(orderLine -> orderLine.getItem().getPrice().multiply(BigDecimal.valueOf(orderLine.getCount())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}