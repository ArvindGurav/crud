package com.apk.crud.model;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class APIResponse<T> {

    private T data;
    private Status status;
    private int statusCode;
    private String errorMessage;
    private List<APIErrors> subErrors;

    @Builder(toBuilder = true)
    public APIResponse(T data, Status status, int statusCode, String errorMessage, List<APIErrors> subErrors) {
        this.data = data;
        this.status = status;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.subErrors = subErrors;
    }

    public static <T> APIResponse<T> success(T data) {
        return new APIResponse(data, Status.SUCCESS, 1, null, null);
    }

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
