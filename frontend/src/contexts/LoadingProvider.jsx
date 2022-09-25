import { createContext, useEffect, useState } from "react";
import { AnimatePresence, motion } from "framer-motion";
import styled from "styled-components";
import { useAlert } from "../hooks/useAlert";
import Img from "../components/atoms/Img";
import { useLocation } from "react-router-dom";

export const LoadingContext = createContext({
  load: () => {},
  endLoad: () => {},
});

const LoadingContextProvider = ({ children }) => {
  const location = useLocation();
  const [loading, setLoading] = useState(false);
  const { closeAll } = useAlert();

  const load = () => {
    closeAll();
    setLoading(true);
  };

  const endLoad = () => {
    setLoading(false);
  };

  useEffect(() => {
    endLoad();
  }, [location]);

  return (
    <LoadingContext.Provider
      value={{
        load,
        endLoad,
      }}
    >
      <AnimatePresence>
        {loading && (
          <LoadingContainer
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            exit={{ opacity: 0, transition: { duration: 0.2 } }}
          >
            <Img ratio={"auto"} src={"HoBanCow.png"} alt="home" />
          </LoadingContainer>
        )}
      </AnimatePresence>
      {children}
    </LoadingContext.Provider>
  );
};

export default LoadingContextProvider;

const LoadingContainer = styled(motion.div)`
  width: 100vw;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 10000;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(0, 0, 0, 0.1);
  z-index: 20000000;
  img {
    @keyframes hithere {
      30% {
        transform: scale(1.2);
      }
      40%,
      60% {
        transform: rotate(-20deg) scale(1.2);
      }
      50% {
        transform: rotate(20deg) scale(1.2);
      }
      70% {
        transform: rotate(0deg) scale(1.2);
      }
      100% {
        transform: scale(1);
      }
    }
    animation: hithere 1s ease infinite;

    width: 100px;
  }
`;
