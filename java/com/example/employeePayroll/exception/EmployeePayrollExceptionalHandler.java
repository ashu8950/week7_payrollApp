package com.example.employeePayroll.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.employeePayroll.dto.ErrorResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionalHandler {

    private static final String DEFAULT_ERROR_MSG = "Exception while processing REST request";

    // Handle invalid date format or malformed JSON
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("Invalid request body or date format", exception);
        ErrorResponseDTO error = new ErrorResponseDTO(
            DEFAULT_ERROR_MSG,
            "Invalid input. Check date format (expected: dd MMM yyyy) or JSON structure.",
            LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Handle validation errors (e.g., @NotBlank, @Min, @Pattern)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationException(MethodArgumentNotValidException exception) {
        String errors = exception.getBindingResult()
                                 .getFieldErrors()
                                 .stream()
                                 .map(err -> err.getField() + ": " + err.getDefaultMessage())
                                 .collect(Collectors.joining(", "));
        log.error("Validation failed: {}", errors);
        ErrorResponseDTO error = new ErrorResponseDTO(
            DEFAULT_ERROR_MSG,
            errors,
            LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Catch-all for other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception exception) {
        log.error("Unexpected error occurred", exception);
        ErrorResponseDTO error = new ErrorResponseDTO(
            DEFAULT_ERROR_MSG,
            exception.getMessage(),
            LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
