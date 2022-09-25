export const getFullDate = () => {
  let today = new Date();
  let year = today.getFullYear();
  let month = today.getMonth() + 1;
  if (month < 10) month = "0" + month;
  let day = today.getDate();
  if (day < 10) day = "0" + day;
  return [year, month, day];
};

export const getLevel = (exp) => {
  exp = parseInt(exp);
  if (exp === 600) return [6, 100];
  let level = 1;
  level += Math.floor(exp / 100);
  let curLevelExp = exp % 100;
  return [level, curLevelExp];
};

export const getMainImgByLevel = (level) => {
  switch (level) {
    case 1:
      return "LevelOne.png";
    case 2:
      return "LevelTwo.png";
    case 3:
      return "LevelThree.png";
    case 4:
      return "LevelFour.png";
    case 5:
      return "LevelFive.png";
    case 6:
      return "LevelSix.png";
    default:
      return "LevelZero.png";
  }
};
