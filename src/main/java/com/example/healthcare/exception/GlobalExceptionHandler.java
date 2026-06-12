package com.example.healthcare.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
    public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {

         Map<String, String> errors = new HashMap<>();
          ex.getBindingResult().getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );

          return ResponseEntity.badRequest().body(errors);
        }

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<?> handleRuntime(RuntimeException ex) {
            Map<String,String> err = new HashMap<>();
            err.put("error", ex.getMessage());
            return ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body(err);
        }

     @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleException(Exception ex) {
            Map<String,String> err = new HashMap<>();
            err.put("error", "Internal server error");
            return ResponseEntity.status(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR).body(err);
        }
    }
