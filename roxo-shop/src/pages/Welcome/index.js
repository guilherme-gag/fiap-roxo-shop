import React from "react";
import styled from "styled-components";
import {useNavigate} from "react-router-dom";

const Container = styled.div`
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: 16px;
`

function Welcome() {
    const navigate = useNavigate();

    return (
        <Container>
            <header>
                <p>
                    🎊🎊🎊 Boas vindas ao Roxo Shop 🎊🎊🎊
                </p>
            </header>
            <button onClick={()=> navigate("/products")}>Products</button>
            <button onClick={()=> navigate("/orders")}>Orders</button>
            <button onClick={()=> navigate("/costumers")}>Costumers</button>
        </Container>
    );
}

export default Welcome;