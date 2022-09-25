import { createContext, useState, useEffect } from "react";

export const AuthContext = createContext({});

const AuthProvider = ({ children }) => {
  const [auth, setAuth] = useState(
    JSON.parse(localStorage.getItem("auth")) || {
      token: "",
      houser_id: "",
      house_name: "",
      id: "",
      type: "",
    }
  );

  useEffect(() => {
    localStorage.setItem("auth", JSON.stringify(auth));
  }, [auth]);

  return (
    <AuthContext.Provider value={{ auth, setAuth }}>
      {children}
    </AuthContext.Provider>
  );
};

export default AuthProvider;
