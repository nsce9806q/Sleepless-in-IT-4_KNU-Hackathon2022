import Layout from "../components/Layout";
import styled from "styled-components";
import ActivityCard from "../components/ActivityCard";
import { Button, Navbar, Nav, Container } from 'react-bootstrap';
import {Routes, Route, Link, useNavigate, Outlet} from 'react-router-dom'
import Checkboxpage from "../pages/Checkboxpage"
import TodoList from "../components/TodoList";

export default function ActivityInside() {
  let navigate = useNavigate();

  return (
    <Layout title="활동 페이지" hasBackButton>
      <Navbar bg="light" variant="light">
        <Container>
          <Nav className="me-auto">
            <Nav.Link onClick={()=>{ navigate('/activity')}}>Outside</Nav.Link>
            <Nav.Link onClick={()=>{ navigate('/activity/inside')}}>Inside</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

    <Checkboxpage/>
    <TodoList/>
    </Layout>
  );
}

const Main = styled.div`
  padding: 3rem;
  font-size: 1.2rem;
`;