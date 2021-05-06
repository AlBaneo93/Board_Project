package edu.example.board_user;

public class ValidationTest {
//
//  @Test
//  public void emtpyTest() throws Exception {
//
//    ValidVO empty = new ValidVO();
//    empty.setEmpty("");
//
//    Set<?> violation = valid(empty);
//    Assertions.assertEquals(1, violation.size()); // pass
//    for (var vi : violation) {
//      System.out.println(vi);
//    }
//    System.out.println("\n");
//    empty.setEmpty(null);
//    violation = valid(empty);
//    Assertions.assertEquals(1, violation.size()); // fail
//    for (var vi : violation) {
//      System.out.println(vi);
//    }
//  }
//
//  @Test
//  public void blankTest() throws Exception {
//
//    ValidVO blank = new ValidVO();
//    blank.setBlank(" "); // blank String
//    Set<?> violation = valid(blank);
//    Assertions.assertEquals(1, violation.size()); // pass
//    for (var vi : violation) {
//      System.out.println(vi);
//    }
//    System.out.println("\n");
//    blank.setBlank("");// empty String
//    violation = valid(blank);
//    Assertions.assertEquals(1, violation.size()); // fail
//    for (var vi : violation) {
//      System.out.println(vi);
//    }
//  }
//
//  @Test
//  public void nullTest() throws Exception {
//
//    ValidVO nulls = new ValidVO();
//    nulls.setNulls(null);
//
//    Set<?> violation = valid(nulls);
//    Assertions.assertEquals(1, violation.size()); // pass
//    for (var vi : violation) {
//      System.out.println(vi);
//    }
//    System.out.println("\n");
//    nulls.setNulls(""); // empty String != null
//    violation = valid(nulls);
//    Assertions.assertEquals(1, violation.size()); // fail
//    for (var vi : violation) {
//      System.out.println(vi);
//    }
//  }
//
//  @Test
//  public void emailTest() throws Exception {
//    // email 형식이 맞는지 테스트
//
//    ValidVO email = new ValidVO();
//    email.setEmail("myEmail@gmail.com");
//
//    Set<?> violation = valid(email);
//    Assertions.assertEquals(1, violation.size()); // pass
//    for (var vi : violation) {
//      System.out.println(vi);
//    }
//    System.out.println("\n");
//    email.setEmail("myEmail");
//    violation = valid(email);
//    Assertions.assertEquals(1, violation.size()); // fail
//    for (var vi : violation) {
//      System.out.println(vi);
//    }
//
//  }
//
//  public Set<?> valid(ValidVO validVO) {
////    return validator.validate(validVO);
//    return Validation.buildDefaultValidatorFactory().getValidator().validate(validVO);
//  }
}
