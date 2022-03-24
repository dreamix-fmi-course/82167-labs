package fmi.course.theatrethicketsystem.service;

import fmi.course.theatrethicketsystem.model.Event;
import fmi.course.theatrethicketsystem.model.Ticket;
import fmi.course.theatrethicketsystem.model.User;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {

    /**
     * Create and validate ticket.
     * Can NOT create ticket in the past.
     * Can NOT create ticket with negative price.
     * Can NOT duplicate row and seat same event.
     * @param u
     */
    void createTicket(Ticket u);

    void removeTicket(Long id);

    Ticket findById(Long id);

    void updateTicketById(Long id);

    /**
     * Return all tickets bought by a user
     * @param id
     * @return
     */
    List<Ticket> findAllTicketsByUser(User id);

    /**
     * Return all sold tickets by event
     * @param event
     * @return
     */
    List<Ticket> findAllTicketByEvent(Event event);

    /**
     * Return all available events for between two dates
     * @param from
     * @param to
     * @return
     */
    List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to);

}
