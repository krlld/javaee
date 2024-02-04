package com.example.boot.controller;

import com.example.boot.domain.Picture;
import com.example.boot.service.PictureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping(path = "/{id}/pictureFile", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getAvatarById(@PathVariable Long id) {
        return ResponseEntity.ok(pictureService.getById(id).getPictureFile());
    }

    @PostMapping
    public ResponseEntity<Picture> save(
            @RequestPart MultipartFile file,
            @Valid Picture picture) throws IOException {
        picture.setPictureFile(file.getBytes());
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
