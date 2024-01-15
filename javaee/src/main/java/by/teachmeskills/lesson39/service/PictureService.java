package by.teachmeskills.lesson39.service;

import by.teachmeskills.lesson39.dto.PictureDto;
import by.teachmeskills.lesson39.entity.Picture;

import java.util.List;

public interface PictureService {

    List<PictureDto> getAll();

    PictureDto getById(Long id);

    PictureDto save(PictureDto pictureDto);

    PictureDto update(Long id, PictureDto pictureDto);

    void delete(Long id);

    PictureDto toPictureDto(Picture picture);

    Picture toPicture(PictureDto pictureDto);
}
