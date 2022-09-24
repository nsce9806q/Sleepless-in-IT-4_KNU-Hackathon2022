import styled from "styled-components";
import Input from "../../components/atoms/Input";
import Layout from "../../components/Layout";
import { THEME } from "../../constants/colors";
import useLoading from "../../hooks/useLoading";

export default function SuccessPage({
  userid,
  userType,
  childname,
  homename,
  setPage,
}) {
  const { load, endLoad } = useLoading();
  return (
    <Layout
      title={"이전"}
      hasBackButton
      hasFooter={false}
      onClickBackBtn={() => setPage((p) => p - 1)}
    >
      <ThirdHeader>
        <WelcomeTitle>확인해 주세요!</WelcomeTitle>
      </ThirdHeader>
      <ThirdBody>
        <HeaderTitle>
          당신은 <Strong>{userType === "parent" ? "부모" : "자식"}</Strong>
          입니다.
        </HeaderTitle>
        <HeaderTitle>
          당신의 아이디는 <Strong>{userid}</Strong>입니다.
        </HeaderTitle>
        {userType === "parent" && (
          <>
            <HeaderTitle>
              자녀 이름은 <Strong>{childname}</Strong>입니다.
            </HeaderTitle>
            <HeaderTitle>
              우리집 이름은 <Strong>{homename}</Strong>입니다.
            </HeaderTitle>
          </>
        )}
        <div></div>
        <div></div>
      </ThirdBody>
      <FooterWrapper>
        <FooterButton disabled={userid === ""} onClick={() => {}}>
          회원가입
        </FooterButton>
      </FooterWrapper>
    </Layout>
  );
}

const Strong = styled.span`
  color: ${THEME.primary};
  font-size: 2rem;
  margin-right: 0.5rem;
`;

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
  word-break: keep-all;
  line-break: auto;
  margin-top: 1rem;
`;

const ThirdBody = styled.div`
  margin-top: auto;
  margin-bottom: auto;
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
