import styled from "styled-components";

export default function Input({ value, setValue, placeholder }) {
  return (
    <StyledInput
      value={value}
      onChange={(e) => setValue(e.target.value)}
      placeholder={placeholder}
    />
  );
}

const StyledInput = styled.input`
  /* font-size: 0.9rem;
  line-height: 2rem;
  color: black;
  text-align: left;
  border: none;
  border-bottom: 2px solid #d2d2d2;
  width: 18rem;
  ::placeholder {
    color: #d2d2d2;
    text-align: left;
  }
  &:focus {
    outline: none;
  }
  margin-top: 2rem;
  margin-bottom: 2rem; */
`;
