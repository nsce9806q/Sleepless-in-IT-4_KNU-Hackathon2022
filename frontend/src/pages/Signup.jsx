import LoginInput from "../components/atoms/LoginInput";
import { useState } from "react";
import Btn from "../components/atoms/Btn";
import Img from "../components/atoms/Img";
import styled from "styled-components";
import { THEME } from "../constants/colors";
import { Link, useNavigate } from "react-router-dom";
import useLoading from "../hooks/useLoading";
import { useAlert } from "../hooks/useAlert";
import SelectPage from "./OnBoard/SelectPage";
import SignupPage from "./OnBoard/SignupPage";
import LastPage from "./OnBoard/LastPage";
import SuccessPage from "./OnBoard/SuccessPage";

export default function Signup() {
  const [page, setPage] = useState(0);
  const [userType, setUserType] = useState(""); //child || parent
  const [userid, setUserid] = useState("");
  const [psword, setPsword] = useState("");
  const [repsword, setRepsword] = useState("");
  const [homecode, setHomecode] = useState("");
  const [homename, setHomename] = useState("");
  const [childname, setChildname] = useState("");

  const navigate = useNavigate();

  // const { load, endLoad } = useLoading();
  // const { push } = useAlert();

  if (page === -1) {
    console.log("? 왜여기");
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
        homename={homename}
        setHomename={setHomename}
        childname={childname}
        setChildname={setChildname}
        homecode={homecode}
        setHomecode={setHomecode}
        userType={userType}
        setPage={setPage}
      />
    );
  }

  if (page === 3) {
    return (
      <SuccessPage
        userid={userid}
        userType={userType}
        childname={childname}
        homename={homename}
        setPage={setPage}
      />
    );
  }
}
