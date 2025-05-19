import React from "react";
import Navbar from "../components/navbar";
import Header from "../components/Trangchu/Header";
import ProductList from "../components/Trangchu/BookHomeList";
import Footer from "../components/Footer";
import HeaderHomePage from "../components/Trangchu/Header";
import NavbarHomePage from "../components/Trangchu/Navbar";
import FooterHomePage from "../components/Trangchu/Footer";


const HomePage = () => {
    return (
        <>
            <HeaderHomePage />
            <NavbarHomePage />
            <ProductList />
            <FooterHomePage />
        </>
    )
}

export default HomePage