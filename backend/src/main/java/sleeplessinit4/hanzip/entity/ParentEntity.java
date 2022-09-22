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
public class ParentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parentId;

    @Column
    private String loginId;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @OneToOne(mappedBy = "parent")
    private HouseEntity house;

    @OneToMany(mappedBy = "parent")
    private List<ParentMissionEntity> parentMissionList;
}
