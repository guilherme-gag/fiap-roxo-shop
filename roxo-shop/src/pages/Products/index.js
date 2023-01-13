import React, {useEffect, useState} from "react";
import {createProduct, deleteProduct, getProducts, updateProduct} from "../../services/products";
import Table from "../../components/Table";
import styled from "styled-components";
import Swal from 'sweetalert2'
import Modal from "../../components/Modal";

const Container = styled.div`
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: 16px;
`

const Form = styled.form`
  display: flex;
  flex-direction: column;
  gap: 10px;
  height: 100%;
`

function Products() {

    const [products, setProducts] = useState([
        {id: 1, name: "produto", price: "10.00"},
        {id: 2, name: "produto2", price: "20.00"}
    ]);
    const [open, setOpen] = useState(false);
    const [openEdit, setOpenEdit] = useState(false);

    const [newProductName, setNewProductName] = useState("")
    const [newProductPrice, setNewProductPrice] = useState("")

    const [updateProductId, setUpdateProductId] = useState("")
    const [updateProductName, setUpdateProductName] = useState("")
    const [updateProductPrice, setUpdateProductPrice] = useState("")

    useEffect(() => {
        searchProducts()
    }, []);

    const searchProducts = () => {
        getProducts().then(res => setProducts(res.data)).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const onCreate = (product) => {
        createProduct(product).then((r) => {
            setProducts([...products, r.data])
        }).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const onDelete = (product) => {
        deleteProduct(product.id).then(() => {
            setProducts((prevState) => prevState.filter((p) => p.id !== product.id))
        }).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const onUpdate = (product) => {
        updateProduct(product).then(() => {
            searchProducts()
        }).catch(err => {
            Swal.fire(
                err.name,
                `${err.code}: ${err.message}`,
                'error'
            )
        })
    }

    const onEdit = (product) => {
        setUpdateProductId(product.id)
        setUpdateProductName(product.name)
        setUpdateProductPrice(product.price)

        setOpenEdit(true);
    }

    const openModal = () => {
        setOpen(true);
    }

    const onSubmit = (event) => {
        event.preventDefault();
        onCreate({name: newProductName, price: newProductPrice})
    };

    const onSubmitUpdate = (event) => {
        event.preventDefault();
        onUpdate({id: updateProductId, name: updateProductName, price: updateProductPrice})
    };

    return (
        <Container>
            <Table
                title={'Products'}
                model={products}
                hasEdit
                hasDelete
                onDelete={onDelete}
                onEdit={onEdit}
                openModal={openModal}
            />
            {open && (
                <Modal
                    title="New Product"
                    handleClose={() => setOpen(false)}
                    style={{width: "500px"}}
                >
                    <Form onSubmit={onSubmit}>
                        <input placeholder="Digite o nome" value={newProductName}
                               onChange={(e) => setNewProductName(e.target.value)}/>
                        <input placeholder="Digite o preço" value={newProductPrice}
                               onChange={(e) => setNewProductPrice(e.target.value)}/>
                        <button onClick={() => {
                        }}>Salvar
                        </button>
                    </Form>
                </Modal>
            )}

            {openEdit && (
                <Modal
                    title="Edit Product"
                    handleClose={() => setOpenEdit(false)}
                    style={{width: "500px"}}
                >
                    <Form onSubmit={onSubmitUpdate}>
                        <input placeholder="Digite o nome" value={updateProductName}
                               onChange={(e) => setUpdateProductName(e.target.value)}/>
                        <input placeholder="Digite o preço" value={updateProductPrice}
                               onChange={(e) => setUpdateProductPrice(e.target.value)}/>
                        <button onClick={() => {
                        }}>Salvar
                        </button>
                    </Form>
                </Modal>
            )}
        </Container>
    );
}

export default Products;