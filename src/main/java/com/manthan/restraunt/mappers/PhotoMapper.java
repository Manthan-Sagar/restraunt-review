package com.manthan.restraunt.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.manthan.restraunt.domain.dtos.PhotoDto;
import com.manthan.restraunt.domain.entities.Photo;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);


}
