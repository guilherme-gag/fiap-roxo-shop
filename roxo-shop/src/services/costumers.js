import axios from "axios";
import {products} from "./products";
import {orders} from "./orders";

export const costumers = axios.create({

    baseURL: `http://roxo-serv-customer:8080`

})

export const getCostumers = async () => {
    return await costumers.get('/customers');
}

export const createCostumer = async (costumer) => {
    return await costumers.post('/customers', costumer);
}

export const updateCostumer = async (product) => {
    return await costumers.put(`/customers/${product.id}`, product);
}

export const deleteCostumer = async (id) => {
    return await costumers.delete(`/customers/${id}`);
}