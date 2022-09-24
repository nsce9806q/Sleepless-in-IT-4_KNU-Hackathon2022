import React from "react";
import styled from "styled-components";

function Checkbox({ text }) {
  return (
    <>
      <StyledInput type="checkbox" id={text} name={text}/>
      <StyledLabel selected={text} htmlFor={text}>
        <StyledP>{text}</StyledP>
      </StyledLabel>
    </>
  );
}

export default Checkbox;

const StyledLabel = styled.label`
  position: relative;
  display: flex;
  align-items: center;
  user-select: none;
  cursor: default;
  &:before {
    display: block;
    content: "";
    height: 2rem;
    width: 2rem;
    background-color: white;
    border: 2px solid gainsboro;
    border-radius: 0.35rem;
  }
  &:after {
    position: absolute;
    top: 50%;
    left: 0;
    transform: translateY(-50%);
    display: block;
    opacity: 0;
    content: "";
    height: 2rem;
    width: 2rem;
    border: 2px solid transparent;
    border-radius: 0.35rem;
    background-image: url(${(p) => (p.selected ? "https://cdn-icons-png.flaticon.com/512/163/163801.png" : "https://cdn-icons-png.flaticon.com/512/1662/1662973.png")});
    background-size: 100% 100%;
    background-position: 50%;
    background-repeat: no-repeat;
    background-color: LightBlue;
  }
`;

const StyledInput = styled.input`
  position: absolute;
  clip: rect(0 0 0 0);
  clip-path: inset(50%);
  height: 4px;
  overflow: hidden;
  white-space: nowrap;
  width: 4px;
  &:checked + ${StyledLabel} {
    :after {
      opacity: 1;
    }
  }
`;

const StyledP = styled.p`
  margin-left: 0.5rem;
  font-size: 1.5rem;
`;