package uz.pdp.apptest.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {

    private boolean success = false;

    private String message;

    private T data;

    private List<ErrorData> errorDataList;

    private ApiResult(){
        this.success = true;
    }

    private ApiResult(T data){
        this();
        this.data = data;
    }

    private ApiResult(String message, T data){
        this();
        this.data = data;
        this.message = message;
    }

    private ApiResult(String message){
        this();
        this.message = message;
    }

    private ApiResult(String errorMsg, HttpStatus statusCode){
        this.success = false;
        this.errorDataList = Collections.singletonList(new ErrorData(errorMsg, statusCode));
    }

    private ApiResult(List<ErrorData> errorDataList){
        this.success = false;
        this.errorDataList = errorDataList;
    }

    public static <E> ApiResult<E> successResponse() {
        return new ApiResult<>();
    }


    public static <E> ApiResult<E> successResponse(E data) {
        return new ApiResult<>(data);
    }



    public static <E> ApiResult<E> successResponse(E data, String message) {
        return new ApiResult<>(message, data);
    }


    /// TODO Ambiguous
    public static <E> ApiResult<E> successResponse(String message) {
        return new ApiResult<>(message);
    }

    public static ApiResult<ErrorData> errorResponse(String errorMsg, HttpStatus status) {
        return new ApiResult<>(errorMsg, status);
    }

    public static ApiResult<ErrorData> errorResponse(List<ErrorData> errors) {
        return new ApiResult<>(errors);
    }

}
