package com.example.boot.service;

import com.example.boot.dto.PictureDto;

import java.util.List;

public interface PictureService {

    List<PictureDto> getAll();

    PictureDto getById(Long id);

    PictureDto save(PictureDto pictureDto);

    PictureDto update(Long id, PictureDto pictureDto);

    void delete(Long id);
}
