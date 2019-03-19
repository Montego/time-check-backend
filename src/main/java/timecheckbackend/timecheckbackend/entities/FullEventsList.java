package timecheckbackend.timecheckbackend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class FullEventsList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Event> events;
    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employer> employers;
    @OneToMany(mappedBy = "tabel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tabel> tabels;
}
