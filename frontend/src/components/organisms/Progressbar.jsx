import { Progress } from "@mantine/core";
import { THEME } from "../../constants/colors";

export default function Progressbar({ data, type, size }) {
  const getColorByType = (type) => {
    switch (type) {
      case "attendance":
        return THEME.lighter;
      case "communication":
        return THEME.secondary;
      case "activity":
        return THEME.thirdcolor;
      default:
        return THEME.primary;
    }
  };

  const getValueByType = (type) => {
    switch (type) {
      case "attendance":
        return (data / 7) * 100;
      case "communication":
        if (data < 20) return 20;
        return data;
      case "activity":
        if (data < 20) return 20;
        return data;
      default:
        return data;
    }
  };

  const getLabelByType = (type) => {
    switch (type) {
      case "attendance":
        return Math.floor(data % 7) + "일";
      case "communication":
        data /= 100;
        if (data <= 0.333) return "뜸해요";
        else if (data <= 0.666) return "평범해요";
        else if (data <= 1) return "더 자주해요";
        else return "뜸해요";
      case "activity":
        if (data <= 0.333) return "부족해요";
        else if (data <= 0.666) return "평범해요";
        else if (data <= 1) return "더 자주해요";
        else return "부족해요";
      default:
        return data + "%";
    }
  };

  return (
    <>
      <Progress
        value={getValueByType(type)}
        color={getColorByType(type)}
        label={getLabelByType(type)}
        size={size}
        radius="xl"
      />
    </>
  );
}
