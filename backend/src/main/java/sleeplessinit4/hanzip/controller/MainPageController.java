package sleeplessinit4.hanzip.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {
  @GetMapping("/")
  public ResponseEntity<String> root(){
    return ResponseEntity.ok().body("hello world");
  }
}
