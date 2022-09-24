import { useContext } from "react";
import { LoadingContext } from "../contexts/LoadingProvider";

const useLoading = () => useContext(LoadingContext);

export default useLoading;
