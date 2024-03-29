package com.online.test_trail.exception;

import com.online.test_trail.helper.ApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    private final ApiResponse apiResponse;

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, Object>> authenticationExceptionHandler(AuthenticationException authenticationException) {
        return apiResponse.successResponse(authenticationException.getMessage(), false, authenticationException.getMessage(), null);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> notFoundExceptionHandler(ResourceNotFoundException notFoundException) {
        return apiResponse.successResponse(notFoundException.getMessage(), false, notFoundException.getMessage(), null);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> methodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException notSupportedException) {
        return apiResponse.successResponse(notSupportedException.getMessage(), false, notSupportedException.getMessage(), null);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Map<String, Object>> jwtExceptionHandler(ExpiredJwtException jwtException) {
        return apiResponse.successResponse(jwtException.getMessage(), false, jwtException.getMessage(), null);
    }

}
