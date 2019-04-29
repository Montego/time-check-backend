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
        System.out.println("get events");
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

    @PutMapping("{id}/done")
    public void isDone(
            @PathVariable("id") Long id,
            @RequestBody boolean is_done) {
        Event eventFromDB = eventService.getOne(id);
        Event newPropEvent = eventService.getOne(id);
        newPropEvent.set_done(is_done);
        BeanUtils.copyProperties(newPropEvent, eventFromDB, "id");
        System.out.println("is done  = "+ is_done);
        eventService.save(eventFromDB);
    }

    @PutMapping("{id}")
    public void update(
            @PathVariable("id") Event eventFromDB,
            @RequestBody Event event) {
        BeanUtils.copyProperties(event, eventFromDB, "id");
        System.out.println("update event");
        eventService.save(eventFromDB);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("delete event");
        eventService.delete(id);
    }
}
