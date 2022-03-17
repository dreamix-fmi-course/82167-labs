package labs.streams;

import labs.entity.Item;
import labs.entity.Order;
import labs.entity.OrderLine;
import labs.entity.OrderStatus;
import labs.entity.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchExerciseTest {

    private SearchExercise service = new SearchExercise();

    @Test
    public void getActiveOrdersTest() {
        Order order1 = new Order(OrderStatus.ACTIVE);
        Order order2 = new Order(OrderStatus.ACTIVE);
        Order order3 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2, order3);
        assertEquals(Arrays.asList(order1, order2), service.getActiveOrders(user));
    }

    @Test
    public void getOrderByIdTest() {
        Order order1 = new Order(12);
        Order order2 = new Order(13);
        Order order3 = new Order(14);

        List<Order> orders = List.of(order1, order2, order3);
        assertEquals(order1, service.getOrderById(orders, 12));
        assertEquals(order2, service.getOrderById(orders, 13));
        assertEquals(order3, service.getOrderById(orders, 14));
}

    @Test
    public void getOrderByIdTest_When_id_not_found_Then_Throw() {
        Order order1 = new Order(12);
        Order order2 = new Order(13);
        Order order3 = new Order(14);

        List<Order> orders = List.of(order1, order2, order3);

        assertThrows(IllegalArgumentException.class, () -> service.getOrderById(orders, 15));

    }

    @Test
    public void hasActiveOrdersTest_true() {
        Order order1 = new Order(OrderStatus.DRAFT);
        Order order2 = new Order(OrderStatus.ACTIVE);
        Order order3 = new Order(OrderStatus.DRAFT);

        User user = new User(order1, order2, order3);

        assertTrue(service.hasActiveOrders(user));
    }

    @Test
    public void hasActiveOrdersTest_When_inactive_Then_return_false() {
        Order order1 = new Order(OrderStatus.DRAFT);
        Order order2 = new Order(OrderStatus.DRAFT);
        Order order3 = new Order(OrderStatus.DRAFT);

        User user = new User(order1, order2, order3);

        assertFalse(service.hasActiveOrders(user));
    }

    @Test
    public void canBeReturnedTest_When_no_items_Then_return_true() {
        Order order = new Order();
        assertTrue(service.canBeReturned(order));
    }

    @Test
    public void canBeReturnedTest_When_item_have_SO_Then_return_false() {
        OrderLine orderLine1 = new OrderLine(null, false, 0);
        OrderLine orderLine2 = new OrderLine(null, true, 0);
        OrderLine orderLine3 = new OrderLine(null, false, 0);
        Order order = new Order(orderLine1, orderLine2, orderLine3);

        assertFalse(service.canBeReturned(order));
    }

    @Test
    public void getMaxPriceOrderTest() {
        OrderLine orderLine1 = new OrderLine(new Item("descr1", BigDecimal.valueOf(10)), false, 1);
        OrderLine orderLine2 = new OrderLine(new Item("descr1", BigDecimal.valueOf(12)), true, 2);
        OrderLine orderLine3 = new OrderLine(new Item("descr1", BigDecimal.valueOf(5)), false, 3);
        Order order = new Order(orderLine1, orderLine2, orderLine3);

        OrderLine orderLine4 = new OrderLine(new Item("descr2", BigDecimal.valueOf(2)), true, 2);
        OrderLine orderLine5 = new OrderLine(new Item("descr2", BigDecimal.valueOf(5)), false, 3);
        OrderLine orderLine6 = new OrderLine(new Item("descr2", BigDecimal.valueOf(3)), false, 1);
        Order order2 = new Order(orderLine4, orderLine5, orderLine6);

        order.setId(1);
        order2.setId(2);

        assertEquals(service.getMaxPriceOrder(new User(order, order2)).orElse(null), order);
    }

    @Test
    public void getMaxPriceOrderTest_When_no_orders_Then_return_nothing() {
        assertTrue(service.getMaxPriceOrder(new User()).isEmpty());
    }


}