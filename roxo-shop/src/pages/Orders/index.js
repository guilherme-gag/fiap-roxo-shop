import React, {useEffect, useState} from "react";
import Table from "../../components/Table";
import styled from "styled-components";
import {createOrder, deleteOrder, getOrders} from "../../services/orders";
import Swal from "sweetalert2";
import {getProducts} from "../../services/products";
import Modal from "../../components/Modal";
import {getCostumers} from "../../services/costumers";

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

function Orders() {
    const [orders, setOrders] = useState([
        {
            id: 1,
            customerId: 10,
            customerName: "CostumerName",
            productId: 20,
            productName: "ProductName",
            productPrice: 130.00,
            quantity: 35
        },
    ]);

    const [products, setProducts] = useState([
        {id: 1, name: "produto", price: "10.00"},
        {id: 2, name: "produto2", price: "20.00"}
    ]);

    const [costumers, setCostumers] = useState([
        {
            id: 1,
            name: "Vinicius"
        },
        {
            id: 2,
            name: "Gui"
        },
    ]);

    const [open, setOpen] = useState(false);

    const [newOrderCostumer, setNewOrderCostumer] = useState("")
    const [newOrderProduct, setNewOrderProduct] = useState("")
    const [newOrderQuantity, setNewOrderQuantity] = useState("")

    useEffect(() => {
        searchOrders()
        searchProducts()
        searchCostumers()
    }, []);

    const searchOrders = () => {
        getOrders().then(res => setOrders(res.data)).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const searchProducts = () => {
        getProducts().then(res => setProducts(res.data)).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const searchCostumers = () => {
        getCostumers().then(res => setCostumers(res.data)).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }
    const onCreate = (order) => {
        createOrder(order).then((r) => {
            setOrders([...orders, r.data])
        }).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const onDelete = (order) => {
        deleteOrder(order.id).then(() => {
            setOrders((prevState) => prevState.filter((o) => o.id !== order.id))
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

        const costumer = costumers.find((costumer) => costumer.id == newOrderCostumer)
        const product = products.find((product) => product.id == newOrderProduct)

        onCreate({
            customerId: costumer.id,
            customerName: costumer.name,
            productId: product.id,
            productName: product.name,
            productPrice: product.price,
            quantity: newOrderQuantity
        })
    };

    return (
        <Container>
            <Table
                title={'Orders'}
                model={orders}
                hasDelete
                onDelete={onDelete}
                openModal={openModal}
            />

            {open && (
                <Modal
                    title="New Order"
                    handleClose={() => setOpen(false)}
                    style={{width: "500px"}}
                >
                    <Form onSubmit={onSubmit}>
                        <select value={newOrderCostumer} onChange={(e) => setNewOrderCostumer(e.target.value)}>
                            {costumers.map((costumer) => {
                                return (
                                    <option value={costumer.id}>{costumer.name}</option>
                                )
                            })}
                        </select>
                        <select value={newOrderProduct} onChange={(e) => setNewOrderProduct(e.target.value)}>
                            {products.map((product) => {
                                return (
                                    <option value={product.id}>{product.name}</option>
                                )
                            })}
                        </select>
                        <input type='number' placeholder="Digite a quantidade" value={newOrderQuantity}
                               onChange={(e) => setNewOrderQuantity(e.target.value)}/>
                        <button onClick={() => {
                        }}>Salvar
                        </button>
                    </Form>
                </Modal>
            )}
        </Container>
    );
}

export default Orders;