import Header from "./Header";
import Footer from "./Footer";
import styled from "styled-components";
import { THEME } from "../constants/colors";

export default function Layout({
  children,
  title,
  hasBackButton,
  onClickBackBtn,
  hasFooter = true,
}) {
  return (
    <Main>
      <Header
        title={title}
        hasBackButton={hasBackButton}
        onClickBackBtn={onClickBackBtn}
      />
      <Children>{children}</Children>
      <Footer hasFooter={hasFooter} />
    </Main>
  );
}

const Main = styled.div`
  width: 100%;
  height: 100%;
  min-height: 100vh;
`;

const Children = styled.div`
  padding: 4rem 0;
  width: 100%;
  height: 100%;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  /* background-color: ${THEME.background}; */
`;
