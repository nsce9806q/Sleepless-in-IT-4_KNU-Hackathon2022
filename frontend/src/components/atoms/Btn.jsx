import styled from "styled-components";
import { THEME } from "../../constants/colors";

export default function Btn({ children, onClickBtn }) {
  const handleClick = (e) => {
    e.preventDefault();
    onClickBtn();
  };

  return <StyledBtn onClick={handleClick}>{children}</StyledBtn>;
}

const StyledBtn = styled.button`
  font-size: 1.3rem;
  line-height: 2rem;
  color: white;
  text-align: left;
  border: 2px solid ${THEME.primary};
  background-color: ${THEME.primary};
  text-align: center;
  border-radius: 50px;
  padding: 0.5rem;
  width: 18rem;
  transition: 0.3s;
  &:hover {
    outline: none;
    border: 2px solid ${THEME.darker};
    background-color: ${THEME.darker};
  }
  margin: 1rem 0;
`;
