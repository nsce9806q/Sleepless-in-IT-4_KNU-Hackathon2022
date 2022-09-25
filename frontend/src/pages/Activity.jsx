import Layout from "../components/Layout";
import styled from "styled-components";
import ActivityCard from "../components/ActivityCard";
import { Button, Navbar, Nav, Container } from 'react-bootstrap';
import {Routes, Route, Link, useNavigate, Outlet} from 'react-router-dom'
import { THEME } from "../constants/colors";
import usePath from "../hooks/usePath";


export default function Activity() {
  let navigate = useNavigate();

  return (
    <Layout title="활동 페이지" hasBackButton>

      <div class="container text-center">
        <div class="row row-cols-2 g-3" >
          {
              [1,2,3,4,5,6,7].map(()=>{
                return(
                  <>
                    <div class="col-sm-4"><ActivityCard/></div>
                  </>
                )
              })
          }
        </div>
      </div>
    </Layout>
  );
}

const Main = styled.div`
  padding: 3rem;
  font-size: 1.2rem;
`;
