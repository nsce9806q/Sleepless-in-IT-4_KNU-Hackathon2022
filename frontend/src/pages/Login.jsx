import Layout from "../components/Layout";
import LoginInput from "../components/atoms/LoginInput";
import { useState } from "react";
import Btn from "../components/atoms/Btn";
import Img from "../components/atoms/Img";
import styled from "styled-components";
import { THEME } from "../constants/colors";
import { Link } from "react-router-dom";

export default function Login() {
  const [userid, setUserid] = useState("");
  const [psword, setPsword] = useState("");

  return (
    <Layout hasFooter={false}>
      <FormWrapper>
        <Img src={"MainImg.png"} alt="home" />
        <StyledH1>한집</StyledH1>
        <StyledH2>Han-Zip</StyledH2>
        <LoginInput
          value={userid}
          setValue={setUserid}
          placeholder={"아이디"}
        />
        <LoginInput
          value={psword}
          setValue={setPsword}
          placeholder={"비밀번호"}
        />
        <Btn>로그인</Btn>
        <StyledParg>
          아직 회원이 아니신가요? <Text to="/signup">회원가입</Text>
        </StyledParg>
      </FormWrapper>
    </Layout>
  );
}

const StyledParg = styled.p`
  margin-top: 1rem;
  font-size: 0.9rem;
  color: ${THEME.black500};
`;

const Text = styled(Link)`
  color: ${THEME.primary};
  &:hover {
    color: ${THEME.darker};
  }
`;

const FormWrapper = styled.form`
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

const StyledH1 = styled.h1`
  font-size: 2.5rem;
  font-weight: bold;
  margin: 1rem 0;
`;

const StyledH2 = styled.h1`
  font-size: 2rem;
  font-weight: bold;
  color: ${THEME.primary};
  margin-bottom: 1.5rem;
`;
