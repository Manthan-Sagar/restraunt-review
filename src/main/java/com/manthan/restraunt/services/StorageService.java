package com.manthan.restraunt.services;

import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String storeFile(MultipartFile file, String fileName);

    Optional<Resource> loadAsResource(String id);
}
