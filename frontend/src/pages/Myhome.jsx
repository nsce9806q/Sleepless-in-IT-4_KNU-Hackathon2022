import Layout from "../components/Layout";
import styled from "styled-components";

export default function Myhome() {
  return (
    <Layout title="마이홈" hasBackButton>
      <Main>마이홈페이지 입니다.</Main>
    </Layout>
  );
}

const Main = styled.div`
  padding: 3rem;
`;