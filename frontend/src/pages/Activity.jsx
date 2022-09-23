import Layout from "../components/Layout";
import styled from "styled-components";

export default function Activity() {
  return (
    <Layout title="활동 페이지" hasBackButton>
      <Main>활동페이지입니다.</Main>
    </Layout>
  );
}

const Main = styled.div`
  padding: 3rem;
`;