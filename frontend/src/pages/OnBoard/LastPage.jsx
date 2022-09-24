import styled from "styled-components";
import Img from "../../components/atoms/Img";
import Input from "../../components/atoms/Input";
import Layout from "../../components/Layout";
import { THEME } from "../../constants/colors";

export default function LastPage({
  homename,
  setHomename,
  childname,
  setChildname,
  homecode,
  setHomecode,
  userType,
  setPage,
}) {
  return (
    <Layout
      title={"이전"}
      hasBackButton
      hasFooter={false}
      onClickBackBtn={() => setPage((p) => p - 1)}
    >
      <ThirdHeader>
        <WelcomeTitle>마지막입니다!</WelcomeTitle>
        {userType === "parent" ? (
          <>
            <HeaderTitle>우리집 이름과</HeaderTitle>
            <HeaderTitle>자녀의 이름을 적어주세요!</HeaderTitle>
          </>
        ) : (
          <>
            <HeaderTitle>우리집 코드를 적어주세요!</HeaderTitle>
            <HeaderTitle></HeaderTitle>
          </>
        )}
      </ThirdHeader>
      <ThirdBody>
        <Div size="20rem">
          <Img size="10rem" src={"MainImg.png"} />
        </Div>
        {userType === "parent" ? (
          <>
            <Input
              value={homename}
              setValue={setHomename}
              placeholder={"우리집 이름"}
            ></Input>
            <Input
              value={childname}
              setValue={setChildname}
              placeholder={"자녀의 이름"}
            ></Input>
          </>
        ) : (
          <>
            <div style={{ height: "5rem" }}></div>
            <Input
              value={homecode}
              setValue={setHomecode}
              placeholder={"우리집 코드"}
            ></Input>
          </>
        )}
      </ThirdBody>
      <FooterWrapper>
        {userType === "parent" ? (
          <FooterButton
            disabled={homename === "" || childname === ""}
            onClick={() => {
              setPage((p) => p + 1);
            }}
          >
            다음
          </FooterButton>
        ) : (
          <FooterButton
            disabled={homecode === ""}
            onClick={() => {
              setPage((p) => p + 1);
            }}
          >
            다음
          </FooterButton>
        )}
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

const HeaderTitle = styled.p`
  font-size: 1.3rem;
  line-height: 3rem;
  text-align: center;
  width: 14rem;
  line-break: auto;
  margin-top: 1rem;
`;

const ThirdBody = styled.div`
  margin-top: 5rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 2rem;
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
  font-size: 1rem;
  line-height: 21px;
  text-align: center;
  font-size: 1.3rem;
  color: #ffffff;
  border: none;
  :disabled {
    background: ${THEME.black400};
  }
`;

const WelcomeTitle = styled.p`
  line-height: 3rem;
  text-align: center;
  color: ${THEME.primary};
  font-size: 1.5rem;
`;

const Div = styled.div`
  width: ${(p) => p.size || "100%"};
  aspect-ratio: ${(p) => p.ratio || "1 / 1"};
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  margin: -5rem;
  opacity: 0.7;
  background: rgb(247, 233, 70);
  background: radial-gradient(
    circle,
    rgba(247, 233, 70, 1) 0%,
    rgba(253, 251, 218, 0.3617822128851541) 80%,
    rgba(255, 255, 255, 1) 100%
  );
`;
