package com.example.board_image.Service;

import com.example.board_image.Error.NotSupportedTypeException;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements IImageService {

    @Value("${local.image.base}")
    private String imageUploadPath;

    @Override
    public void imageUpload(MultipartFile multipartFile, String folderName, String fileName)
        throws IOException, NotSupportedTypeException {
        if (!multipartFile.isEmpty()) {

            if (!multipartFile.getContentType().split("/")[0].equals("image")) {
                throw new NotSupportedTypeException("Not Supported Type");
            }

            multipartFile
                .transferTo(new File(
                    imageUploadPath + folderName + "/" + fileName + "." + multipartFile
                        .getContentType().split("/")[1]));

        }
    }
}
