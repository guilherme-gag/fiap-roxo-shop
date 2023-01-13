import axios from "axios";
import {products} from "./products";

export const orders = axios.create({
    baseURL: `http://roxo-serv-order:8080`,
})

export const getOrders = async () => {
    return await orders.get('/order');
}

export const createOrder = async (order) => {
    return await orders.post('/order', order);
}

export const updateOrder = async (product) => {
    return await orders.put(`/order/${product.id}`, product);
}

export const deleteOrder = async (id) => {
    return await orders.delete(`/order/${id}`);
}