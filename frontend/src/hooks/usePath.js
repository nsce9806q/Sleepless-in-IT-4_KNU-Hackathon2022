import { useLocation } from "react-router-dom";

function usePath() {
  const location = useLocation();
  function getNthPath(nth) {
    const pathnameArray = location.pathname.split("/");
    if (pathnameArray.length <= nth) return "";
    return pathnameArray[nth];
  }

  return { getNthPath };
}

export default usePath;
