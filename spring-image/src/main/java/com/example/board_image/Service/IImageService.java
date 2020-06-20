package com.example.board_image.Service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {

    void imageUpload(MultipartFile multipartFile) throws IOException;
}
