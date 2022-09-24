import { Routes, Route } from "react-router-dom";

import Mainpage from "./pages/Mainpage";
import Question from "./pages/Question";
import Activity from "./pages/Activity";
import Myhome from "./pages/Myhome";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Mainpage />} />
        <Route path="/question" element={<Question />} />
        <Route path="/activity" element={<Activity />} />
        <Route path="/myhome" element={<Myhome />} />
        
      </Routes>
    </>
  );
}

export default App;
