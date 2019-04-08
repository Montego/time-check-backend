package timecheckbackend.timecheckbackend.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import timecheckbackend.timecheckbackend.entities.FullEventsList;

public interface FullEventsListRepository extends JpaRepository<FullEventsList, Long> {
}
