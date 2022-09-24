import { useState } from 'react';
import styled from 'styled-components';
import Checkbox from '../components/Checkbox';

function CheckboxPage () {

    let Data = [
        { id: 0, text: '설거지',isChecked: false },
        { id: 1, text: '이불개기' ,isChecked: false },
        { id: 2, text: '방청소' ,isChecked: false },
        { id: 3, text: '스트레칭하기' ,isChecked: false },
        { id: 4, text: '부모님과 대화하기' ,isChecked: false },
        { id: 5, text: '산책하기' ,isChecked: false },
      ];
    
    const[dataForm, setDataForm]=useState(Data)

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
    <StyledH1>오늘의 할일을 고르세요.</StyledH1>
    <form>
      <StyledFieldset>
        {dataForm.map((item) => (
          <Checkbox key={item.id} text={item.text} checked={item.isChecked} onChange={()=>{
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
  width: 50%;
  margin: auto;
  padding: 1.5rem;
  border: 2px solid gainsboro;
  border-radius: 0.5rem;

`;

const StyledH1 = styled.h1`
  font-size: 1.25rem;
  text-align: center;
  padding: 1.25rem;
`;