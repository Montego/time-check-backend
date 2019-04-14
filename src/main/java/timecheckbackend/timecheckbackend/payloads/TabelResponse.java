package timecheckbackend.timecheckbackend.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TabelResponse {

        long id;

        private String fullname;

        private String date_of;

        private int overtime;

        private int lesstime;

        private int seakleave;

        private int time_off;

        private int vacation;

}
