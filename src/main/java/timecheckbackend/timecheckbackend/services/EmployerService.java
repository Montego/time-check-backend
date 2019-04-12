package timecheckbackend.timecheckbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timecheckbackend.timecheckbackend.entities.Employer;
import timecheckbackend.timecheckbackend.repositoires.EmployerRepository;

import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public void save(Employer employer) {
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

    public List<String> getAllFullNames() throws NoSuchFieldException {

        return employerRepository.findAllByFullname();
//        return employerRepository.findAll();
    }

    public List<String> getAllLastnames() {
        return employerRepository.findAllByLastname();
    }
}
