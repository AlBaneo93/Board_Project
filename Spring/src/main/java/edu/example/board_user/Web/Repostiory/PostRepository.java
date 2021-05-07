package edu.example.board_user.Web.Repostiory;

import edu.example.board_user.Web.VO.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface PostRepository extends JpaRepository<Post, Long> {

}
