import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import { THEME } from "../constants/colors";
import { HomeIcon } from "./Icons";

export default function Footer() {
  const navigate = useNavigate();
  return (
    <Main>
      <FooterItem onClick={() => navigate("/")} selected={false}>
        <HomeIcon />
        메인
      </FooterItem>
      <FooterItem onClick={() => navigate("/")} selected={true}>
        <HomeIcon />
        메인2
      </FooterItem>
      <FooterItem onClick={() => navigate("/")} selected={true}>
        <HomeIcon />
        메인3
      </FooterItem>
      <FooterItem onClick={() => navigate("/")} selected={true}>
        <HomeIcon />
        메인4
      </FooterItem>
    </Main>
  );
}

const Main = styled.footer`
  display: grid;
  grid-template-columns: repeat(4, 1fr);

  height: 5rem;

  position: fixed;
  z-index: 100000;
  left: 0;
  right: 0;
  bottom: 0px;
  background-color: white;
  border-radius: 10px 10px 0 0;
  box-shadow: 0 -4px 36px rgba(0, 0, 0, 0.07);
`;

const FooterItem = styled.button`
  text-align: center;
  border: none;
  background: none;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: center;
  height: 4rem;
  gap: 4px;
  font-size: 0.8rem;
  color: ${(p) => (p.selected ? THEME.darker : THEME.black400)};
`;
