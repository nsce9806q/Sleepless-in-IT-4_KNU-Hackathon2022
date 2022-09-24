import Layout from "../components/Layout";
import styled from "styled-components";
import ActivityCard from "../components/ActivityCard";

export default function Activity() {
  return (
    <Layout title="활동 페이지" hasBackButton>
      <Main>
        가족과 함께하는 야외활동
      </Main>
      <div class="container text-center">
        <div class="row g-3" >
          {
              [1,2,3,4,5,6,7].map(()=>{
                return(
                  <>
                    <div class="col-sm"><ActivityCard/></div>
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
`;