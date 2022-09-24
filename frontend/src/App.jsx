import { Routes, Route } from "react-router-dom";

import Landing from "./pages/Landing";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import Mainpage from "./pages/Mainpage";
import Question from "./pages/Question";
import QuestionChild from "./pages/QuestionChild";
import QuestionParent from "./pages/QuestionParent";
import Activity from "./pages/Activity";
import ActivityInside from "./pages/AcitivityInside";
import Myhome from "./pages/Myhome";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/main" element={<Mainpage />} />
        <Route path="/question" element={<Question />} />
        <Route path="/question/child" element={<QuestionChild />} />
        <Route path="/question/parent" element={<QuestionParent />} />
        <Route path="/activity" element={<Activity />}/>
        <Route path="/activity/inside" element={<ActivityInside />}/>
        <Route path="/myhome" element={<Myhome />} />
      </Routes>
    </>
  );
}

export default App;
