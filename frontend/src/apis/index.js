import axios from "axios";

const { REACT_APP_SERVER_URL } = process.env;

const mainAxios = axios.create({
  baseURL: `${REACT_APP_SERVER_URL}/api`,
  withCredentials: true,
  auth: {
    username: JSON.parse(localStorage.getItem("auth"))?.userid,
    password: JSON.parse(localStorage.getItem("auth"))?.psword,
  },
});

export default mainAxios;
