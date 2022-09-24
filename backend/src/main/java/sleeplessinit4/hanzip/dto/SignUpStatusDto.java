package sleeplessinit4.hanzip.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpStatusDto {
  private final Boolean status;

  public SignUpStatusDto(Boolean status) {
    this.status = status;
  }
}
