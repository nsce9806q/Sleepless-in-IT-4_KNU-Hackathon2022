import Layout from "../components/Layout";
import styled from "styled-components";
import Checkboxpage from "../pages/Checkboxpage"
import { useState } from 'react';
import ChildData from '../Data/ChildData'

export default function QuestionCild() {
  let [Data] =useState(ChildData)
  return (
    <Layout title="오늘의 질문" hasBackButton>
      <Main>오늘도 좋은 하루되세요</Main>
      <Checkboxpage Data={Data} img={true}/>
    </Layout>

    
  );
}

const Main = styled.div`
  padding: 3rem;
  font-size: 1.5rem;
`;