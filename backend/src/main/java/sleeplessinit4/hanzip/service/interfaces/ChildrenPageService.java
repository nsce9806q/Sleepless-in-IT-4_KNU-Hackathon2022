package sleeplessinit4.hanzip.service.interfaces;

import sleeplessinit4.hanzip.dto.ChildrenMissionDto;

import java.util.List;

public interface ChildrenPageService {

    List<ChildrenMissionDto> viewChildrenMission (Long childrenId);
    List<ChildrenMissionDto> clearMission (Long childrenId, Long missionId);
}
