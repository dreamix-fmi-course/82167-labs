package fmi.course.theatrethicketsystem.service;

import fmi.course.theatrethicketsystem.model.Event;
import fmi.course.theatrethicketsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository events;

    @Autowired
    public EventServiceImpl(EventRepository events) {
        this.events = events;
    }

    @Override
    public void createEvent(Event u) {
        events.createEvent(u);
    }

    @Override
    public void removeEvent(Long id) {
        events.removeEvent(id);
    }

    @Override
    public Event findById(Long id) {
        return events.findById(id);
    }

    @Override
    public void updateEvent(Event event) {
        events.updateEvent(event);
    }
}
