package by.teachmeskills.lesson39.service.impl;

import by.teachmeskills.lesson39.dao.PictureDao;
import by.teachmeskills.lesson39.dto.PictureDto;
import by.teachmeskills.lesson39.entity.Picture;
import by.teachmeskills.lesson39.exception.PictureNotFoundException;
import by.teachmeskills.lesson39.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureDao pictureDao;

    @Autowired
    public PictureServiceImpl(@Qualifier("jpaPictureDao") PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PictureDto> getAll() {
        return pictureDao.getAll()
                .stream()
                .map(this::toPictureDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PictureDto getById(Long id) {
        return pictureDao.getById(id)
                .map(this::toPictureDto)
                .orElseThrow(PictureNotFoundException::new);
    }

    @Override
    @Transactional
    public PictureDto save(PictureDto pictureDto) {
        return toPictureDto(pictureDao.save(toPicture(pictureDto)));
    }

    @Override
    @Transactional
    public PictureDto update(Long id, PictureDto pictureDto) {
        if (!pictureDao.existsById(id)) {
            throw new PictureNotFoundException();
        }
        pictureDto.setId(id);
        return toPictureDto(pictureDao.update(toPicture(pictureDto)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!pictureDao.existsById(id)) {
            throw new PictureNotFoundException();
        }
        pictureDao.delete(id);
    }

    @Override
    public PictureDto toPictureDto(Picture picture) {
        return new PictureDto()
                .setId(picture.getId())
                .setName(picture.getName())
                .setDescription(picture.getDescription())
                .setUrl(picture.getUrl());
    }

    @Override
    public Picture toPicture(PictureDto pictureDto) {
        return new Picture()
                .setId(pictureDto.getId())
                .setName(pictureDto.getName())
                .setDescription(pictureDto.getDescription())
                .setUrl(pictureDto.getUrl());
    }
}
