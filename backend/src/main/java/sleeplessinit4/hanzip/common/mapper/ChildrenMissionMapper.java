package sleeplessinit4.hanzip.common.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.dto.ChildrenMissionDto;
import sleeplessinit4.hanzip.dto.ParentMissionDto;
import sleeplessinit4.hanzip.entity.ChildrenMissionEntity;
import sleeplessinit4.hanzip.entity.ParentMissionEntity;


public class ChildrenMissionMapper {

    public ChildrenMissionDto entityToDto(ChildrenMissionEntity childrenMission) {
        ChildrenMissionDto childrenMissionDto = ChildrenMissionDto.builder()
                .childrenMissionId(childrenMission.getChildrenMissionId())
                .missionTitle(childrenMission.getMissionTitle())
                .missionContent(childrenMission.getMissionContent())
                .missionLevel(childrenMission.getMissionLevel())
                .reward(childrenMission.getReward())
                .activityPoint(childrenMission.getActivityPoint())
                .communicationPoint(childrenMission.getCommunicationPoint())
                .isComplete(childrenMission.getIsComplete())
                .build();

        return childrenMissionDto;
    }
}
