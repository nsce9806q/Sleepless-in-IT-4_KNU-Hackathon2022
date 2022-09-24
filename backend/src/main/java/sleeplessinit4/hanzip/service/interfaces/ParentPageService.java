package sleeplessinit4.hanzip.service.interfaces;

import sleeplessinit4.hanzip.dto.ChildrenMissionDto;
import sleeplessinit4.hanzip.dto.ParentMissionDto;

import java.util.List;

public interface ParentPageService {

    List<ParentMissionDto> viewParentMission (Long parentId);
    List<ParentMissionDto> clearMission (Long parentId, Long missionId);
}
