package com.apk.crud.Exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeValidationException extends RuntimeException {
    private  String message;

}
