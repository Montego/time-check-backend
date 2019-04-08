package timecheckbackend.timecheckbackend.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import timecheckbackend.timecheckbackend.entities.TestREST;

public interface TestRESTRepo extends JpaRepository<TestREST, Long> {
}
