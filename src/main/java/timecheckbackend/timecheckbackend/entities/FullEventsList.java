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

//    @OneToMany(mappedBy = "fullEventsList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Event> event;
//
//    @OneToMany(mappedBy = "fullEventsList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Employer> employer;
//
//    @OneToMany(mappedBy = "fullEventsList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Tabel> tabel;

    private String date_of;

    private String name;

    private String full_info;
}
