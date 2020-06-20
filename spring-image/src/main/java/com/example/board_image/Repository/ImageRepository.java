package com.example.board_image.Repository;

import com.example.board_image.DTO.ImageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageDTO, Long> {

}
