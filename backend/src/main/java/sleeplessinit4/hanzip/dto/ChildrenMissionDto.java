package sleeplessinit4.hanzip.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.enums.IsComplete;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChildrenMissionDto {

    private Long childrenMissionId;
    private Long missionLevel;
    private String missionTitle;
    private String missionContent;
    private Long reward;
    private Boolean isComplete;
}
