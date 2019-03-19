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
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First name can't be empty")
    private String firstName;

    @NotBlank(message = "Last name can't be empty")
    private String lastName;

    private String patronicName;

    @ManyToMany
    @JoinTable(
            name="employers_tabels",
            joinColumns = {@JoinColumn(name = "employer_id")},
            inverseJoinColumns = {@JoinColumn(name="tabel_id")}
    )
    private Set<Tabel> tabels = new HashSet<>();


    @NotBlank(message = "Birthday Date can't be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fullEventsList_id")
    private FullEventsList fullEventsList;

}
