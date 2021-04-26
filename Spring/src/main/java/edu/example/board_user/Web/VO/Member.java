package edu.example.board_user.Web.VO;

import java.util.Calendar;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
@Entity
public class Member implements UserDetails, Serializable {

  private static final long serialVersionUID = -4855890427225819382L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;

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

  @ElementCollection(fetch = FetchType.LAZY, targetClass = Role.class)
  @Column(name = "role")
  private Set<Role> roles = new HashSet<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
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
  public void setCreateAt(){
    this.createdAt = Calendar.getInstance().getTime();
  }
}
