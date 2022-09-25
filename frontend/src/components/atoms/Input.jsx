import styled from "styled-components";
import { THEME } from "../../constants/colors";

export default function Input({ type, value, setValue, placeholder }) {
  return (
    <StyledInput
      type={type}
      value={value}
      onChange={(e) => setValue(e.target.value)}
      placeholder={placeholder}
    />
  );
}

const StyledInput = styled.input`
  font-size: 1.3rem;
  line-height: 2rem;
  background-color: transparent;
  color: black;
  text-align: left;
  border: none;
  border-bottom: 2px solid ${THEME.black400};
  width: 18rem;
  transition: 0.5s;
  ::placeholder {
    color: ${THEME.black500};
    text-align: left;
  }
  &:focus {
    outline: none;
    border-bottom: 2px solid ${THEME.primary};
  }
  letter-spacing: ${(p) => p.type && "0.15rem"};
  margin-top: 2rem;
  margin-bottom: 2rem;
`;
