package timecheckbackend.timecheckbackend.payloads;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerFullnameResponse {
    long id;

    private String fullname;

}
