package timecheckbackend.timecheckbackend.payloads;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerResponse {
    long id;

    private String lastname;

    private String firstname;

    private String patronic;

    private String birthday;
}
