package com.example.boot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Picture data")
public class PictureDto {

    @Schema(description = "Picture id", accessMode = Schema.AccessMode.READ_ONLY, example = "1")
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Picture name", example = "Winter forest")
    private String name;

    @NotBlank
    @Size(max = 255)
    @Schema(description = "Picture description", example = "Trees covered with snow")
    private String description;

    @JsonIgnore
    private byte[] pictureFile;
}
