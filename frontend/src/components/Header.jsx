import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import { THEME } from "../constants/colors";

export default function Header({ title, hasBackButton }) {
  const navigate = useNavigate();

  return (
    <Main>
      {hasBackButton && (
        <Back onClick={() => navigate(-1)}>
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="32"
            height="32"
            viewBox="8 8 32 32"
            fill="none"
          >
            <path
              d="M28 16L20.3536 23.6464C20.1583 23.8417 20.1583 24.1583 20.3536 24.3536L28 32"
              stroke="#3C3C3C"
              strokeWidth="2.5"
              strokeLinecap="round"
            />
          </svg>
        </Back>
      )}
      {title}
    </Main>
  );
}

const Main = styled.header`
  height: 4rem;
  position: fixed;
  z-index: 100000;
  top: 0;
  left: 0;
  right: 0;
  padding: 1rem;
  background-color: white;
  display: flex;
  align-items: center;
  color: ${THEME.black900};
  font-size: 20px;
  font-weight: 700;
  vertical-align: baseline;
  gap: 0.5rem;
`;

const Back = styled.button`
  background: none;
  border: none;
  padding: 0;
  margin-top: -2px;
`;
