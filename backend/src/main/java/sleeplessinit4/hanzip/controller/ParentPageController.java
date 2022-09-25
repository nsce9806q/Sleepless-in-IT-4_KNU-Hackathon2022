package sleeplessinit4.hanzip.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sleeplessinit4.hanzip.common.exception.ParentMissionNotFoundException;
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

    @ApiOperation(
            value = "부모 페이지 조회"
            , notes = "parentId를 통해 자식 페이지를 조회한다.")
    @ApiImplicitParam(
            name = "parentId"
            , value = "부모 아이디"
            , dataType = "Long"
            , paramType = "path")
    @GetMapping("/{parentId}")
    public ResponseEntity<List<ParentMissionDto>> viewParentMission(@PathVariable Long parentId) {
        List<ParentMissionDto> parentMissionDtoList = parentPageService.viewParentMission(parentId);

        return new ResponseEntity<>(parentMissionDtoList, HttpStatus.OK);
    }

    @ApiOperation(
            value = "부모 페이지 미션 성공"
            , notes = "부모 페이지에서 미션을 체크한다")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "parentId"
                            , value = "부모 아이디"
                            , dataType = "Long"
                            , paramType = "query"
                    )
                    ,
                    @ApiImplicitParam(
                            name = "missionId"
                            , value = "체크한 미션 이름"
                            , dataType = "Long"
                            , paramType = "query"
                    )
            })
    @GetMapping("/mission")
    public ResponseEntity<List<ParentMissionDto>> clearMission(@RequestParam Long parentId, @RequestParam Long missionId) {
        try {
            List<ParentMissionDto> parentMissionDtoList = parentPageService.clearMission(parentId, missionId);

            return new ResponseEntity<>(parentMissionDtoList, HttpStatus.OK);
        }catch (ParentMissionNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
