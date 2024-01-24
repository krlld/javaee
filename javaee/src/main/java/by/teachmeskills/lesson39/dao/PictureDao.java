package by.teachmeskills.lesson39.dao;

import by.teachmeskills.lesson39.entity.Picture;

import java.util.List;
import java.util.Optional;

public interface PictureDao {

    List<Picture> getAll();

    Optional<Picture> getById(Long id);

    Picture save(Picture picture);

    Picture update(Picture picture);

    void delete(Long id);

    boolean existsById(Long id);
}
