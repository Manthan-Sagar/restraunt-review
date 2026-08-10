package com.manthan.restraunt.services.impl;

import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.manthan.restraunt.Exceptions.StorageException;
import com.manthan.restraunt.services.StorageService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class FileSystemStorageService implements StorageService{
    @Value("${app.storage.location:uploads}")
    private String storageLocation;

    private Path rootLocation;


    public void init(){
        rootLocation = Paths.get(storageLocation);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("could not initialize storage",e);
        }
    }


    @Override
    public String storeFile(MultipartFile file, String fileName) {
        try {
            if(file.isEmpty()){
                throw new StorageException("File is empty");
            }
            String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            String finalName = fileName + "." + extension;

            Path destinationFile = rootLocation.resolve(Paths.get(finalName)).normalize().toAbsolutePath();

            if (!destinationFile.getParent().equals(rootLocation.toAbsolutePath())) {
                throw new StorageException("Cannot store file outside specified directory");
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            return finalName;
        } catch (IOException e) {
            throw new StorageException("Failed to store file", e);
        }
    }

    @Override
    public Optional<Resource> loadAsResource(String id) {
        try {
            Path file = rootLocation.resolve(id).normalize().toAbsolutePath();
            
            // Prevent Path Traversal attacks
            if (!file.startsWith(rootLocation.toAbsolutePath())) {
                log.warn("Directory traversal attempt blocked: " + id);
                return Optional.empty();
            }

            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() && resource.isReadable()) {
                return Optional.of(resource);
            } else {
                return Optional.empty();
            }
        } catch (MalformedURLException e) {
            log.warn("Could not read file: " + id, e);
            return Optional.empty();
        }    
    }
    
}
