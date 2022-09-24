package sleeplessinit4.hanzip.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sleeplessinit4.hanzip.common.exception.ChildrenMissionNotFoundException;
import sleeplessinit4.hanzip.dto.ChildrenMissionDto;
import sleeplessinit4.hanzip.service.interfaces.ChildrenPageService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/children")
public class ChildrenPageController {

    private final ChildrenPageService childrenPageService;

    @ApiOperation(
            value = "자식 페이지 조회"
            , notes = "childrenId를 통해 자식 페이지를 조회한다.")
    @ApiImplicitParam(
            name = "childrenId"
            , value = "자녀 아이디"
            , dataType = "Long"
            , paramType = "path")
    @GetMapping("/{childrenId}")
    public ResponseEntity<List<ChildrenMissionDto>> viewChildrenMission(@PathVariable Long childrenId) {
        List<ChildrenMissionDto> childrenMissionDtoList = childrenPageService.viewChildrenMission(childrenId);

        return new ResponseEntity<>(childrenMissionDtoList, HttpStatus.OK);
    }

    @ApiOperation(
            value = "자식 페이지 미션 성공"
            , notes = "자식 페이지에서 미션을 체크한다")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "childrenId"
                            , value = "자녀 아이디"
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
    public ResponseEntity<List<ChildrenMissionDto>> clearMission(@RequestParam Long childrenId, @RequestParam Long missionId) {
        try {
            List<ChildrenMissionDto> childrenMissionDtoList = childrenPageService.clearMission(childrenId, missionId);

            return new ResponseEntity<>(childrenMissionDtoList, HttpStatus.OK);
        }catch (ChildrenMissionNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }



    }
}
