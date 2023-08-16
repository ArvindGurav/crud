package com.apk.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIErrors {

    private String object;
    private String field;
    private String rejectedValue;
    private String reason;
}
