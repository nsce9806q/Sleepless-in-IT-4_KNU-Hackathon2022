import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import Img from "../../components/atoms/Img";
import { ChildIcon, ParentIcon } from "../../components/Icons";
import Layout from "../../components/Layout";
import { THEME } from "../../constants/colors";
import useLoading from "../../hooks/useLoading";

export default function SelectPage({ userType, setUserType, setPage }) {
  const navigate = useNavigate();
  const { load, endLoad } = useLoading();
  return (
    <Layout
      title={"로그인 페이지로"}
      onClickBackBtn={() => navigate("/login")}
      hasBackButton
      hasFooter={false}
    >
      <ThirdHeader>
        <WelcomeTitle>한집에 오신것을 환영해요!</WelcomeTitle>
        <HeaderTitle>어떤 역할로 활동할지 선택해주세요!</HeaderTitle>
      </ThirdHeader>
      <ThirdBody>
        <Card
          active={userType === "child"}
          onClick={() => {
            if (userType === "child") {
              setUserType("");
            } else {
              setUserType("child");
            }
          }}
        >
          {/* <ChildCharacter active={userType === "child"} /> */}
          {/* <Img src={"HoBanCow.png"} /> */}
          <ChildIcon />
          <CardText active={userType === "child"}>아이입니다</CardText>
        </Card>
        <Card
          active={userType === "parent"}
          onClick={() => {
            if (userType === "parent") {
              setUserType("");
            } else {
              setUserType("parent");
            }
          }}
        >
          <ParentIcon />
          <CardText active={userType === "parent"}>부모입니다</CardText>
        </Card>
      </ThirdBody>
      <FooterWrapper>
        <FooterButton
          disabled={Number(userType.length) === 0}
          onClick={() => {
            load();
            setTimeout(() => {
              endLoad();
              setPage((p) => p + 1);
            }, 500);
          }}
        >
          다음
        </FooterButton>
      </FooterWrapper>
    </Layout>
  );
}

const ThirdHeader = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const WelcomeTitle = styled.p`
  line-height: 3rem;
  text-align: center;
  color: ${THEME.primary};
  font-size: 1.5rem;
  margin-top: 1rem;
`;

const HeaderTitle = styled.p`
  font-size: 1.3rem;
  line-height: 3rem;
  text-align: center;
  width: 11rem;
  line-break: auto;
  margin-top: 1rem;
`;

const ThirdBody = styled.div`
  margin-top: 20vh;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 2rem;
`;

const Card = styled.div`
  border: 2px solid ${(props) => (props.active ? "#FCBA58" : "#DEDEDE")};
  border-radius: 10px;
  width: 10rem;
  height: 14rem;
  color: ${(props) => (props.active ? "#FCBA58" : "#DEDEDE")};
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  cursor: pointer;
  user-select: none;
`;

const CardText = styled.p`
  position: absolute;
  width: 6.15rem;
  left: 50%;
  transform: translate(-50%, 0);
  bottom: 1.5rem;
  font-size: 25px;
  line-height: 26px;
  display: flex;
  align-items: center;
  text-align: center;
  color: ${(props) => (props.active ? "#FCBA58" : "#B7B7B7")}; ;
`;

const FooterWrapper = styled.div`
  position: absolute;
  bottom: 2rem;
  width: 100%;
  display: flex;
  justify-content: center;
`;

const FooterButton = styled.button`
  background: ${THEME.primary};
  border-radius: 31.5px;
  width: 20rem;
  height: 3rem;
  font-style: normal;
  font-weight: 700;
  font-size: 1.3rem;
  line-height: 21px;
  text-align: center;
  color: #ffffff;
  border: none;
  :disabled {
    background: ${THEME.black400};
  }
`;
