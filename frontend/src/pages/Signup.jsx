import { useState } from "react";
import { useNavigate } from "react-router-dom";
import useLoading from "../hooks/useLoading";
import { useAlert } from "../hooks/useAlert";
import SelectPage from "./OnBoard/SelectPage";
import SignupPage from "./OnBoard/SignupPage";
import LastPage from "./OnBoard/LastPage";
import SuccessPage from "./OnBoard/SuccessPage";
import { apiSignupChildren, apiSignupParent } from "../apis/users";

export default function Signup() {
  const [page, setPage] = useState(0);
  const [userType, setUserType] = useState(""); //child || parent
  const [userid, setUserid] = useState("");
  const [psword, setPsword] = useState("");
  const [repsword, setRepsword] = useState("");
  const [randomCode, setRandomCode] = useState("");
  const [houseName, sethouseName] = useState("");
  const [childName, setchildName] = useState("");

  const navigate = useNavigate();

  const { load, endLoad } = useLoading();
  const { push, closeAll } = useAlert();

  const handleSubmit = async () => {
    load();
    try {
      const response =
        userType === "parent"
          ? await apiSignupParent({ userid, psword, childName, houseName })
          : await apiSignupChildren({ userid, psword, randomCode });
      if (response.status === 200) {
        push({
          message: "회원가입 성공!",
          buttonText: "확인",
          onClose: () => {},
        });
        setTimeout(() => {
          load();
          navigate("/login");
        }, 1000);
      } else {
        endLoad();
        push({
          message: "정보를 다시한번 확인해주세요!",
          buttonText: "확인",
          onClose: () => {},
        });
      }
    } catch (error) {
      endLoad();
      push({
        message: "정보를 다시한번 확인해주세요!",
        buttonText: "확인",
        onClose: () => {},
      });
    }
  };

  if (page === -1) {
    return navigate("/login");
  }

  // 부모 / 자식 선택페이지
  if (page === 0) {
    return (
      <SelectPage
        userType={userType}
        setUserType={setUserType}
        setPage={setPage}
      />
    );
  }

  // 아이디 / 비번 설정 페이지
  if (page === 1) {
    return (
      <SignupPage
        userid={userid}
        setUserid={setUserid}
        psword={psword}
        setPsword={setPsword}
        repsword={repsword}
        setRepsword={setRepsword}
        setPage={setPage}
      />
    );
  }

  //
  if (page === 2) {
    return (
      <LastPage
        houseName={houseName}
        setHouseName={sethouseName}
        childName={childName}
        setChildName={setchildName}
        randomCode={randomCode}
        setRandomCode={setRandomCode}
        userType={userType}
        setPage={setPage}
      />
    );
  }

  if (page === 3) {
    return (
      <SuccessPage
        onClickBtn={handleSubmit}
        userid={userid}
        userType={userType}
        childName={childName}
        houseName={houseName}
        setPage={setPage}
      />
    );
  }
}
