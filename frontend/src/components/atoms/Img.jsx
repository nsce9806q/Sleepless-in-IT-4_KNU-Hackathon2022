import styled from "styled-components";

export default function Img({ src, size, ratio, alt = "image" }) {
  return (
    <StyledImg
      src={process.env.PUBLIC_URL + "/img/" + src}
      size={size}
      ratio={ratio}
      alt={alt}
    />
  );
}

const StyledImg = styled.img`
  width: ${(p) => p.size || "100%"};
  aspect-ratio: ${(p) => p.ratio || "1 / 1"};
`;
