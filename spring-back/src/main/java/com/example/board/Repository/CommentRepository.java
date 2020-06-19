package com.example.board.Repository;

import com.example.board.DTO.CommentDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CommentRepository extends JpaRepository<CommentDTO, Long> {

    List<CommentDTO> findAllByBoardidOrderByCreatedatDescLevelDesc(long boardid);
}
