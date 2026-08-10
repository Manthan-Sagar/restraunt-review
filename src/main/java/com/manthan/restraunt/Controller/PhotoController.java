package com.manthan.restraunt.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.manthan.restraunt.domain.dtos.PhotoDto;
import com.manthan.restraunt.domain.entities.Photo;
import com.manthan.restraunt.mappers.PhotoMapper;
import com.manthan.restraunt.services.PhotoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/photos")
public class PhotoController {
    private final PhotoService photoService;
    private final PhotoMapper photoMapper;
    
    public PhotoDto uploadPhoto(@RequestParam("file") MultipartFile file){
        Photo savedPhoto    = photoService.uploadPhoto(file);
        return photoMapper.toDto(savedPhoto);
        
    }
}
