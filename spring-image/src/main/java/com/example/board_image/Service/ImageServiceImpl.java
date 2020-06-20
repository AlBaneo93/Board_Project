package com.example.board_image.Service;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class ImageServiceImpl implements IImageService {

    @Value("${local.image.base}")
    private String imageUploadPath;

    @Override
    public void imageUpload(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();

        multipartFile.transferTo(new File(imageUploadPath + "/" + fileName));


    }
}
