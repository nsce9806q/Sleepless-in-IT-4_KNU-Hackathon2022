import { useState } from 'react';
import styled from 'styled-components';
import Checkbox from '../components/Checkbox';

function CheckboxPage (props) {

    
    const[dataForm, setDataForm]=useState(props.Data)

    const changeCheck = (id) => {
      console.log(id);
      let temp = [...dataForm];
      const index = temp.findIndex((x) => x.id === id);
      if (index === -1) return;
      temp[index].isChecked = !temp[index].isChecked;
      setDataForm(temp);
    };

    const handleSubmit = () => {
      alert(JSON.stringify(dataForm));
    };

  return (
    <main>
    <StyledH1>오늘의 질문</StyledH1>
    <form>
      <StyledFieldset>
        {dataForm.map((item) => (
          <Checkbox img={props.img}  key={item.id} text={item.text} onChange={()=>{
            changeCheck(item.id)
          }}/>
        ))}
        <br/>
        <button type="button" class="btn btn-secondary" onClick={handleSubmit}>선택 완료!</button>
      </StyledFieldset>
    </form>
  </main>
  )
}

export default CheckboxPage;

const StyledFieldset = styled.fieldset`
  display: flex;
  flex-direction: column;
  width: 70%;
  margin: auto;
`;

const StyledH1 = styled.h1`
  font-size: 1.25rem;
  text-align: center;
  padding: 1.25rem;
`;