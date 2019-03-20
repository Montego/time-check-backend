package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.Event;
import timecheckbackend.timecheckbackend.repositoires.EventRepository;

import java.util.List;


@RestController
@RequestMapping("api/events")
public class EventController {
    private final EventRepository eventRepository;

    @Autowired
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Event> list() {
        return eventRepository.findAll();
    }

    @GetMapping("{id}")
    public Event getOne(@PathVariable("id") Event event) {
        return event;
    }

    @PostMapping()
    public Event create(@RequestBody Event event) {
//        event.setCreationDate(LocalDateTime.now());
        return eventRepository.save(event);
    }

    @PutMapping("{id}")
    public Event update(
            @PathVariable("id") Event eventFromDB,
            @RequestBody Event event) {
        BeanUtils.copyProperties(event, eventFromDB, "id");
        return eventRepository.save(eventFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Event event) {
        eventRepository.delete(event);
    }
}
