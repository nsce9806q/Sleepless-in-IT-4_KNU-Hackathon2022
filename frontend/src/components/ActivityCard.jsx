import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

export default function ActivityCard() {
  return (
    <Card style={{ width: '100%' }}>
      <Card.Img variant="top" src="/img/img1.jpg" />
      <Card.Body>
        <Card.Title>Card Title</Card.Title>
        <Card.Text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </Card.Text>
        <br/>
        <Button variant="Danger">Go somewhere</Button>
      </Card.Body>
    </Card>
  );
}