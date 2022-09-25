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
    <form>
      <StyledFieldset>
        {dataForm.map((item) => (
          <StyledDiv>
            <Checkbox img={props.img}  key={item.id} text={item.text} onChange={()=>{
            changeCheck(item.id)
          }}/>
          </StyledDiv>
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
  width: 80%;
  margin: auto;
`;

const StyledDiv = styled.div`
  font-size: 1.25rem;
  padding: 0.5rem;
`;