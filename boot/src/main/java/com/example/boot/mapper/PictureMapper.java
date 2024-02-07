package com.example.boot.mapper;

import com.example.boot.domain.Picture;
import com.example.boot.dto.PictureDto;
import org.mapstruct.Mapper;

@Mapper
public interface PictureMapper {

    PictureDto toPictureDto(Picture picture);

    Picture toPicture(PictureDto pictureDto);
}
