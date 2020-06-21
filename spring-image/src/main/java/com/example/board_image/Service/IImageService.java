package com.example.board_image.Service;

import com.example.board_image.Error.NotSupportedTypeException;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {

    void imageUpload(MultipartFile multipartFile, String folderName, String fileName)
        throws IOException, NotSupportedTypeException;
}
