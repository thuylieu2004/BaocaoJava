import React from 'react';
import Sidebar from '../components/sidebar';
import Navbar from '../components/navbar';
import Footer from '../components/Footer';
import { Outlet } from 'react-router-dom';

export default function AdminHome() {
  return (
    <div className="d-flex">
      <Sidebar />
      <div className="d-flex flex-column flex-grow-1 min-vh-100">
        <Navbar />
        <div className="flex-grow-1">
          <Outlet />
        </div>
        <Footer />
      </div>
    </div>
  );
}
