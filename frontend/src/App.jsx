import { GlobalStyles } from "./commonStyles";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { MantineProvider } from "@mantine/core";

import Mainpage from "./pages/Mainpage";

const mantineStyle = {
  // fontFamily: "GmarketSansMedium, sans-serif",
};

function App() {
  return (
    <Router>
      <GlobalStyles />
      <MantineProvider theme={mantineStyle}>
        <Routes>
          <Route path="/" element={<Mainpage />} />
        </Routes>
      </MantineProvider>
    </Router>
  );
}

export default App;
