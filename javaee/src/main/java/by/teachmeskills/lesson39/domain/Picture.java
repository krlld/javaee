package by.teachmeskills.lesson39.domain;

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

    private String name;

    private String description;

    private String url;

    public Picture(Picture picture) {
        this.id = picture.id;
        this.name = picture.name;
        this.description = picture.description;
        this.url = picture.url;
    }
}
