package fmi.course.theatrethicketsystem.repository;

import fmi.course.theatrethicketsystem.model.Event;
import fmi.course.theatrethicketsystem.service.EventService;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @Override
    public void createEvent(Event event) {

    }

    @Override
    public void removeEvent(Long id) {

    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public void updateEvent(Event event) {

    }
}
