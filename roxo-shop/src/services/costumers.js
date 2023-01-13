import axios from "axios";
import {products} from "./products";
import {orders} from "./orders";

export const costumers = axios.create({
    baseURL: `http://localhost:8082`,
})

export const getCostumers = async () => {
    return await costumers.get('/costumers');
}

export const createCostumer = async (costumer) => {
    return await costumers.post('/costumers', costumer);
}

export const updateCostumer = async (product) => {
    return await costumers.put(`/costumers/${product.id}`, product);
}

export const deleteCostumer = async (id) => {
    return await costumers.delete(`/costumers/${id}`);
}