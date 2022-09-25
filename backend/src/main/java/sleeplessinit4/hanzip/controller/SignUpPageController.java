package sleeplessinit4.hanzip.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sleeplessinit4.hanzip.dto.SignUpStatusDto;
import sleeplessinit4.hanzip.dto.request.SignUpRequestDto;
import sleeplessinit4.hanzip.service.SignUpPageServiceImpl;

@RequiredArgsConstructor
@RestController
@RequestMapping("/signup")
public class SignUpPageController {

  private final SignUpPageServiceImpl signUpPageService;

  @PostMapping("/parent")
  public ResponseEntity<SignUpStatusDto> signUpParent(SignUpRequestDto.Parent request){
    SignUpStatusDto status = signUpPageService.parentSignUp(request);

    return ResponseEntity.ok().body(status);
  }

  @PostMapping("/children")
  public ResponseEntity<SignUpStatusDto> signUpChildren(SignUpRequestDto.Child request){
    SignUpStatusDto status = signUpPageService.childSignUp(request);

    return ResponseEntity.ok().body(status);
  }
}
