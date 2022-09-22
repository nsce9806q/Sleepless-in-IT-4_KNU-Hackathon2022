package sleeplessinit4.hanzip.entity;

import lombok.*;
import sleeplessinit4.hanzip.common.BaseTimeEntity;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChildrenEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long childrenId;

    @Column
    private String loginId;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @OneToOne(mappedBy = "children")
    private HouseEntity house;

    @OneToMany(mappedBy = "children")
    private List<ChildrenMissionEntity> childrenMissionList;
}
