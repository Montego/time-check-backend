package timecheckbackend.timecheckbackend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Tabel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

@ManyToMany
@JoinTable(
        name="tabels_employers",
        joinColumns = {@JoinColumn(name = "tabel_id")},
        inverseJoinColumns = {@JoinColumn(name="employer_id")}
        )
    private Set<Employer> employers = new HashSet<>();


    @NotBlank(message = "Date for tabel can't be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime tabelEvent;

    private int overTime;

    private int lessTime;

    private int SeakLeave;

    private int TimeOff;

    private int Vacation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fullEventsList_id")
    private FullEventsList fullEventsList;

}
