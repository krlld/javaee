package by.teachmeskills.lesson39.service;

import by.teachmeskills.lesson39.domain.Picture;

import java.util.List;

public interface PictureService {

    List<Picture> getAll();

    Picture getById(Long id);

    Picture save(Picture picture);

    Picture update(Long id, Picture picture);

    void delete(Long id);
}
