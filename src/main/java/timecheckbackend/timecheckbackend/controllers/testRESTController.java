package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.TestREST;
import timecheckbackend.timecheckbackend.repositoires.testRESTRepo;


@RestController
@RequestMapping("/testREST")
public class testRESTController {
    private final testRESTRepo testRESTRepo;
    @Autowired
    public testRESTController(testRESTRepo testRESTRepo) {
        this.testRESTRepo = testRESTRepo;
    }
    @PostMapping("/post")
    public TestREST create(@RequestBody TestREST testREST) {
        return testRESTRepo.save(testREST);
    }

}
