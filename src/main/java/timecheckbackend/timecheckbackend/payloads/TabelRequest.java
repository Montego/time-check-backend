package timecheckbackend.timecheckbackend.payloads;

import lombok.Data;

@Data
public class TabelRequest {
    long id;

//    private long employer;

    private long fullname;

    private String date_of;

    private int overtime;

    private int lesstime;

    private int seakleave;

    private int time_off;

    private int vacation;
}
