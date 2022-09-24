package sleeplessinit4.hanzip.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPageController {

  @GetMapping("/")
  public ResponseEntity<Map<String,Object>> root(){
    Map<String,Object> response = new HashMap<>();
    response.put("hello","world");

    return ResponseEntity.ok().body(response);
  }
}
