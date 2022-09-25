package sleeplessinit4.hanzip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Parent;
import sleeplessinit4.hanzip.common.entity.BaseTimeEntity;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="house")
public class HouseEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseId;

    @Column(length = 20)
    private String houseName;

    //경험치 column
    @Column(length = 200)
    @Builder.Default
    private Long exp = 0L;

    @Column(length = 10)
    @Builder.Default
    private Long activityPoint = 0L;

    @Column(length = 10)
    @Builder.Default
    private Long communicationPoint = 0L;

    @Column(length = 10)
    private String randomCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private ParentEntity parent;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="children_id")
    private ChildrenEntity children;

    @OneToOne(mappedBy = "house", fetch = FetchType.LAZY)
    private FurnitureEntity furniture;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ActivityEntity> activityList;

    public void increaseExp(Long reward) {
        this.exp += reward;
    }
    public void increaseActivityPoint(Long activityPoint) {
        this.activityPoint += activityPoint;
    }
    public void increaseCommunicationPoint(Long communicationPoint) {
        this.communicationPoint += communicationPoint;
    }

    public void clearParentMission(ParentMissionEntity parentMission) {
        increaseExp(parentMission.getReward());
        increaseActivityPoint(parentMission.getActivityPoint());
        increaseCommunicationPoint(parentMission.getCommunicationPoint());
    }

    public void clearChildrenMission(ChildrenMissionEntity childrenMission) {
        increaseExp(childrenMission.getReward());
        increaseActivityPoint(childrenMission.getActivityPoint());
        increaseCommunicationPoint(childrenMission.getCommunicationPoint());
    }
}
