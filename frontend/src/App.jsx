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
        <Route path="/Question" element={<Question />} />
        <Route path="/Activity" element={<Activity />} />
        <Route path="/Myhome" element={<Myhome />} />
        
      </Routes>
    </>
  );
}

export default App;
