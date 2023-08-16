package com.apk.crud.constants;


import lombok.Getter;

@Getter
public enum ErrorCode {
    ERROR_VALIDATING_EMPLOYEE(100,"Error validating Employee details");

    private final int error;
    private final String description;

    ErrorCode(int error, String description) {
        this.error=error;
        this.description = description;
    }
}
