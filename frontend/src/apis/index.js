import axios from "axios";

const { REACT_APP_SERVER_URL } = process.env;

const mainAxios = axios.create({
  baseURL: `${REACT_APP_SERVER_URL}`,
  withCredentials: true,
});

export default mainAxios;
