package com.example.boot.controller;

import com.example.boot.domain.Picture;
import com.example.boot.service.PictureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
public class PictureController {

    private final PictureService pictureService;

    @GetMapping
    public ResponseEntity<List<Picture>> getAll() {
        return ResponseEntity.ok(pictureService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Picture> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pictureService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Picture> save(@Valid @RequestBody Picture picture) {
        return ResponseEntity.ok(pictureService.save(picture));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Picture> update(@PathVariable Long id, @Valid @RequestBody Picture picture) {
        return ResponseEntity.ok(pictureService.update(id, picture));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pictureService.delete(id);
        return ResponseEntity.ok().build();
    }
}
