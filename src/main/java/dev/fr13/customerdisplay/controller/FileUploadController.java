package dev.fr13.customerdisplay.controller;

import dev.fr13.customerdisplay.exception.EmptyFileUploadingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Value("${upload.path}")
    private String uploadPath;

    @PostMapping
    public ResponseEntity<String> postFile(@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new EmptyFileUploadingException();
        } else {
            var uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            var fileName = uploadPath + File.separator +
                    UUID.randomUUID().toString() + "." + file.getOriginalFilename();
            file.transferTo(new File(fileName));
            logger.info("new file was saved {}", fileName);
            return ResponseEntity.ok(fileName);
        }
    }
}
