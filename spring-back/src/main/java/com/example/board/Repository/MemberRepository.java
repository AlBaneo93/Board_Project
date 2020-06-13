package com.example.board.Repository;

import com.example.board.DTO.MemberDTO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MemberRepository extends JpaRepository<MemberDTO, Long> {

    Optional<MemberDTO> findByEmailAndPassword(String email, String password);
}
