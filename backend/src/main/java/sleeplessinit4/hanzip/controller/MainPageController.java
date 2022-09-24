package sleeplessinit4.hanzip.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(
            value = "메인 페이지 조회"
            , notes = "houseId를 통해 메인 페이지(집)를 조회한다.")
    @ApiImplicitParam(
            name = "houseId"
            , value = "집 아이디"
            , dataType = "Long"
            , paramType = "path")
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
