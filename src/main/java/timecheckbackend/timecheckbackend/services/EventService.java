package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.repositoires.EventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
}
