package sleeplessinit4.hanzip.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {

    private Long houseId;
    private String houseName;
    private Long level;
    private Long exp;
    private Long activityPoint;
    private Long communicationPoint;
    private String randomCode;
}
