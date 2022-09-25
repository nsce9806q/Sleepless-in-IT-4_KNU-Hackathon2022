import { useState } from "react";
import styled from "styled-components";
import Checkbox from "../components/Checkbox";
import { THEME } from "../constants/colors";
import { useAlert } from "../hooks/useAlert";

function CheckboxPage(props) {
  const [dataForm, setDataForm] = useState(props.Data);

  const changeCheck = (id) => {
    console.log(id);
    let temp = [...dataForm];
    const index = temp.findIndex((x) => x.id === id);
    if (index === -1) return;
    temp[index].isChecked = !temp[index].isChecked;
    setDataForm(temp);
  };

  const { push } = useAlert();

  const handleSubmit = () => {
    // alert(JSON.stringify(dataForm));
    push({
      message: "성공하셨습니다!",
      buttonText: "확인",
      onClose: () => {},
    });
  };

  return (
    <main>
      <form>
        <StyledFieldset>
          <div stlye={{ marginTop: "2rem" }}></div>
          <Text>고정 질문</Text>
          {dataForm
            .map((item, idx) => (
              <StyledDiv color={idx >= 3 && THEME.lighter}>
                <Checkbox
                  img={props.img}
                  key={item.id}
                  text={item.text}
                  onChange={() => {
                    changeCheck(item.id);
                  }}
                />
              </StyledDiv>
            ))
            .slice(0, 3)}
          <Line></Line>
          <Text>오늘의 질문</Text>
          {dataForm
            .map((item, idx) => (
              <StyledDiv color={idx >= 3 && THEME.lighter}>
                <Checkbox
                  img={props.img}
                  key={item.id}
                  text={item.text}
                  onChange={() => {
                    changeCheck(item.id);
                  }}
                />
              </StyledDiv>
            ))
            .slice(3)}
          <br />
          <button type="button" class="btn btn-warning" onClick={handleSubmit}>
            선택 완료!
          </button>
        </StyledFieldset>
      </form>
    </main>
  );
}

export default CheckboxPage;

const Text = styled.span`
  color: ${THEME.black700};
  font-size: 1.2rem;
`;

const Line = styled.div`
  height: 3px;
  background-color: ${THEME.black500};
  margin: 1rem 0;
  box-sizing: border-box;
  width: 100%;
`;

const StyledFieldset = styled.fieldset`
  display: flex;
  flex-direction: column;
  width: 85%;
  margin: auto;
  gap: 1rem;
`;

const StyledDiv = styled.div`
  font-size: 1.25rem;
  border-radius: 10px;
  background-color: ${(p) => p.color || THEME.primary};
  opacity: 0.8;
  padding: 1rem 1rem;
  transition: 0.5s;
  &:hover {
    opacity: 1;
  }
`;
// #F7EA45
