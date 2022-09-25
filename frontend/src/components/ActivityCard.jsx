import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import styled from "styled-components";

export default function ActivityCard({ src, title, content }) {
  return (
    <Card style={{ width: "100%" }}>
      {/* <Card.Img style={{ objectFit: "cover" }} variant="top" src={src} /> */}
      <StyledImg src={src}></StyledImg>
      <Card.Body>
        <Card.Title>{title}</Card.Title>
        <Card.Text>{content}</Card.Text>
        <br />
        <Button variant="Danger">{"신청하기"}</Button>
      </Card.Body>
    </Card>
  );
}

const StyledImg = styled.img`
  width: 100%;
  aspect-ratio: 3 / 2;
  object-fit: contain;
`;
