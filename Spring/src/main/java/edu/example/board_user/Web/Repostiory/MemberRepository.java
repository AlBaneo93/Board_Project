package edu.example.board_user.Web.Repostiory;

import edu.example.board_user.Web.VO.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByEmail(String username);

}
