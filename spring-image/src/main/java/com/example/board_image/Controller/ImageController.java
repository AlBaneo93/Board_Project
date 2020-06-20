package com.example.board_image.Controller;

import com.example.board_image.Service.IImageService;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImageController {

    private final IImageService service;

    public ImageController(IImageService service) {
        this.service = service;
    }

    @PostMapping("/image")
//    image라는 이름으로 서블릿에서 데이터를 가져온다
    public void imageUpload(@PathParam("image") MultipartFile multipartFile) {

    }
}
