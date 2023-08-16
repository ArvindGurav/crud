package com.apk.crud.exceptions.handler;

import com.apk.crud.exceptions.EmployeeValidationException;
import com.apk.crud.model.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EmployeeValidationException.class)
    protected ResponseEntity handleEmployeeValidationException(EmployeeValidationException ex) {
        APIResponse apiResponse = APIResponse.builder()
                .status(APIResponse.Status.FAILURE)
                .statusCode(ex.getErrorCode().getError())
                .errorMessage(ex.getMessage())
                .subErrors(ex.getApiErrorsList())
                .build();
        return new ResponseEntity(apiResponse, ex.getHttpStatusCode());
    }
}
