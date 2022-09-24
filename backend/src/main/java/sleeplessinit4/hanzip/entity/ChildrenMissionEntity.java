package sleeplessinit4.hanzip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.BaseTimeEntity;
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

    @Column(length = 2)
    private Long missionLevel;

    @Column(length = 20)
    private String missionTitle;

    @Column(length = 200)
    private String missionContent;

    @Column(length = 10)
    private Long reward;

    @Column
    @Enumerated(EnumType.STRING)
    private IsComplete isComplete = IsComplete.ImComplete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="children_id")
    private ChildrenEntity children;

}
