package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.TestREST;
import timecheckbackend.timecheckbackend.repositoires.TestRESTRepo;

import java.util.List;
@Service
public class TestRESTService {
    private final TestRESTRepo testRESTRepo;

    @Autowired
    public TestRESTService(TestRESTRepo testRESTRepo) {
        this.testRESTRepo = testRESTRepo;
    }

    public void add(TestREST testREST){
        testRESTRepo.save(testREST);

    }

    public void delete(Long id){
        testRESTRepo.deleteById(id);
    }

    public List<TestREST> testList(){
        return testRESTRepo.findAll();
    }

    public TestREST getOneTest(Long id){
        return testRESTRepo.findById(id).orElse(null);
    }
}

