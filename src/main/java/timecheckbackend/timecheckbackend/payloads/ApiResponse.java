package timecheckbackend.timecheckbackend.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiResponse {
    private Boolean isSuccess;
    private String message;
    private List<?> somelist;

    public ApiResponse(boolean isSuccess, String message, List<?> somelist) {

    }

    public ApiResponse(boolean isSuccess, String message) {

    }
}
