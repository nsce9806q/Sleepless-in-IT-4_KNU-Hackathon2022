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
@Entity(name="activity")
public class ActivityEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;

    @Column(length = 20)
    private String activityTitle;

    @Column(length = 200)
    private String activityContent;

    @Column(length = 20)
    private String place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="house_id")
    private HouseEntity house;
}
