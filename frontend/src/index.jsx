import App from "./App";
import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { MantineProvider } from "@mantine/core";
import { AuthProvider } from "./contexts/AuthProvider";
import { GlobalStyles } from "./commonStyles";

const mantineStyle = {
  // fontFamily: "GmarketSansMedium, sans-serif",
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Router>
      <GlobalStyles />
      <MantineProvider theme={mantineStyle}>
        <AuthProvider>
          <Routes>
            <Route path="/*" element={<App />} />
          </Routes>
        </AuthProvider>
      </MantineProvider>
    </Router>
  </React.StrictMode>
);
