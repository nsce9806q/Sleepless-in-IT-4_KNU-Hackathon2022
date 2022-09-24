export default function Img({ src, alt = "image" }) {
  return <img src={process.env.PUBLIC_URL + "/img/" + src} alt={alt} />;
}
