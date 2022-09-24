import App from "./App";
import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { MantineProvider } from "@mantine/core";
import { GlobalStyles } from "./commonStyles";
import "bootstrap/dist/css/bootstrap.min.css";
import AuthProvider from "./contexts/AuthProvider";
import AlertProvider from "./contexts/AlertProvider";
import LoadingProvider from "./contexts/LoadingProvider";

const mantineStyle = {
  fontFamily: "GangwonEdu_OTFBoldA, sans-serif",
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Router>
      <GlobalStyles />
      <MantineProvider theme={mantineStyle}>
        <AlertProvider>
          <LoadingProvider>
            <AuthProvider>
              <Routes>
                <Route path="/*" element={<App />} />
              </Routes>
            </AuthProvider>
          </LoadingProvider>
        </AlertProvider>
      </MantineProvider>
    </Router>
  </React.StrictMode>
);
