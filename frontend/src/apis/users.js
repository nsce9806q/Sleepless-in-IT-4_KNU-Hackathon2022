import axios from "./index";

export const apiLogin = async ({ userid, psword }) =>
  axios.post("/login", { userid, psword });
