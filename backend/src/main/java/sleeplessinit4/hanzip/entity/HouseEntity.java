package sleeplessinit4.hanzip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.BaseTimeEntity;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HouseEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseId;

    @Column
    private String houseName;

    //경험치 column
    @Column
    private Long Exp;

    @OneToOne
    @JoinColumn(name="furniture_id")
    private FurnitureEntity furniture;

    @OneToOne
    @JoinColumn(name="parent_id")
    private ParentEntity parent;

    @OneToOne
    @JoinColumn(name="children_id")
    private ChildrenEntity children;

    @OneToMany(mappedBy = "house")
    private List<ActivityEntity> activityList;
}
