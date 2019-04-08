package timecheckbackend.timecheckbackend.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import timecheckbackend.timecheckbackend.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
