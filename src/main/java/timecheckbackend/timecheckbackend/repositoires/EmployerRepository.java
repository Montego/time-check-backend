package timecheckbackend.timecheckbackend.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import timecheckbackend.timecheckbackend.entities.Employer;

import java.util.List;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    List<Employer> findAllByOrderByIdAsc();
}
