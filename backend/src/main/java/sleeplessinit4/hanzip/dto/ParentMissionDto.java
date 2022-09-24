package sleeplessinit4.hanzip.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.enums.IsComplete;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParentMissionDto {

    private Long parentMissionId;
    private Long missionLevel;
    private String missionTitle;
    private String missionContent;
    private Long reward;
    private IsComplete isComplete;
}
