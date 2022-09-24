package sleeplessinit4.hanzip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sleeplessinit4.hanzip.dto.ActivityDto;
import sleeplessinit4.hanzip.entity.ActivityEntity;
import sleeplessinit4.hanzip.repository.ActivityRepository;
import sleeplessinit4.hanzip.service.interfaces.ActivityPageService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ActivityPageServiceImpl implements ActivityPageService {

    private final ActivityRepository activityRepository;

    public List<ActivityDto> viewActivityList(Long houseId) {
        List<ActivityEntity> activityEntityList = activityRepository.findByHouseId(houseId);

        List<ActivityDto> activityDtoList = new ArrayList<>();

        for(ActivityEntity activityEntity : activityEntityList) {
            ActivityDto activityDto = ActivityDto.builder()
                    .activityId(activityEntity.getActivityId())
                    .activityTitle(activityEntity.getActivityTitle())
                    .activityContent(activityEntity.getActivityContent())
                    .place(activityEntity.getPlace())
                    .category(activityEntity.getCategory())
                    .build();

            activityDtoList.add(activityDto);
        }

        return activityDtoList;
    }
}
