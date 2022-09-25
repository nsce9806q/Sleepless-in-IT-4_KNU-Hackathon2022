import axios from "./index";

export const apiLogin = async ({ userid, psword }) =>
  axios.post("/login", { loginId: userid, password: psword });

export const apiSignupParent = async ({
  userid,
  psword,
  childName,
  houseName,
}) =>
  axios.post(
    "/signup/parent",
    {},
    {
      params: { loginId: userid, password: psword, childName, houseName },
    }
  );

export const apiSignupChildren = async ({
  userid: loginId,
  psword: password,
  randomCode,
}) =>
  axios.post(
    "/signup/children",
    {},
    { params: { loginId, password, randomCode } }
  );
