import styled from "styled-components";
import Input from "../../components/atoms/Input";
import Layout from "../../components/Layout";
import { THEME } from "../../constants/colors";
import useLoading from "../../hooks/useLoading";

export default function SignupPage({
  userid,
  setUserid,
  psword,
  setPsword,
  repsword,
  setRepsword,
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
        <HeaderTitle>시용하실 아이디와</HeaderTitle>
        <HeaderTitle>비밀번호를 입력해주세요</HeaderTitle>
      </ThirdHeader>
      <ThirdBody>
        <Input
          value={userid}
          setValue={setUserid}
          placeholder={"아이디"}
        ></Input>
        <Input
          type={"password"}
          value={psword}
          setValue={setPsword}
          placeholder={"비밀번호"}
        ></Input>
        <Input
          type={"password"}
          value={repsword}
          setValue={setRepsword}
          placeholder={"비밀번호확인"}
        ></Input>
      </ThirdBody>
      <FooterWrapper>
        <FooterButton
          disabled={userid === "" || psword === "" || repsword === ""}
          onClick={() => {
            load();
            setTimeout(() => {
              endLoad();
              setPage((p) => p + 1);
            }, 1000);
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

const HeaderTitle = styled.p`
  font-size: 1.3rem;
  line-height: 3rem;
  text-align: center;
  width: 12rem;
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
