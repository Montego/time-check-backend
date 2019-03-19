package timecheckbackend.timecheckbackend.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import timecheckbackend.timecheckbackend.entities.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
