package com.example.boot.service.impl;

import com.example.boot.dto.PictureDto;
import com.example.boot.exception.PictureNotFoundException;
import com.example.boot.mapper.PictureMapper;
import com.example.boot.repository.PictureRepository;
import com.example.boot.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    private final PictureMapper pictureMapper;

    @Override
    public List<PictureDto> getAll() {
        return pictureRepository.findAll()
                .stream()
                .map(pictureMapper::toPictureDto)
                .toList();
    }

    @Override
    public PictureDto getById(Long id) {
        return pictureRepository.findById(id)
                .map(pictureMapper::toPictureDto)
                .orElseThrow(PictureNotFoundException::new);
    }

    @Override
    public PictureDto save(PictureDto pictureDto) {
        return pictureMapper.toPictureDto(pictureRepository.save(pictureMapper.toPicture(pictureDto)));
    }

    @Override
    public PictureDto update(Long id, PictureDto pictureDto) {
        if (!pictureRepository.existsById(id)) {
            throw new PictureNotFoundException();
        }
        pictureDto.setId(id);
        return pictureMapper.toPictureDto(pictureRepository.save(pictureMapper.toPicture(pictureDto)));
    }

    @Override
    public void delete(Long id) {
        if (!pictureRepository.existsById(id)) {
            throw new PictureNotFoundException();
        }
        pictureRepository.deleteById(id);
    }
}
