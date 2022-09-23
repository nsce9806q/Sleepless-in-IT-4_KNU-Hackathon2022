import Layout from "../components/Layout";
import styled from "styled-components";

export default function Question() {
  return (
    <Layout title="오늘의 질문" hasBackButton>
      <Main>질문페이지 입니다.</Main>
    </Layout>
  );
}

const Main = styled.div`
  padding: 3rem;
`;