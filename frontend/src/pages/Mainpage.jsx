import Layout from "../components/Layout";
import styled from "styled-components";
import { THEME } from "../constants/colors";
import { getFullDate, getLevel, getMainImgByLevel } from "../utils";
import Img from "../components/atoms/Img";
import Progressbar from "../components/organisms/Progressbar";

export default function Mainpage() {
  const [year, month, day] = getFullDate();

  const data = {
    activityPoint: 5,
    communicationPoint: 5,
    exp: 600,
    houseId: 0,
    houseName: "행복한 우리집",
    level: 0,
    randomCode: "1234",
  };

  const [level, curLevelExp] = getLevel(data.exp);

  return (
    <Layout title="메인페이지">
      <Wrapper>
        <StyledH1>
          Han-Zip<Homecode>{"#" + data.randomCode}</Homecode>
        </StyledH1>
        <Date>{[year, month, day].join(" / ")}</Date>
        <Progressbar size="2rem" data={curLevelExp} />
        <RowWrapper>
          <span>
            <Level>{"Lv. " + level}</Level>
            <Homename>{data.houseName}</Homename>
          </span>
          <span>
            <Percent color={THEME.black600}>{curLevelExp}</Percent>
            <Percent>{" / 100"}</Percent>
          </span>
        </RowWrapper>
        <ImgWrapper>
          <Img src={getMainImgByLevel(level)} alt={getMainImgByLevel(level)} />
        </ImgWrapper>
        <BarWrapper>
          <Type>출석</Type>
          <Progressbar size="1.1rem" type="attendance" data={1} />
          <Type>소통</Type>
          <Progressbar
            size="1.1rem"
            type="communication"
            data={data.communicationPoint}
          />
          <Type>활동</Type>
          <Progressbar
            size="1.1rem"
            type="activity"
            data={data.activityPoint}
          />
        </BarWrapper>
      </Wrapper>
    </Layout>
  );
}

const Type = styled.span`
  font-family: "GangwonEduPowerExtraBoldA";
  font-size: 1.2rem;
  margin-bottom: -0.5rem;
`;

const BarWrapper = styled.div`
  gap: 1.1rem;
  width: 100%;
  padding: 1.1rem;
  display: flex;
  flex-direction: column;
  background-color: ${THEME.black100};
  border-radius: 10px;
`;

const ImgWrapper = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  aspect-ratio: 1 / 1;
`;

const Level = styled.span`
  font-family: "GangwonEduPowerExtraBoldA";
  font-size: 1.2rem;
`;

const Percent = styled.span`
  color: ${(p) => p.color || "black"};
  font-family: "GangwonEduPowerExtraBoldA";
  font-size: 1.1rem;
  line-height: 1.5rem;
  vertical-align: text-top;
`;

const Homename = styled.span`
  margin-left: 1.1rem;
  font-size: 1.4rem;
`;

const RowWrapper = styled.p`
  margin-top: 2rem;
  width: 100%;
  display: flex;
  justify-content: space-between;
  vertical-align: text-bottom;
`;

const Wrapper = styled.div`
  padding: 2rem 3rem;
`;

const StyledH1 = styled.h1`
  font-size: 3rem;
  color: ${THEME.primary};
  margin-bottom: 1.1rem;
`;

const Homecode = styled.span`
  color: ${THEME.black500};
  margin-left: 0.5rem;
  font-size: 1.5rem;
`;

const Date = styled.h3`
  color: ${THEME.black800};
  font-size: 1.3rem;
  margin-bottom: 0.5rem;
`;
