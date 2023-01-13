import {BrowserRouter, Route, Routes} from "react-router-dom";
import Welcome from "./pages/Welcome";
import Products from "./pages/Products";
import Orders from "./pages/Orders";
import Costumers from "./pages/Costumers";

function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Welcome/>}/>
                <Route path="/products" element={<Products/>}/>
                <Route path="/orders" element={<Orders/>}/>
                <Route path="/costumers" element={<Costumers/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default AppRoutes;