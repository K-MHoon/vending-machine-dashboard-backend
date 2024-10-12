package com.kmhoon.dashboard.utils;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Log4j2
@RequiredArgsConstructor
public class CustomFileUtil {

    @Value("${com.kmhoon.upload.path}")
    private String uploadPath;
    @PostConstruct
    public void init() {
        File tempFolder = new File(uploadPath);
        if(!tempFolder.exists()) {
            tempFolder.mkdir();
        }
        this.uploadPath = tempFolder.getAbsolutePath();

        log.info("-----------------------------------");
        log.info(this.uploadPath);
    }

    public List<String> saveFiles(List<MultipartFile> files) {
        if(files == null || files.isEmpty()) {
            return List.of();
        }

        List<String> uploadNames = new ArrayList<>();

        for (MultipartFile multipartFile : files) {

            String savedName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
            Path savePath = Paths.get(this.uploadPath, savedName);

            List<Path> uploadTargetPaths = new ArrayList<>();

            try {
                Files.copy(multipartFile.getInputStream(), savePath);

                uploadTargetPaths.add(savePath);

                String contentType = multipartFile.getContentType();
                if(contentType != null && contentType.startsWith("image")) {

                    Path thumbnailPath = Paths.get(uploadPath, "s_" + savedName);
                    Thumbnails.of(savePath.toFile())
                            .size(200, 200)
                            .toFile(thumbnailPath.toFile());

                    uploadTargetPaths.add(thumbnailPath);
                }
                uploadNames.add(savedName);

            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return uploadNames;
    }

    public ResponseEntity<Resource> getFile(String fileName) {
        FileSystemResource resource = new FileSystemResource(this.uploadPath + File.separator + fileName);

        if(!resource.isReadable()) {
            resource = new FileSystemResource(this.uploadPath + File.separator + "default.png");
        }

        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok().headers(headers).body(resource);
    }

    public void deleteFiles(List<String> fileNames) {

        if(fileNames == null || fileNames.isEmpty()) {
            return;
        }

        fileNames.forEach(fileName -> {

            String thumbnailFileName = "s_" + fileName;
            Path thumbnailPath = Paths.get(this.uploadPath, thumbnailFileName);
            Path filePath = Paths.get(this.uploadPath, fileName);

            List<Path> deleteTargetPaths = new ArrayList<>();

            try {
                Files.deleteIfExists(filePath);
                Files.deleteIfExists(thumbnailPath);

                deleteTargetPaths.add(filePath);
                deleteTargetPaths.add(thumbnailPath);

            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}
