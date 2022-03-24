package fmi.course.theatrethicketsystem.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Event {

    private Long eventId;
    private String name;
    private LocalDateTime date;
    private String description;

    public Event(Long eventId, String name, LocalDateTime date, String description) {
        this.eventId = eventId;
        this.name = name;
        this.date = date;
        this.description = description;
    }

}