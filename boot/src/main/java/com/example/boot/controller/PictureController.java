package com.example.boot.controller;

import com.example.boot.dto.PictureDto;
import com.example.boot.service.PictureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Pictures", description = "Manage pictures")
public class PictureController {

    private final PictureService pictureService;

    @GetMapping
    @Operation(summary = "Get all", description = "Get all pictures")
    public ResponseEntity<List<PictureDto>> getAll() {
        return ResponseEntity.ok(pictureService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by id", description = "Get pictures by the id")
    public ResponseEntity<PictureDto> getById(
            @PathVariable @Parameter(description = "Picture id", required = true) Long id) {
        return ResponseEntity.ok(pictureService.getById(id));
    }

    @GetMapping(path = "/{id}/pictureFile", produces = MediaType.IMAGE_JPEG_VALUE)
    @Operation(summary = "Get picture file", description = "Get picture file by picture id")
    public ResponseEntity<byte[]> getAvatarById(
            @PathVariable @Parameter(description = "Picture id", required = true) Long id) {
        return ResponseEntity.ok(pictureService.getById(id).getPictureFile());
    }

    @PostMapping
    @Operation(summary = "Save", description = "Save picture and return saved picture")
    public ResponseEntity<PictureDto> save(
            @RequestPart @Parameter(description = "Picture file", required = true) MultipartFile file,
            @Valid @Parameter(description = "Picture data", required = true) PictureDto pictureDto) throws IOException {
        pictureDto.setPictureFile(file.getBytes());
        return ResponseEntity.ok(pictureService.save(pictureDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update", description = "Update picture data by the id and return updated picture")
    public ResponseEntity<PictureDto> update(
            @PathVariable @Parameter(description = "Picture id", required = true) Long id,
            @Valid @RequestBody @Parameter(description = "Picture data", required = true) PictureDto pictureDto) {
        return ResponseEntity.ok(pictureService.update(id, pictureDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete", description = "Delete picture by the id")
    public ResponseEntity<Void> delete(
            @PathVariable @Parameter(description = "Picture id", required = true) Long id) {
        pictureService.delete(id);
        return ResponseEntity.ok().build();
    }
}
