package sleeplessinit4.hanzip.common.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.dto.ParentMissionDto;
import sleeplessinit4.hanzip.entity.ParentMissionEntity;

public class ParentMissionMapper {

    public ParentMissionDto entityToDto(ParentMissionEntity parentMission) {
        ParentMissionDto parentMissionDto = ParentMissionDto.builder()
                .parentMissionId(parentMission.getParentMissionId())
                .missionTitle(parentMission.getMissionTitle())
                .missionContent(parentMission.getMissionContent())
                .missionLevel(parentMission.getMissionLevel())
                .reward(parentMission.getReward())
                .activityPoint(parentMission.getActivityPoint())
                .communicationPoint(parentMission.getCommunicationPoint())
                .isComplete(parentMission.getIsComplete())
                .build();

        return parentMissionDto;
    }
}
