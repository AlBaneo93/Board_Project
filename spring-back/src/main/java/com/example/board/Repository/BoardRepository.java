package com.example.board.Repository;

import com.example.board.DTO.BoardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BoardRepository extends JpaRepository<BoardDTO, Long> {

}