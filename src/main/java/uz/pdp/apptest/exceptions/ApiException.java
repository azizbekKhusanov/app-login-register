package uz.pdp.apptest.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    private ApiException(String message) {
        super(message);
    }

    private ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public static ApiException apiException(String message) {
        return new ApiException(message);
    }

    public static ApiException apiException(String message, HttpStatus status) {
        return new ApiException(message, status);
    }

}