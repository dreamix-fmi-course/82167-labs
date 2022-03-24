package fmi.course.theatrethicketsystem.service;

import fmi.course.theatrethicketsystem.model.Event;

public interface EventService {

    void createEvent(Event u);

    void removeEvent(Long id);

    Event findById(Long id);

    void updateEvent(Event event);

}
