import Layout from "../components/Layout";
import styled from "styled-components";
import Img from "../components/atoms/Img";


export default function Err() {

  return (
    <Layout title="에러 페이지" hasBackButton>
        <FormWrapper>
            <Img size="15rem" src={"Err.png"} />
            <StyledH1>에러 페이지입니다.</StyledH1>
            <StyledH1>탭에 있는 메뉴를 선택하세요.</StyledH1>
        </FormWrapper>
    </Layout>
  );
}

const Main = styled.div`
  padding: 3rem;
  font-size: 1.2rem;
`;

const FormWrapper = styled.form`
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin 3rem auto;
`;

const StyledH1 = styled.h1`
  font-size: 2rem;
  font-weight: bold;
  margin: 1rem 0;
`;