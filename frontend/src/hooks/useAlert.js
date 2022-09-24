import { useContext } from "react";
import { AlertContext } from "../contexts/AlertProvider";

export const useAlert = () => useContext(AlertContext);
