import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

// 기본 여백 삭제
export const GlobalStyles = createGlobalStyle`
  ${reset}
  /* @import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=League+Gothic&family=Noto+Sans+KR&display=swap"); */
  /* @font-face {
  font-family: "GmarketSansLight";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansLight.woff") format("woff");
  font-weight: normal;
  font-style: normal;
  } */
  :root {
    /* font-family: "GmarketSansMedium"; */
  }
`;
