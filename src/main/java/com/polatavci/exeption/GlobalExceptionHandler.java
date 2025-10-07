package com.polatavci.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<ErrorResponse<Map<String, List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = new HashMap<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField(); // Hatalı field'ın adı
            // O fieldda zaten hata varsa üzerine ekle
            if (errors.containsKey(fieldName)) {
                errors.get(fieldName).add(error.getDefaultMessage());
            }
            // O fieldda hata yoksa yeni list oluşturup hatayı ekle
            else {
                List<String> errorMessages = new ArrayList<>();
                errorMessages.add(error.getDefaultMessage());
                errors.put(fieldName, errorMessages);
            }
        }

        return ResponseEntity.badRequest().body(createErrorResponse(errors, ex.getStatusCode().value()));
    }

    private <T> ErrorResponse<T> createErrorResponse(T message, int status) {
        ErrorResponse<T> response = new ErrorResponse<>();
        response.setMessage(message);
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(status);
        return response;
    }
}
