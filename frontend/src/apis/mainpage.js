import axios from "./index";

export const apiGetMainpage = async () => {
  const houseId = JSON.parse(localStorage.getItem("auth")).house_id;
  return axios.get(`/main/${houseId}`, {
    headers: {
      Authorization: JSON.parse(localStorage.getItem("auth")).access_token,
    },
  });
};
