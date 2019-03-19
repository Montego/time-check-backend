package timecheckbackend.timecheckbackend.repositoires;

import org.springframework.data.jpa.repository.JpaRepository;
import timecheckbackend.timecheckbackend.entities.Tabel;

public interface TabelRepository extends JpaRepository<Tabel,Long> {
}
