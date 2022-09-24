import Layout from "../components/Layout";
import Input from "../components/atoms/Input";
import styled from "styled-components";
import { useState } from "react";

export default function Login() {
  const [userid, setUserid] = useState("");
  const [psword, setPsword] = useState("");

  return (
    <Layout hasFooter={false}>
      <div class="d-flex flex-column align-items-center">
        <Input value={userid} setValue={setUserid} placeholder={"아이디"} />
        <Input value={psword} setValue={setPsword} placeholder={"비밀번호"} />
      </div>
    </Layout>
  );
}
