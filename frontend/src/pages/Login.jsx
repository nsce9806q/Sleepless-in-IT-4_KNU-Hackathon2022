import Layout from "../components/Layout";
import LoginInput from "../components/atoms/LoginInput";
import { useState } from "react";
import Btn from "../components/atoms/Btn";
import Img from "../components/atoms/Img";
import styled from "styled-components";
import { THEME } from "../constants/colors";
import { Link, useNavigate } from "react-router-dom";
import useLoading from "../hooks/useLoading";
import { useAlert } from "../hooks/useAlert";
import { apiLogin } from "../apis/users";

export default function Login() {
  const [userid, setUserid] = useState("");
  const [psword, setPsword] = useState("");
  const navigate = useNavigate();

  const { load, endLoad } = useLoading();
  const { push } = useAlert();

  const handleSubmit = async (e) => {
    e.preventDefault();
    load();
    try {
      // TODO: axios
      // const [data, status] =  await apiLogin({userid, psword});
      // if (result.data.data) {
      if (false) {
        // storeToken(result.data.data.token);
        // load();
        // setTimeout(() => {
        //   navigate("/main");
        // }, 3000);
      } else {
        endLoad();
        push({
          message: "아이디와 비밀번호를 확인해주세요.",
          buttonText: "확인",
          onClose: () => {},
        });
      }
    } catch (e) {
      endLoad();
      push({
        message: "아이디와 비밀번호를 확인해주세요.",
        buttonText: "확인",
        onClose: () => {},
      });
    }
  };

  return (
    <Layout hasFooter={false}>
      <FormWrapper onSubmit={handleSubmit}>
        <Img size="15rem" src={"MainImg.png"} />
        <StyledH1>한 집</StyledH1>
        <StyledH2>Han-Zip</StyledH2>
        <LoginInput
          value={userid}
          setValue={setUserid}
          placeholder={"아이디"}
        />
        <LoginInput
          type="password"
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
  font-family: "GangwonEduPowerExtraBoldA";
  font-size: 3.2rem;
  font-weight: bold;
  margin: 1rem 0;
`;

const StyledH2 = styled.h1`
  font-size: 2rem;
  font-weight: bold;
  color: ${THEME.primary};
  margin-bottom: 1.5rem;
`;
