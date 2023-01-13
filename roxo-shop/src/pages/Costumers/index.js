import React, {useEffect, useState} from "react";
import Table from "../../components/Table";
import styled from "styled-components";
import {createCostumer, deleteCostumer, getCostumers, updateCostumer} from "../../services/costumers";
import Swal from "sweetalert2";
import Modal from "../../components/Modal";

const Container = styled.div`
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: calc(10px + 2vmin);
`

const Form = styled.form`
  display: flex;
  flex-direction: column;
  gap: 10px;
  height: 100%;
`

function Costumers() {
    const [costumers, setCostumers] = useState([
        {
            id: 1,
            name: "Costumer"
        },
    ]);

    const [open, setOpen] = useState(false);
    const [openEdit, setOpenEdit] = useState(false);

    const [newCostumerName, setNewCostumerName] = useState("")

    const [updateCostumerId, setUpdateCostumerId] = useState("")
    const [updateCostumerName, setUpdateCostumerName] = useState("")

    useEffect(() => {
        searchCostumers()
    }, []);

    const searchCostumers = () => {
        getCostumers().then(res => setCostumers(res.data)).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const onCreate = (costumer) => {
        createCostumer(costumer).then((r) => {
            setCostumers([...costumers, r.data])
        }).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const onDelete = (costumer) => {
        deleteCostumer(costumer.id).then(() => {
            setCostumers((prevState) => prevState.filter((c) => c.id !== costumer.id))
        }).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const onEdit = (costumer) => {
        setUpdateCostumerId(costumer.id)
        setUpdateCostumerName(costumer.name)

        setOpenEdit(true);
    }

    const onUpdate = (costumer) => {
        updateCostumer(costumer).then(() => {
            searchCostumers()
        }).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const openModal = () => {
        setOpen(true);
    }

    const onSubmit = (event) => {
        event.preventDefault();
        onCreate({name : newCostumerName})
    };

    const onSubmitUpdate = (event) => {
        event.preventDefault();
        onUpdate({id: updateCostumerId, name: updateCostumerName})
    };

    return (
        <Container>
            <Table
                title={'Costumers'}
                model={costumers}
                hasEdit
                hasDelete
                onDelete={onDelete}
                onEdit={onEdit}
                openModal={openModal}
            />
            {open && (
                <Modal
                    title="New Costumer"
                    handleClose={() => setOpen(false)}
                    style={{width: "500px"}}
                >
                    <Form onSubmit={onSubmit}>
                        <input placeholder="Digite o nome" value={newCostumerName} onChange={(e)=> setNewCostumerName(e.target.value)}/>
                        <button onClick={() => {}}>Salvar</button>
                    </Form>
                </Modal>
            )}
            {openEdit && (
                <Modal
                    title="Edit Costumer"
                    handleClose={() => setOpenEdit(false)}
                    style={{width: "500px"}}
                >
                    <Form onSubmit={onSubmitUpdate}>
                        <input placeholder="Digite o nome" value={updateCostumerName}
                               onChange={(e) => setUpdateCostumerName(e.target.value)}/>
                        <button onClick={() => {
                        }}>Salvar
                        </button>
                    </Form>
                </Modal>
            )}
        </Container>
    );
}

export default Costumers;