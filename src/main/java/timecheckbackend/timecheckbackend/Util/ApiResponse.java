package timecheckbackend.timecheckbackend.Util;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private Boolean isSuccess;
    private String message;
//    private HttpStatus status;

    public ApiResponse(boolean isSuccess, String message) {
    }
}
