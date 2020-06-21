package com.example.board_image.Controller;

import com.example.board_image.Error.NotSupportedTypeException;
import com.example.board_image.Service.IImageService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImageController {

    private final IImageService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ImageController(IImageService service) {
        this.service = service;
    }

    @PostMapping("/profile")
    public ResponseEntity<Map<String, Object>> profileUpload(
        @RequestParam("profile") MultipartFile multipartFile,
        @RequestParam("filename") String name) {
        Map<String, Object> map = new HashMap<>();
        try {
            service.imageUpload(multipartFile, "profile", name);
            map.put("msg", true);
        } catch (IOException | NotSupportedTypeException e) {
            e.printStackTrace();
            logger.error("image upload error");
            map.put("msg", false);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/thumbnail")
    public ResponseEntity<Map<String, Object>> thumbnailUpload(
        @RequestParam("thumbnail") MultipartFile multipartFile,
        @RequestParam("filename") String fileName) {
        Map<String, Object> map = new HashMap<>();
        try {
            service.imageUpload(multipartFile, "thumbnail", fileName);
            map.put("msg", true);
        } catch (IOException | NotSupportedTypeException e) {
            e.printStackTrace();
            logger.error("image upload error");
            map.put("msg", false);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
