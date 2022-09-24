package sleeplessinit4.hanzip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.entity.BaseTimeEntity;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="parent")
public class ParentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentId;

    @Column(length = 20)
    private String loginId;

    @Column(length = 20)
    private String password;

    @Column(length = 12)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "parent")
    private HouseEntity house;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ParentMissionEntity> parentMissionList;
}
