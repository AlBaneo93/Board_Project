package edu.example.board_user.Web.VO;

import lombok.*;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Embeddable
public class Address {

  private String zipcode;

  private String address;

  private String address2;

}
