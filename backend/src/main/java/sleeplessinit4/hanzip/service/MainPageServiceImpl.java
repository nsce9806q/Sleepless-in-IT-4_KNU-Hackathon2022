package sleeplessinit4.hanzip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sleeplessinit4.hanzip.common.exception.HouseNotFoundException;
import sleeplessinit4.hanzip.dto.HouseDto;
import sleeplessinit4.hanzip.entity.HouseEntity;
import sleeplessinit4.hanzip.repository.HouseRepository;
import sleeplessinit4.hanzip.service.interfaces.MainPageService;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MainPageServiceImpl implements MainPageService {

    private final HouseRepository houseRepository;

    public HouseDto viewMain(Long houseId) {
        Long maxExp = 100L;

        Optional<HouseEntity> optionalHouseEntity = houseRepository.findById(houseId);
        HouseEntity houseEntity = optionalHouseEntity.orElseThrow(HouseNotFoundException::new);

        HouseDto houseDto = HouseDto.builder()
                .houseId(houseEntity.getHouseId())
                .houseName(houseEntity.getHouseName())
                .level(houseEntity.getExp()/maxExp + 1)
                .exp(houseEntity.getExp()%maxExp)
                .activityPoint(houseEntity.getActivityPoint())
                .communicationPoint(houseEntity.getCommunicationPoint())
                .randomCode(houseEntity.getRandomCode())
                .build();

        return houseDto;
    }
}
