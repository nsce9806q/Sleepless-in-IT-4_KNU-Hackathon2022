package sleeplessinit4.hanzip.service.interfaces;

import sleeplessinit4.hanzip.dto.ChildrenMissionDto;
import sleeplessinit4.hanzip.dto.ParentMissionDto;
import sleeplessinit4.hanzip.entity.ChildrenEntity;
import sleeplessinit4.hanzip.entity.ChildrenMissionEntity;
import sleeplessinit4.hanzip.entity.ParentEntity;
import sleeplessinit4.hanzip.entity.ParentMissionEntity;

import java.util.List;

public interface MissionService {

    void makeChildrenMission(ChildrenEntity childrenEntity);
    void makeParentMission(ParentEntity parentEntity);
    List<ParentMissionDto> pickParentMission (List<ParentMissionEntity> parentMissionEntityList);
    List<ChildrenMissionDto> pickChildrenMission (List<ChildrenMissionEntity> childrenMissionEntityList);
}
