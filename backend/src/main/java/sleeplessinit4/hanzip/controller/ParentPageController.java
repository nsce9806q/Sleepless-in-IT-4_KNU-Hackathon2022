package sleeplessinit4.hanzip.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sleeplessinit4.hanzip.dto.ChildrenMissionDto;
import sleeplessinit4.hanzip.dto.ParentMissionDto;
import sleeplessinit4.hanzip.service.interfaces.ChildrenPageService;
import sleeplessinit4.hanzip.service.interfaces.ParentPageService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parent")
public class ParentPageController {

    private final ParentPageService parentPageService;

    @GetMapping("/{parentId}")
    public ResponseEntity<List<ParentMissionDto>> viewChildrenMission(@PathVariable Long parentId) {
        List<ParentMissionDto> parentMissionDtoList = parentPageService.viewParentMission(parentId);

        return new ResponseEntity<>(parentMissionDtoList, HttpStatus.OK);
    }

    @GetMapping("/mission")
    public ResponseEntity<List<ParentMissionDto>> clearMission(@RequestParam Long parentId, @RequestParam Long missionId) {
        List<ParentMissionDto> parentMissionDtoList = parentPageService.clearMission(parentId, missionId);

        return new ResponseEntity<>(parentMissionDtoList, HttpStatus.OK);
    }
}
