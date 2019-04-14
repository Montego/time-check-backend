package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.FullEventsList;
import timecheckbackend.timecheckbackend.services.FullEventsListService;

import java.util.List;

@RestController
@RequestMapping("api/fullEvents")
public class FullEventsListController {
    private final FullEventsListService fullEventsListService;

    @Autowired
    public FullEventsListController(FullEventsListService fullEventsListService) {
        this.fullEventsListService = fullEventsListService;
    }

    @GetMapping
    public List<FullEventsList> getList() {

        return fullEventsListService.getAll();
    }

    @GetMapping("{id}")
    public FullEventsList getOne(@PathVariable Long id) {
        return fullEventsListService.getOne(id);
    }

    @PostMapping()
    public void create(@RequestBody FullEventsList fullEventsList) {
//        employer.setCreationDate(LocalDateTime.now());
        fullEventsListService.save(fullEventsList);
    }

    @PutMapping("{id}")
    public void update(
            @PathVariable("id") FullEventsList fullEventsListFromDB,
            @RequestBody FullEventsList fullEventsList) {
        BeanUtils.copyProperties(fullEventsList, fullEventsListFromDB, "id");
        fullEventsListService.save(fullEventsListFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        fullEventsListService.delete(id);
    }
}
