package sleeplessinit4.hanzip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sleeplessinit4.hanzip.common.mapper.ChildrenMissionMapper;
import sleeplessinit4.hanzip.common.mapper.ParentMissionMapper;
import sleeplessinit4.hanzip.dto.ChildrenMissionDto;
import sleeplessinit4.hanzip.dto.ParentMissionDto;
import sleeplessinit4.hanzip.entity.ChildrenEntity;
import sleeplessinit4.hanzip.entity.ChildrenMissionEntity;
import sleeplessinit4.hanzip.entity.ParentEntity;
import sleeplessinit4.hanzip.entity.ParentMissionEntity;
import sleeplessinit4.hanzip.service.interfaces.MissionService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class DefaultMissionServiceImpl implements MissionService {

    ChildrenMissionMapper childrenMissionMapper = new ChildrenMissionMapper();
    ParentMissionMapper parentMissionMapper = new ParentMissionMapper();

    Random random = new Random();
    LocalDate now = LocalDate.now();

    int defaultMissionCnt = 12;
    int date = now.getDayOfMonth();
    int randNum = (date%3)+3;

    @Override
    public void makeChildrenMission(ChildrenEntity childrenEntity) {

        List<Long> defaultMissionLevel = Arrays.asList(1L,1L,1L,2L,2L,2L,3L,3L,3L,4L,4L,4L);

        List<String> defaultMissionTitle = Arrays
                .asList("잠을 충분히 주무셨나요?",
                        "오늘 규칙적으로 식사를 하셨나요?",
                        "오늘 외출을 하셨나요?",
                        "침대를 정돈하면 기분도 좋아질 거에요",
                        "샤워를 하면 하루를 상쾌하게 시작할 수 있을거에요",
                        "오늘 하루 딱 6000보만 걸어보는게 어떨까요?",
                        "날씨가 좋다면 가벼운 산책을 나가는건 어떨까요?",
                        "어지러운 방을 정리한다면 기분도 좋아질 거에요",
                        "가족들에게 잘 잤는지 먼저 안부인사를 해보는건 어떨까요?",
                        "운동으로 열심히 땀을 흘리다보면 기분이 좋아질 거에요",
                        "친구들과 만나서 재밌는 활동을 하는건 어떨까요?",
                        "날씨가 좋다면 가족들과 함께 야외활동을 해보는건 어떨까요?");

        List<Long> defaultMissionReward = Arrays.asList(10L,10L,10L,20L,20L,20L,30L,30L,30L,40L,40L,40L);
        List<Long> defaultActivityPoint = Arrays.asList(0L,0L,1L,1L,1L,2L,2L,2L,3L,3L,3L,3L);
        List<Long> defaultCommunicationPoint = Arrays.asList(0L,0L,0L,1L,1L,2L,2L,3L,2L,2L,3L,3L);

        for(int i=0; i<defaultMissionCnt; i++) {
            ChildrenMissionEntity childrenMission = ChildrenMissionEntity.builder()
                    .children(childrenEntity)
                    .missionLevel(defaultMissionLevel.get(i))
                    .missionTitle(defaultMissionTitle.get(i))
                    .reward(defaultMissionReward.get(i))
                    .activityPoint(defaultActivityPoint.get(i))
                    .communicationPoint(defaultCommunicationPoint.get(i))
                    .build();

            childrenEntity.getChildrenMissionList().add(childrenMission);
        }
    }

    /**
     * 부모의 미션중 고정 으로 3문항, 랜덤으로 3문항을 선택해 주는 메서드
     * @param parentMissionEntityList
     * @return 선별된 부모의 미션 List
     */
    @Override
    public List<ParentMissionDto> pickParentMission (List<ParentMissionEntity> parentMissionEntityList) {

        List<ParentMissionDto> parentMissionDtoList = new ArrayList<>();
        
        //고정 문항들
        for(int i=0; i<3; i++) {
            ParentMissionDto parentMissionDto = parentMissionMapper.entityToDto(parentMissionEntityList.get(i));

            parentMissionDtoList.add(parentMissionDto);
        }
        
        //가변 문항들
        for(int i=randNum; i<defaultMissionCnt; i+=3) {
            ParentMissionDto parentMissionDto = parentMissionMapper.entityToDto(parentMissionEntityList.get(i));

            parentMissionDtoList.add(parentMissionDto);
        }

        return parentMissionDtoList;

    }

    @Override
    public void makeParentMission(ParentEntity parentEntity) {

        List<Long> defaultMissionLevel = Arrays.asList(1L,1L,1L,2L,2L,2L,3L,3L,3L,4L,4L,4L);

        List<String> defaultMissionTitle = Arrays
                .asList("오늘 자녀가 언제 일어났는지 아시나요?",
                        "오늘 자녀가 어떤걸 먹었는지 아시나요?",
                        "오늘 자녀와 대화를 하셨나요?",
                        "오늘 자녀와 함께 식사를 하는건 어떨까요?",
                        "오늘 자녀의 기분이 어떤지 물어볼까요?",
                        "오늘 하루 자녀가 어떤일이 있었는지 물어볼까요?",
                        "자녀가 평소에 재미있어 하는 활동이 무엇인지 물어볼까요?",
                        "자녀가 평소에 좋아하는 음식이 무엇인지 물어볼까요?",
                        "자녀와 함께 가벼운 산책을 하는건 어떨까요?",
                        "자녀와 함께 여행을 가는건 어떨까요?",
                        "자녀에게 힘든점은 없는지 물어볼까요?",
                        "가족이 다 같이 야외활동을 해보는건 어떨까요?");

        List<Long> defaultMissionReward = Arrays.asList(10L,10L,10L,20L,20L,20L,30L,30L,30L,40L,40L,40L);
        List<Long> defaultActivityPoint = Arrays.asList(0L,0L,1L,1L,1L,2L,2L,2L,3L,3L,3L,3L);
        List<Long> defaultCommunicationPoint = Arrays.asList(0L,0L,0L,1L,1L,2L,2L,3L,2L,2L,3L,3L);

        for(int i=0; i<defaultMissionCnt; i++) {
            ParentMissionEntity parentMission = ParentMissionEntity.builder()
                    .parent(parentEntity)
                    .missionLevel(defaultMissionLevel.get(i))
                    .missionTitle(defaultMissionTitle.get(i))
                    .reward(defaultMissionReward.get(i))
                    .activityPoint(defaultActivityPoint.get(i))
                    .communicationPoint(defaultCommunicationPoint.get(i))
                    .build();

            parentEntity.getParentMissionList().add(parentMission);
        }
    }

    @Override
    public List<ChildrenMissionDto> pickChildrenMission (List<ChildrenMissionEntity> childrenMissionEntityList) {
        List<ChildrenMissionDto> childrenMissionDtoList = new ArrayList<>();

        //고정 문항들
        for(int i=0; i<3; i++) {
            ChildrenMissionDto childrenMissionDto = childrenMissionMapper.entityToDto(childrenMissionEntityList.get(i));

            childrenMissionDtoList.add(childrenMissionDto);
        }

        //가변 문항들
        for(int i=randNum; i<defaultMissionCnt; i+=3) {
            ChildrenMissionDto childrenMissionDto = childrenMissionMapper.entityToDto(childrenMissionEntityList.get(i));

            childrenMissionDtoList.add(childrenMissionDto);
        }

        return childrenMissionDtoList;
    }
}
