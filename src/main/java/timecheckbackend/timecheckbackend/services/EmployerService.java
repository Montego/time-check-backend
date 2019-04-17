package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.controllers.EmployerController;
import timecheckbackend.timecheckbackend.entities.Employer;
import timecheckbackend.timecheckbackend.entities.FullEventsList;
import timecheckbackend.timecheckbackend.payloads.EmployerFullnameResponse;
import timecheckbackend.timecheckbackend.payloads.EmployerResponse;
import timecheckbackend.timecheckbackend.repositoires.EmployerRepository;
import timecheckbackend.timecheckbackend.repositoires.FullEventsListRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final FullEventsListRepository fullEventsListRepository;
    @Autowired
    public EmployerService(EmployerRepository employerRepository, FullEventsListRepository fullEventsListRepository) {
        this.employerRepository = employerRepository;
        this.fullEventsListRepository = fullEventsListRepository;
    }

    public void save(Employer employer) {
        employer.setFullname(employer.getLastname() + " " + employer.getFirstname() + " " + employer.getPatronic());
        employerRepository.save(employer);
    }

    public void delete(Long id) {
        employerRepository.deleteById(id);

    }

    public Employer getOne(Long id) {
        employerRepository.findById(id);

        return employerRepository.findById(id).orElse(null);
    }

    public List<Employer> getAll() {
        return employerRepository.findAll();
//        return employerRepository.findAll();
    }

    public List<EmployerFullnameResponse> getAllEmployersFullnameResponse() {
        List<EmployerFullnameResponse> employersFullnameResponse = new ArrayList<>();
        List<Employer> employers = employerRepository.findAll();

        for (int i = 0; i<employers.size();i++){
            EmployerFullnameResponse employerFullnameResponse = new EmployerFullnameResponse();
            employerFullnameResponse.setId(employers.get(i).getId());
            employerFullnameResponse.setFullname(employers.get(i).getFullname());
            employersFullnameResponse.add(employerFullnameResponse);
        }
        return employersFullnameResponse;
    }

    public List<EmployerResponse> getAllEmployersResponse() {
        List<EmployerResponse> employersResponse = new ArrayList<>();
        List<Employer> employers = employerRepository.findAll();

        for (int i = 0; i<employers.size();i++){
            EmployerResponse employerResponse = new EmployerResponse();
            employerResponse.setId(employers.get(i).getId());
            employerResponse.setFirstname(employers.get(i).getFirstname());
            employerResponse.setLastname(employers.get(i).getLastname());
            employerResponse.setPatronic(employers.get(i).getPatronic());
            employerResponse.setBirthday(employers.get(i).getBirthday());
            employersResponse.add(employerResponse);
        }
        return employersResponse;
    }

    public List<String> getAllFullNames() throws NoSuchFieldException {

        return employerRepository.findAllByFullname();
//        return employerRepository.findAll();
    }

    public List<String> getAllLastnames() {
        return employerRepository.findAllByLastname();
    }
}
