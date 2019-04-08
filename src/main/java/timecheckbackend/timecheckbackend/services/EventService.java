package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.Event;
import timecheckbackend.timecheckbackend.repositoires.EventRepository;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event getOne(Long id) {
        return eventRepository.findById(id).orElse(null);
    }
}
