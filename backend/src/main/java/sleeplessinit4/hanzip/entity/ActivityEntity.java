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
public class ActivityEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @Column
    private String activityTitle;

    @Column
    private String activityContent;

    @Column
    private String place;

    @ManyToOne
    @JoinColumn(name="house_id")
    private HouseEntity house;
}
