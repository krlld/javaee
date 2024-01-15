package by.teachmeskills.lesson39.controller;

import by.teachmeskills.lesson39.dto.PictureDto;
import by.teachmeskills.lesson39.service.PictureService;
import javax.validation.Valid;
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
    public ResponseEntity<List<PictureDto>> getAll() {
        return ResponseEntity.ok(pictureService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PictureDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pictureService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PictureDto> save(@Valid @RequestBody PictureDto pictureDto) {
        return ResponseEntity.ok(pictureService.save(pictureDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PictureDto> update(@PathVariable Long id, @Valid @RequestBody PictureDto pictureDto) {
        return ResponseEntity.ok(pictureService.update(id, pictureDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pictureService.delete(id);
        return ResponseEntity.ok().build();
    }
}
