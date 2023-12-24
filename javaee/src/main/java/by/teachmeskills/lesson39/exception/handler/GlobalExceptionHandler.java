package by.teachmeskills.lesson39.exception.handler;

import by.teachmeskills.lesson39.exception.PictureNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PictureNotFoundException.class)
    public ResponseEntity<String> pictureNotFoundExceptionHandler() {
        return ResponseEntity.status(400).body("Picture not found");
    }
}
