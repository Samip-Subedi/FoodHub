package com.online.test_trail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalApiResponse implements Serializable {
    private String message;
    private Object data;
    private HttpStatus status;
}
