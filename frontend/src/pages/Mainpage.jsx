import Layout from "../components/Layout";
import styled from "styled-components";

export default function Mainpage() {
  return (
    <Layout title="안녕하세요" hasBackButton>
      <Main>메인페이지 입니다.</Main>
    </Layout>
  );
}

const Main = styled.div`
  padding: 3rem;
`;
