import React from 'react';
import styled from 'styled-components';
import Checkbox from '../components/Checkbox';

function CheckboxPage () {

    const Data = [
        { id: 0, text: '설거지' },
        { id: 1, text: '이불개기' },
        { id: 2, text: '방청소' },
        { id: 3, text: '스트레칭하기' },
        { id: 4, text: '부모님과 대화하기' },
        { id: 5, text: '산책하기' },
      ];

  return (
    <main>
    <StyledH1>오늘의 할일을 고르세요.</StyledH1>
    <form>
      <StyledFieldset>
        {Data.map((item) => (
          <Checkbox key={item.id} text={item.text} />
        ))}
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
  padding: 2rem;
  border: 2px solid gainsboro;
  border-radius: 0.5rem;
  
`;

const StyledH1 = styled.h1`
  font-size: 1.25rem;
  padding: 2rem;
`;