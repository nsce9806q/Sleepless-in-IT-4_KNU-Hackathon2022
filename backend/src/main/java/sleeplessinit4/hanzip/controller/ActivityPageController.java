package sleeplessinit4.hanzip.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sleeplessinit4.hanzip.dto.ActivityDto;
import sleeplessinit4.hanzip.service.interfaces.ActivityPageService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/activity")
public class ActivityPageController {

    private final ActivityPageService activityPageService;

    @GetMapping
    public ResponseEntity<List<ActivityDto>> viewActivityList(@RequestParam Long houseId) {
        List<ActivityDto> activityDtoList = activityPageService.viewActivityList(houseId);

        return new ResponseEntity<>(activityDtoList, HttpStatus.OK);
    }
}
