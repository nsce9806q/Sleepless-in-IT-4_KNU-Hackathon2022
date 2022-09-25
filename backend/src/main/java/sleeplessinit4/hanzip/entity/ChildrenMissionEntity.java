package sleeplessinit4.hanzip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.entity.BaseTimeEntity;
import sleeplessinit4.hanzip.common.enums.IsComplete;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="children_mission")
public class ChildrenMissionEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childrenMissionId;

    @Column(length = 10)
    private Long missionLevel;

    @Column(length = 255)
    private String missionTitle;

    @Column(length = 255)
    private String missionContent;

    @Column(length = 10)
    private Long reward;

    @Column(length = 10)
    private Long activityPoint;

    @Column(length = 10)
    private Long communicationPoint;

    @Column
    @Builder.Default
    private Boolean isComplete = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="children_id")
    private ChildrenEntity children;

    public void missionComplete() {
        this.isComplete = Boolean.TRUE;
    }
}
