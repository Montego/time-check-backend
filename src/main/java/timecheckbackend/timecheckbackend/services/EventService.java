package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.Event;
import timecheckbackend.timecheckbackend.entities.FullEventsList;
import timecheckbackend.timecheckbackend.repositoires.EventRepository;
import timecheckbackend.timecheckbackend.repositoires.FullEventsListRepository;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final FullEventsListRepository fullEventsListRepository;

    @Autowired
    public EventService(EventRepository eventRepository, FullEventsListRepository fullEventsListRepository) {
        this.eventRepository = eventRepository;
        this.fullEventsListRepository = fullEventsListRepository;
    }

    public void save(Event event) {
        eventRepository.save(event);

        FullEventsList fullEventsList = new FullEventsList();
        fullEventsList.setDate_of(event.getDate_of());
        fullEventsList.setName(event.getName());
        fullEventsList.setFull_info(event.getFull_info());
        fullEventsListRepository.save(fullEventsList);
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
