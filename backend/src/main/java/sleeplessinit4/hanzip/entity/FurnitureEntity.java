package sleeplessinit4.hanzip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.entity.BaseTimeEntity;
import sleeplessinit4.hanzip.common.enums.isExist;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="furniture")
public class FurnitureEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long furnitureId;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private isExist glassWindow = isExist.NonExistent;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private isExist kitchenTable = isExist.NonExistent;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private isExist tv = isExist.NonExistent;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private isExist sofa = isExist.NonExistent;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private isExist photoFrame = isExist.NonExistent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house_id")
    private HouseEntity house;

}
