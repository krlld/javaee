package by.teachmeskills.lesson39.service.impl;

import by.teachmeskills.lesson39.dao.PictureDao;
import by.teachmeskills.lesson39.domain.Picture;
import by.teachmeskills.lesson39.exception.PictureNotFoundException;
import by.teachmeskills.lesson39.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureDao pictureDao;

    @Override
    public List<Picture> getAll() {
        return pictureDao.getAll();
    }

    @Override
    public Picture getById(Long id) {
        return pictureDao.getById(id).orElseThrow(PictureNotFoundException::new);
    }

    @Override
    public Picture save(Picture picture) {
        return pictureDao.save(picture);
    }

    @Override
    public Picture update(Long id, Picture picture) {
        if (!pictureDao.existsById(id)) {
            throw new PictureNotFoundException();
        }
        picture.setId(id);
        return pictureDao.update(picture);
    }

    @Override
    public void delete(Long id) {
        if (!pictureDao.existsById(id)) {
            throw new PictureNotFoundException();
        }
        pictureDao.delete(id);
    }
}
