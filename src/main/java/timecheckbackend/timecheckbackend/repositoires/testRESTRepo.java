package timecheckbackend.timecheckbackend.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import timecheckbackend.timecheckbackend.entities.TestREST;

public interface testRESTRepo extends JpaRepository<TestREST, Long> {
}
