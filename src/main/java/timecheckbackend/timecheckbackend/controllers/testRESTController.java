package timecheckbackend.timecheckbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import timecheckbackend.timecheckbackend.entities.TestREST;
import timecheckbackend.timecheckbackend.repositoires.TestRESTRepo;


@RestController
@RequestMapping("/api/testREST")
public class testRESTController {
    private final TestRESTRepo testRESTRepo;
    @Autowired
    public testRESTController(TestRESTRepo testRESTRepo) {
        this.testRESTRepo = testRESTRepo;
    }
    @PostMapping("/post")
    public TestREST create(@RequestBody TestREST testREST) {
        return testRESTRepo.save(testREST);
    }
    @GetMapping("/test")
    public String test(){
        return "HelloWorld";
    }

}
