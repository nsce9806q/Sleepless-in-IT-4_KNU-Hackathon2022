package sleeplessinit4.hanzip.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sleeplessinit4.hanzip.common.BaseTimeEntity;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FurnitureEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long furnitureId;

    @Column
    private Boolean window = false;

    @Column
    private Boolean table = false;

    @Column
    private Boolean tv = false;

    @Column
    private Boolean sofa = false;

    @Column
    private Boolean photoFrame = false;

    @OneToOne(mappedBy = "furniture")
    private HouseEntity house;
}
