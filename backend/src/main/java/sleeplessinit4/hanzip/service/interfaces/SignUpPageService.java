package sleeplessinit4.hanzip.service.interfaces;

import sleeplessinit4.hanzip.dto.SignUpStatusDto;
import sleeplessinit4.hanzip.dto.request.SignUpRequestDto;

public interface SignUpPageService {

  SignUpStatusDto parentSignUp(SignUpRequestDto.Parent request);

  SignUpStatusDto childSignUp(SignUpRequestDto.Child request);
}
