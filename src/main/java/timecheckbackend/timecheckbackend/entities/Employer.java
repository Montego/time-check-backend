package timecheckbackend.timecheckbackend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Generated;

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

//    @NotBlank(message = "Last name can't be empty")
    private String lastname;

    //    @NotBlank(message = "First name can't be empty")
    private String firstname;

    private String patronic;
@Generated
    private String fullname = lastname + " " + firstname + " " + patronic;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private LocalDateTime creationDate;

//    @ManyToMany
//    @JoinTable(
//            name="employers_tabels",
//            joinColumns = {@JoinColumn(name = "employer_id")},
//            inverseJoinColumns = {@JoinColumn(name="tabel_id")}
//    )
//    private Set<Tabel> tabels = new HashSet<>();


    @NotBlank(message = "Birthday Date can't be empty")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String birthday;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fullEventsList_id")
    private FullEventsList fullEventsList;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Tabel> tabel;

}
