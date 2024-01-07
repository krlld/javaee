package com.example.boot.exception.handler;

import com.example.boot.exception.PictureNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PictureNotFoundException.class)
    public ResponseEntity<String> pictureNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Picture not found");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        StringBuilder message = new StringBuilder();
        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> message
                        .append(fieldError.getField())
                        .append(":")
                        .append(fieldError.getDefaultMessage())
                        .append("\n"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message.toString());
    }
}
