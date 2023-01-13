import React from "react";
import styled from "styled-components";

const Overlay = styled.div`
  position: absolute;
  width: 100vw;
  height: 100%;
  top: 0;
  z-index: 9;
  overflow: hidden;
  background-color: #0009;
  display: flex;
  justify-content: center;
  align-items: center;
`;

 const ModalContainer = styled.section`
  min-width: 250px;
  min-height: 250px;
  max-height: calc(100vh - 20px);
  padding: 20px;
  z-index: 19;
  overflow-y: auto;
  background-color: #fff;
  box-shadow: 0 0 10px black;
  border-radius: 4px;
  position: relative;
  > span {
    position: absolute;
    top: 15px;
    right: 20px;
    font-size: 30px;
    cursor: pointer;
    transition: 0.2s;
    :hover {
      text-shadow: 0 4px 10px var(--bgPrimary);
      transform: scale(1.2);
    }
    :active {
      transform: scale(0.95);
    }
  }
  > header {
    font-weight: bold;
    font-size: 24px;
    text-align: center;
    margin: 0 20px;
  }
`;

function Modal({ title, children, handleClose, ...rest }) {
    return (
        <Overlay>
            <ModalContainer {...rest}>
                <header>{title}</header>
                <span onClick={handleClose}>&times;</span>
                {children}
            </ModalContainer>
        </Overlay>
    );
}

export default Modal;