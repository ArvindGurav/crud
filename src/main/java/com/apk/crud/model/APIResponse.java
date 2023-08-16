package com.apk.crud.model;


import com.apk.crud.constants.ErrorCode;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse<T> {

    private T data;
    private Status status;
    private int errorCode;
    private String errorMessage;
    private List<APIErrors> subErrors;


    public enum Status {
        SUCCESS("SUCCESS"),
        FAILURE("FAILURE");

        private final String status;

        Status(String status) {
            this.status = status;
        }

        @JsonValue
        public String getStatus() {
            return status;
        }
    }
}
