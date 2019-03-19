package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.Employer;
import timecheckbackend.timecheckbackend.repositoires.EmployerRepository;

import java.util.List;

@RestController
@RequestMapping("employers")
public class EmployerController {
    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerController(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @GetMapping
    public List<Employer> list() {
        return employerRepository.findAll();
    }

    @GetMapping("{id}")
    public Employer getOne(@PathVariable("id") Employer employer) {
        return employer;
    }

    @PostMapping()
    public Employer create(@RequestBody Employer employer) {
//        employer.setCreationDate(LocalDateTime.now());
        return employerRepository.save(employer);
    }

    @PutMapping("{id}")
    public Employer update(
            @PathVariable("id") Employer employerFromDB,
            @RequestBody Employer employer) {
        BeanUtils.copyProperties(employer, employerFromDB, "id");
        return employerRepository.save(employerFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Employer employer) {
        employerRepository.delete(employer);
    }
}
