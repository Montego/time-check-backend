package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.Employer;
import timecheckbackend.timecheckbackend.payloads.EmployerFullnameResponse;
import timecheckbackend.timecheckbackend.payloads.EmployerResponse;
import timecheckbackend.timecheckbackend.services.EmployerService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/employers")
public class EmployerController {
    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping
    public List<EmployerResponse> getList() {
        System.out.println("get all employers");

//        return employerService.getAll();
        return employerService.getAllEmployersResponse();
    }
    @GetMapping("/full")
    public List<EmployerFullnameResponse> getListFullnameResponse() {
        return employerService.getAllEmployersFullnameResponse();
    }

    @GetMapping("/fullname")
    public List<String> getListFullName() throws NoSuchFieldException {
        System.out.println("get fullname employers");
        return employerService.getAllFullNames();
    }
    @GetMapping("/lastname")
    public List<String> getListLastname() throws NoSuchFieldException {
        System.out.println("get lastname employers");
        return employerService.getAllLastnames();
    }

    @GetMapping("{id}")
    public Employer getOne(@PathVariable Long id) {
        System.out.println("get one employer");
        return employerService.getOne(id);
    }

    @PostMapping()
    public Employer create(@RequestBody Employer employer) {
//        employer.setCreationDate(LocalDateTime.now());
        System.out.println("save employer");
        employer.setFullname(employer.getLastname() + " " +  employer.getFirstname() + " " + employer.getPatronic());
        employerService.save(employer);
        return employer;
    }

    @PutMapping("{id}")
    public Employer update(
            @PathVariable Long id,
//            @PathVariable("id") Employer employerFromDB,
            @RequestBody Employer employer) {
        Employer employerFromDB = employerService.getOne(id);
        String firstNameFromDB = employerFromDB.getFirstname();
        String lastNameFromDB = employerFromDB.getLastname();
        String patronicFromDB = employerFromDB.getPatronic();
        String birthFromDB = employerFromDB.getBirthday();


        BeanUtils.copyProperties(employer, employerFromDB, "id");
        employerService.save(employerFromDB);
        return employer;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        employerService.delete(id);
        System.out.println("delete employer");
    }
}
