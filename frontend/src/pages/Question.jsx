import Layout from "../components/Layout";
import styled from "styled-components";
import Checkboxpage from "../pages/Checkboxpage";
import { useState } from "react";
import ChildData from "../Data/ChildData";

export default function QuestionCild() {
  let [Data] = useState(ChildData);
  return (
    <Layout title="오늘의 질문">
      <Checkboxpage Data={Data} />
    </Layout>
  );
}
