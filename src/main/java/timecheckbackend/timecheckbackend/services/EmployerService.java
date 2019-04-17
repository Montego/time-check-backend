package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.Employer;
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
    public EmployerService(EmployerRepository employerRepository,
                           FullEventsListRepository fullEventsListRepository) {
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
        for (int i = 0; i < employers.size(); i++) {
            EmployerFullnameResponse employerFullnameResponse = new EmployerFullnameResponse(
                    employers.get(i).getId(),
                    employers.get(i).getFullname()
            );
            employersFullnameResponse.add(employerFullnameResponse);
        }
        return employersFullnameResponse;
    }

    public List<EmployerResponse> getAllEmployersResponse() {
        List<EmployerResponse> employersResponse = new ArrayList<>();
        List<Employer> employers = employerRepository.findAll();
        for (int i = 0; i < employers.size(); i++) {
            EmployerResponse employerResponse = new EmployerResponse(
                    employers.get(i).getId(),
                    employers.get(i).getLastname(),
                    employers.get(i).getFirstname(),
                    employers.get(i).getPatronic(),
                    employers.get(i).getBirthday()
            );
            employersResponse.add(employerResponse);
        }

        return employersResponse;
    }

    public List<String> getAllFullNames() throws NoSuchFieldException {

        return employerRepository.findAllByFullname();
    }

    public List<String> getAllLastnames() {
        return employerRepository.findAllByLastname();
    }
}
