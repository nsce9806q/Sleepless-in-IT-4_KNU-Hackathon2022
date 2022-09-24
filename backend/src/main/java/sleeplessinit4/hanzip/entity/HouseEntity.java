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
@Entity(name="house")
public class HouseEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseId;

    @Column(length = 20)
    private String houseName;

    //경험치 column
    @Column(length = 200)
    private Long Exp;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "house", fetch = FetchType.LAZY)
    private ParentEntity parent;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "house", fetch = FetchType.LAZY)
    private ChildrenEntity children;

    @OneToOne(mappedBy = "house", fetch = FetchType.LAZY)
    private FurnitureEntity furniture;

    @OneToMany(mappedBy = "house", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ActivityEntity> activityList;
}
