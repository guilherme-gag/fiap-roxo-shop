import React, {useEffect, useState} from "react";
import PropTypes from "prop-types";
import styled from "styled-components";
import Modal from "../Modal";

const StyledTable = styled.table`
  border: 1px solid #000;
  width: 50vw;
  font-size: 16px;
`
const StyledTableRow = styled.tr`
  border: 1px solid #000;
`
const StyledTableData = styled.td`
  padding: 10px;
`
const Container = styled.div`
  width: fit-content;
`

const Header = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`

const Button = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`

const Form = styled.form`
  display: flex;
  flex-direction: column;
  gap: 10px;
  height: 100%;
`

function Table({title, model, hasEdit, hasDelete, onEdit, onDelete, openModal}) {

    const [properties, setProperties] = useState([])

    useEffect(() => {
        setProperties(Object.getOwnPropertyNames(model[0]))
    }, [model])

    return (
        <Container>
            <Header>
                <h2>{title}</h2>
                <Button>
                    <button onClick={openModal}>New {title}</button>
                </Button>
            </Header>
            <StyledTable>
                <thead>
                <StyledTableRow>
                    {properties.map((property) => {
                        return (<StyledTableData key={property}>{property}</StyledTableData>)
                    })}
                </StyledTableRow>
                </thead>
                <tbody>
                {model.map((m) => {
                    const row = properties.map((property, index) => {
                        return (
                            <StyledTableData key={`${m[property]}${index}`}>{m[property]}</StyledTableData>
                        )
                    })

                    return (
                        <StyledTableRow key={m.id}>
                            {row}
                            {!hasEdit ||
                                <StyledTableData>
                                    <button onClick={() => onEdit(m)}>Edit</button>
                                </StyledTableData>
                            }
                            {!hasDelete ||
                                <StyledTableData>
                                    <button onClick={() => onDelete(m)}>Delete</button>
                                </StyledTableData>
                            }
                        </StyledTableRow>
                    )
                })}
                </tbody>
            </StyledTable>
        </Container>
    );
}

Table.propTypes = {
    title: PropTypes.string.isRequired,
    model: PropTypes.array,
    hasDelete: PropTypes.bool,
    hasEdit: PropTypes.bool,
    onEdit: PropTypes.func,
    onDelete: PropTypes.func,
    openModal: PropTypes.func.isRequired,
};

Table.defaultProps = {
    model: {id: 0},
    hasDelete: false,
    hasEdit: false,
}

export default Table;