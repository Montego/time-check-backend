package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.Event;
import timecheckbackend.timecheckbackend.services.EventService;

import java.util.List;


@RestController
@RequestMapping("api/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> eventsList() {
        return eventService.getAll();
    }

    @GetMapping("{id}")
    public Event getOne(@PathVariable Long id) {
        return eventService.getOne(id);
    }

    @PostMapping()
    public Event create(@RequestBody Event event) {
//      event.setCreationDate(LocalDateTime.now());
        System.out.println("save event");
        eventService.save(event);
        return event;
    }

    @PutMapping("{id}")
    public void update(
            @PathVariable("id") Event eventFromDB,
            @RequestBody Event event) {
        BeanUtils.copyProperties(event, eventFromDB, "id");
        eventService.save(eventFromDB);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}
