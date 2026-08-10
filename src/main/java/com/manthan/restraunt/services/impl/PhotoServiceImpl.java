package com.manthan.restraunt.services.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.manthan.restraunt.domain.entities.Photo;
import com.manthan.restraunt.services.PhotoService;
import com.manthan.restraunt.services.StorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final StorageService storageService;
    
    @Override
    public Photo uploadPhoto(MultipartFile file) {
       String photoId = UUID.randomUUID().toString();
       String url = storageService.storeFile(file,photoId);
       return Photo.builder()
                .url(url)
                .uploadDate(LocalDateTime.now())
                .build();

    }

    @Override
    public Optional<Resource> getPhotoAsResource(String id) {
        return storageService.loadAsResource(id);
        
    }
    
}
