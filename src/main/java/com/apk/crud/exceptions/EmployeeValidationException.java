package com.apk.crud.exceptions;

import com.apk.crud.constants.ErrorCode;
import com.apk.crud.model.APIErrors;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class EmployeeValidationException extends RuntimeException {

    private final List<APIErrors> apiErrorsList;
    private final ErrorCode errorCode;
    private final HttpStatus httpStatusCode;

    public EmployeeValidationException(ErrorCode errorCode, List<APIErrors> apiErrorsList) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.apiErrorsList = apiErrorsList;
        this.httpStatusCode = HttpStatus.BAD_REQUEST;
    }
}
