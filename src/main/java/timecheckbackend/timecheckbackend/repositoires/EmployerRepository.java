package timecheckbackend.timecheckbackend.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import timecheckbackend.timecheckbackend.entities.Employer;

import java.util.List;

public interface EmployerRepository extends JpaRepository<Employer, Long> {

    @Query("SELECT fullname FROM Employer")
    List<String> findAllByFullname();

    @Query("SELECT lastname FROM Employer")
    List<String> findAllByLastname();
}
