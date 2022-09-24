package sleeplessinit4.hanzip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sleeplessinit4.hanzip.common.exception.ChildrenMissionNotFoundException;
import sleeplessinit4.hanzip.dto.ChildrenMissionDto;
import sleeplessinit4.hanzip.entity.ChildrenEntity;
import sleeplessinit4.hanzip.entity.ChildrenMissionEntity;
import sleeplessinit4.hanzip.entity.HouseEntity;
import sleeplessinit4.hanzip.repository.ChildrenMissionRepository;
import sleeplessinit4.hanzip.repository.ChildrenRepository;
import sleeplessinit4.hanzip.repository.HouseRepository;
import sleeplessinit4.hanzip.service.interfaces.ChildrenPageService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ChildrenPageServiceImpl implements ChildrenPageService {

    private final EntityManager entityManager;

    private final ChildrenMissionRepository childrenMissionRepository;
    private final ChildrenRepository childrenRepository;
    private final HouseRepository houseRepository;

    /**
     * 자녀 사용자의 미션 페이지를 보여주는 메서드
     * @param childrenId 자녀 사용자 id
     * @return 미션 list
     */
    @Override
    public List<ChildrenMissionDto> viewChildrenMission (Long childrenId) {
        ChildrenEntity childrenEntity = childrenRepository.findChildrenWithMissionById(childrenId);

        List<ChildrenMissionDto> childrenMissionDtoList = new ArrayList<>();

        for(ChildrenMissionEntity childrenMission : childrenEntity.getChildrenMissionList()) {
            ChildrenMissionDto childrenMissionDto = ChildrenMissionDto.builder()
                    .childrenMissionId(childrenMission.getChildrenMissionId())
                    .missionTitle(childrenMission.getMissionTitle())
                    .missionContent(childrenMission.getMissionContent())
                    .missionLevel(childrenMission.getMissionLevel())
                    .reward(childrenMission.getReward())
                    .isComplete(childrenMission.getIsComplete())
                    .build();

            childrenMissionDtoList.add(childrenMissionDto);
        }

        return childrenMissionDtoList;
    }

    /**
     * 사용자가 미션을 체크하면 수행 처리를 해주는 메서드
     * @param childrenId 자녀 사용자 id
     * @param missionId 수행한 미션 id
     * @return 미션이 수행된 이후의 미션 list
     */
    @Override
   public List<ChildrenMissionDto> clearMission (Long childrenId, Long missionId) {
        Optional<ChildrenMissionEntity> optionalChildrenMission = childrenMissionRepository.findById(missionId);

        //미션 Complete 로 변경해 주기
        ChildrenMissionEntity childrenMission = optionalChildrenMission.orElseThrow(ChildrenMissionNotFoundException::new);
        childrenMission.missionComplete();

        //집 경험치 증가
        HouseEntity houseEntity = houseRepository.findByChildrenId(childrenId);
        houseEntity.clearChildrenMission(childrenMission);

        entityManager.flush();

        return viewChildrenMission(childrenId);
   }
}
