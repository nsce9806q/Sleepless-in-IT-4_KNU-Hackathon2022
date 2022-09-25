package sleeplessinit4.hanzip.entity;

import lombok.*;
import sleeplessinit4.hanzip.common.entity.BaseTimeEntity;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="children")
public class ChildrenEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childrenId;

    @Column(length = 20)
    private String loginId;

    private String password;

    @Column(length = 12)
    private String phoneNumber;

    @Column(length = 20)
    private String nickName;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "children")
    private HouseEntity house;

    @OneToMany(mappedBy = "children", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ChildrenMissionEntity> childrenMissionList;
}
