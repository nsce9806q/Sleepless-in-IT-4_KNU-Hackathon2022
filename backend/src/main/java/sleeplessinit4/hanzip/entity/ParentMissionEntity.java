package sleeplessinit4.hanzip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.BaseTimeEntity;
import sleeplessinit4.hanzip.common.IsComplete;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParentMissionEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentMissionId;

    @Column
    private Long missionLevel;

    @Column
    private String missionTitle;

    @Column
    private String missionContent;

    @Column
    @Enumerated(EnumType.STRING)
    private IsComplete isComplete = IsComplete.ImComplete;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private ChildrenEntity parent;
}
