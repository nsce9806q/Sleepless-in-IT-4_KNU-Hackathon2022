import styled from "styled-components";
import { THEME } from "../../constants/colors";

export default function LoginInput({ value, setValue, placeholder }) {
  return (
    <StyledInput
      value={value}
      onChange={(e) => setValue(e.target.value)}
      placeholder={placeholder}
    />
  );
}

const StyledInput = styled.input`
  font-size: 1.2rem;
  line-height: 2rem;
  color: black;
  text-align: left;
  border: 2px solid ${THEME.black400};
  border-radius: 50px;
  padding: 0.5rem;
  padding-left: 1rem;
  width: 18rem;
  transition: 0.5s;
  ::placeholder {
    color: ${THEME.black500};
    text-align: left;
  }
  &:focus {
    outline: none;
    border: 2px solid ${THEME.primary};
  }
  margin: 1rem 0;
`;
