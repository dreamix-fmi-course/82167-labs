package fmi.course.theatrethicketsystem.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Ticket {

    private Long ticketId;
    private BigDecimal price;
    private int row;
    private int seat;
    private User user;
    private Event event;

    public Ticket(Long ticketId, BigDecimal price, int row, int seat, User user,
                  Event event) {
        this.ticketId = ticketId;
        this.price = price;
        this.row = row;
        this.seat = seat;
        this.user = user;
        this.event = event;
    }
}
