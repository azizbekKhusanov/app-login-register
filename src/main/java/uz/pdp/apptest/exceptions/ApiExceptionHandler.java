package uz.pdp.apptest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.apptest.payload.ApiResult;
import uz.pdp.apptest.payload.ErrorData;

@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(ApiException.class)
    public ApiResult<ErrorData> handle(ApiException exception){

        return ApiResult.errorResponse(exception.getMessage(), exception.getStatus());
    }


    @ExceptionHandler(Exception.class)
    public ApiResult<ErrorData> handle(Exception exception){

        return ApiResult.errorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }




}
