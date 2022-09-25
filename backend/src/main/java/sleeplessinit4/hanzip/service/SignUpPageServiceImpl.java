package sleeplessinit4.hanzip.service;

import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sleeplessinit4.hanzip.dto.SignUpStatusDto;
import sleeplessinit4.hanzip.dto.request.SignUpRequestDto.Child;
import sleeplessinit4.hanzip.dto.request.SignUpRequestDto.Parent;
import sleeplessinit4.hanzip.entity.ChildrenEntity;
import sleeplessinit4.hanzip.entity.HouseEntity;
import sleeplessinit4.hanzip.entity.ParentEntity;
import sleeplessinit4.hanzip.repository.ChildrenRepository;
import sleeplessinit4.hanzip.repository.HouseRepository;
import sleeplessinit4.hanzip.repository.ParentRepository;
import sleeplessinit4.hanzip.service.interfaces.MissionService;
import sleeplessinit4.hanzip.service.interfaces.SignUpPageService;

@Service
@RequiredArgsConstructor
public class SignUpPageServiceImpl implements SignUpPageService {

  private final ParentRepository parentRepository;
  private final ChildrenRepository childrenRepository;
  private final HouseRepository houseRepository;
  private final MissionService missionService;
  
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public SignUpStatusDto parentSignUp(Parent request) {
//    부모 DB 저장
    ParentEntity parent = ParentEntity.builder()
        .loginId(request.getLoginId())
        .password(bCryptPasswordEncoder.encode(request.getPassword()))
        .build();

    parentRepository.save(parent);

    //부모 미션 문항들 생성
    missionService.makeParentMission(parent);

//    아이 DB 저장 (이름만)
    ChildrenEntity children = ChildrenEntity.builder()
        .nickName(request.getChildName())
        .build();
    
    childrenRepository.save(children);

    //자녀 기본 문항들 생성
    missionService.makeChildrenMission(children);


//    랜덤 코드 생성, 생성 된 랜덤 코드로 조회되는 집이 없을 때 까지 재생성
    String randomCode = createRandomCode();
    while(true){
      if(houseRepository.findByRandomCode(randomCode).isEmpty()){
        break;
      } else {
        randomCode = createRandomCode();
      }
    }

//    집 DB 저장
    HouseEntity house = HouseEntity.builder()
        .houseName(request.getHouseName())
        .randomCode(randomCode)
        .parent(parent)
        .children(children)
        .build();
    houseRepository.save(house);

    return new SignUpStatusDto(true);
  }

  @Override
  public SignUpStatusDto childSignUp(Child request) {

//    랜덤 코드로 집 조회해서 해당 아이 데이터 찾기
    HouseEntity house = houseRepository.findByRandomCode(request.getRandomCode()).orElseThrow(null);

//    아이디 & 비밀번호 저장
    house.getChildren().setLoginId(request.getLoginId());
    house.getChildren().setPassword(bCryptPasswordEncoder.encode(request.getPassword()));

    childrenRepository.save(house.getChildren());

    return new SignUpStatusDto(true);
  }

  /**
   * 8자리 코드 생성
   * @return 8자리 코드 (String)
   */
  private String createRandomCode() {
    Random random = new Random(System.currentTimeMillis());

    StringBuilder randomCode = new StringBuilder();

    for(int i=0; i<8; i++){
      randomCode.append(Integer.toString(random.nextInt(9)));
    }

    return randomCode.toString();
  }
}
