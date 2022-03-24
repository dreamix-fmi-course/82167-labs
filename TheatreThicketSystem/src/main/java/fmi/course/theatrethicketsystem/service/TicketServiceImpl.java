package fmi.course.theatrethicketsystem.service;

import fmi.course.theatrethicketsystem.model.Event;
import fmi.course.theatrethicketsystem.model.Ticket;
import fmi.course.theatrethicketsystem.model.User;

import java.time.LocalDate;
import java.util.List;

public class TicketServiceImpl implements TicketService {
    @Override
    public void createTicket(Ticket u) {

    }

    @Override
    public void removeTicket(Long id) {

    }

    @Override
    public Ticket findById(Long id) {
        return null;
    }

    @Override
    public void updateTicketById(Long id) {

    }

    @Override
    public List<Ticket> findAllTicketsByUser(User id) {
        return null;
    }

    @Override
    public List<Ticket> findAllTicketByEvent(Event event) {
        return null;
    }

    @Override
    public List<Event> findAllEventsBetweenDates(LocalDate from, LocalDate to) {
        return null;
    }
}
