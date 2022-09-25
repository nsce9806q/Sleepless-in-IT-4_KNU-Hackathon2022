package sleeplessinit4.hanzip.service.interfaces;

import sleeplessinit4.hanzip.dto.ActivityDto;

import java.util.List;

public interface ActivityPageService {

    List<ActivityDto> viewActivityList(Long houseId);
}
