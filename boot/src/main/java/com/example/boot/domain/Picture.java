package com.example.boot.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Picture {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String description;

    private byte[] pictureFile;

    public Picture(Picture picture) {
        this.id = picture.id;
        this.name = picture.name;
        this.description = picture.description;
        this.pictureFile = picture.pictureFile;
    }
}
