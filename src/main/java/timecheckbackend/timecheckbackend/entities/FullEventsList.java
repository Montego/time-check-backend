package timecheckbackend.timecheckbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FullEventsList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String date_of;

    private String name;

    private String full_info;
}
