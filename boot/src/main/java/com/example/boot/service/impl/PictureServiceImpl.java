package com.example.boot.service.impl;

import com.example.boot.dao.PictureDao;
import com.example.boot.dto.PictureDto;
import com.example.boot.exception.PictureNotFoundException;
import com.example.boot.mapper.PictureMapper;
import com.example.boot.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureDao pictureDao;

    private final PictureMapper pictureMapper;

    @Override
    public List<PictureDto> getAll() {
        return pictureDao.getAll()
                .stream()
                .map(pictureMapper::toPictureDto)
                .toList();
    }

    @Override
    public PictureDto getById(Long id) {
        return pictureDao.getById(id)
                .map(pictureMapper::toPictureDto)
                .orElseThrow(PictureNotFoundException::new);
    }

    @Override
    public PictureDto save(PictureDto pictureDto) {
        return pictureMapper.toPictureDto(pictureDao.save(pictureMapper.toPicture(pictureDto)));
    }

    @Override
    public PictureDto update(Long id, PictureDto pictureDto) {
        if (!pictureDao.existsById(id)) {
            throw new PictureNotFoundException();
        }
        pictureDto.setId(id);
        return pictureMapper.toPictureDto(pictureDao.update(pictureMapper.toPicture(pictureDto)));
    }

    @Override
    public void delete(Long id) {
        if (!pictureDao.existsById(id)) {
            throw new PictureNotFoundException();
        }
        pictureDao.delete(id);
    }
}
