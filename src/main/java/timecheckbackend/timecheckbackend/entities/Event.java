package timecheckbackend.timecheckbackend.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Date can't be empty")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String date_of;

//    @NotBlank(message = "Event's name can't be empty")
    private String name;

    private String full_info;

    private boolean is_done = false;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "fullEventsList_id")
//    private FullEventsList fullEventsList;
}
