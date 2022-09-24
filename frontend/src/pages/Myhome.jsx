import Layout from "../components/Layout";
import styled from "styled-components";
import Img from "../components/atoms/Img";
import { THEME } from "../constants/colors";
import { useState } from 'react';
import { Button, Navbar, Nav, Container } from 'react-bootstrap';
import {Routes, Route, Link, useNavigate, Outlet} from 'react-router-dom'
import TodoList from "../components/TodoList";

export default function Myhome() {
  let navigate = useNavigate();

  return (
    <Layout title="마이홈" hasBackButton>
      <FormWrapper>
        <Img size="15rem" src={"MainImg.png"} />
        <StyledH1>행복한 우리집</StyledH1>
      </FormWrapper>
      <StyledBtn onClick={()=>{ navigate('/myhome/done')}}>함께했어요</StyledBtn>
      <StyledBtn onClick={()=>{ navigate('/myhome/do')}}>함께할거에요</StyledBtn>
    <TodoList/>

    </Layout>
  );
}
const Main = styled.div`
  padding: 3rem;
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

const StyledBtn = styled.button`
  font-size: 2rem;
  font-weight: bold;
  color: ${(p)=>(p.selected ? THEME.black700 : THEME.primary)};
  margin-bottom: 1.5rem;
  background-color:transparent;
  border: none;
`;