package sleeplessinit4.hanzip.controller;

import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sleeplessinit4.hanzip.common.exception.HouseNotFoundException;
import sleeplessinit4.hanzip.dto.HouseDto;
import sleeplessinit4.hanzip.service.MainPageServiceImpl;
import sleeplessinit4.hanzip.service.interfaces.MainPageService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MainPageController {

  private final MainPageService mainPageService;

  @GetMapping("/{houseId}")
  public ResponseEntity<HouseDto> viewMain(@PathVariable Long houseId) {
    try {
      HouseDto houseDto = mainPageService.viewMain(houseId);
      return new ResponseEntity<>(houseDto, HttpStatus.OK);
    }catch(HouseNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

}
