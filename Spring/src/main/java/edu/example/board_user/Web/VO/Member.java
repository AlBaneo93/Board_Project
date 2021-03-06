package edu.example.board_user.Web.VO;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
@Entity
public class Member implements UserDetails, Serializable {


  private static final long serialVersionUID = 8876414256896734500L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String email;

  @NotBlank
  private String password;

  private Boolean enabled;

  private Date createdAt;

  @Column(name = "access")
  private String access_token;

  @Column(name = "refresh")
  private String refresh_token;

  @Embedded
  @Column(name = "address")
  private Address address;

  @NotBlank
  @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
  @Column(name = "role")
  private Set<Role> authorities = new HashSet<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.name())).collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @PrePersist
  public void setCreateAt() {
    this.createdAt = Calendar.getInstance().getTime();
  }

}
