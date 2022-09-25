import useLoading from "../hooks/useLoading";
import styled from "styled-components";
import { useEffect } from "react";

export default function Loading() {
  const { load, endLoad } = useLoading();

  useEffect(() => {
    load();
    setTimeout(() => {
      endLoad();
    }, 300);
  }, []);

  return <Div></Div>;
}

const Div = styled.div`
  width: 100%;
  height: 90vh;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 3rem;
`;
