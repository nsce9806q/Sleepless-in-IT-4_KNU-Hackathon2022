package sleeplessinit4.hanzip.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sleeplessinit4.hanzip.dto.ChildrenMissionDto;
import sleeplessinit4.hanzip.service.interfaces.ChildrenPageService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/children")
public class ChildrenPageController {

    private final ChildrenPageService childrenPageService;

    @GetMapping("/{childrenId}")
    public ResponseEntity<List<ChildrenMissionDto>> viewChildrenMission(@PathVariable Long childrenId) {
        List<ChildrenMissionDto> childrenMissionDtoList = childrenPageService.viewChildrenMission(childrenId);

        return new ResponseEntity<>(childrenMissionDtoList, HttpStatus.OK);
    }

    @GetMapping("/mission")
    public ResponseEntity<List<ChildrenMissionDto>> clearMission(@RequestParam Long childrenId, @RequestParam Long missionId) {
        List<ChildrenMissionDto> childrenMissionDtoList = childrenPageService.clearMission(childrenId, missionId);

        return new ResponseEntity<>(childrenMissionDtoList, HttpStatus.OK);
    }
}
