package timecheckbackend.timecheckbackend.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Date can't be empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime date_of;

    @NotBlank(message = "Event's name can't be empty")
    private String name;

    private String full_info;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fullEventsList_id")
    private FullEventsList fullEventsList;
}
