import axios from "axios";

export const products = axios.create({
    baseURL: `http://localhost:8082`,
})

export const getProducts = async () => {
    return await products.get('/products');
}

export const createProduct = async (product) => {
    return await products.post('/products', product);
}

export const updateProduct = async (product) => {
    return await products.put(`/products/${product.id}`, product);
}

export const deleteProduct = async (id) => {
    return await products.delete(`/products/${id}`);
}