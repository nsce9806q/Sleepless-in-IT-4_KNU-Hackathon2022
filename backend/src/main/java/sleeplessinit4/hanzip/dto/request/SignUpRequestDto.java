package sleeplessinit4.hanzip.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

public class SignUpRequestDto {

  @Getter
  @AllArgsConstructor
  public static class Parent {
    private String loginId;

    private String password;

    private String houseName;

    private String childName;
  }

  @Getter
  @AllArgsConstructor
  public static class Child {
    private String loginId;

    private String password;

    private String randomCode;
  }
}
