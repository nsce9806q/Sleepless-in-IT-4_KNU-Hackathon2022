package sleeplessinit4.hanzip.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sleeplessinit4.hanzip.common.exception.ChildrenMissionNotFoundException;
import sleeplessinit4.hanzip.common.exception.ParentMissionNotFoundException;
import sleeplessinit4.hanzip.dto.ParentMissionDto;
import sleeplessinit4.hanzip.entity.ChildrenMissionEntity;
import sleeplessinit4.hanzip.entity.HouseEntity;
import sleeplessinit4.hanzip.entity.ParentEntity;
import sleeplessinit4.hanzip.entity.ParentMissionEntity;
import sleeplessinit4.hanzip.repository.HouseRepository;
import sleeplessinit4.hanzip.repository.ParentMissionRepository;
import sleeplessinit4.hanzip.repository.ParentRepository;
import sleeplessinit4.hanzip.service.interfaces.ParentPageService;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ParentPageServiceImpl implements ParentPageService {

    private final EntityManager entityManager;

    private final ParentRepository parentRepository;
    private final ParentMissionRepository parentMissionRepository;
    private final HouseRepository houseRepository;

    /**
     * 부모 사용자의 미션 페이지를 보여주는 메서드
     * @param parentId
     * @return 미션 list
     */
    @Override
    public List<ParentMissionDto> viewParentMission (Long parentId) {
        ParentEntity parentEntity = parentRepository.findParentWithMissionById(parentId);

        List<ParentMissionDto> parentMissionDtoList = new ArrayList<>();

        for(ParentMissionEntity parentMission : parentEntity.getParentMissionList()) {
            ParentMissionDto parentMissionDto = ParentMissionDto.builder()
                    .parentMissionId(parentMission.getParentMissionId())
                    .missionTitle(parentMission.getMissionTitle())
                    .missionContent(parentMission.getMissionContent())
                    .missionLevel(parentMission.getMissionLevel())
                    .reward(parentMission.getReward())
                    .isComplete(parentMission.getIsComplete())
                    .build();

            parentMissionDtoList.add(parentMissionDto);
        }

        return parentMissionDtoList;
    }

    @Override
    public List<ParentMissionDto> clearMission (Long parentId, Long missionId) {
        Optional<ParentMissionEntity> optionalParentMission = parentMissionRepository.findById(missionId);

        //미션 Complete 로 변경해 주기
        ParentMissionEntity parentMission = optionalParentMission.orElseThrow(ParentMissionNotFoundException::new);
        parentMission.missionComplete();

        //집 경험치 증가
        HouseEntity houseEntity = houseRepository.findByParentId(parentId);
        houseEntity.increaseExp(parentMission.getReward());

        entityManager.flush();

        //변경된 미션 List 반환
        return viewParentMission(parentId);
    }
}
