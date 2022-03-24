package fmi.course.theatrethicketsystem.repository;

import fmi.course.theatrethicketsystem.model.Event;
import fmi.course.theatrethicketsystem.model.Ticket;
import fmi.course.theatrethicketsystem.model.User;
import fmi.course.theatrethicketsystem.service.TicketService;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

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
    public void updateTicketById(Ticket ticket) {

    }
}
