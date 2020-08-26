package com.example.board.DTO;

import com.example.board.Role.MemberRole;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "member")
@EqualsAndHashCode(of = "email")
public class MemberDTO {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(length = 30, unique = true, nullable = false)
  private String email;

  @Column(length = 30, nullable = false)
  private String name;

  @Column(length = 150)
  private String password;

  @Column(length = 200)
  private String accessToken;

  @Column(length = 200)
  private String refreshToken;

  @CreationTimestamp private Date regdate;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "email")
  private List<MemberRole> roles;
}
