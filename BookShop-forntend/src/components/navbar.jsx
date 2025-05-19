import React from 'react';
import { useNavigate } from 'react-router-dom';

export default function Navbar() {

  const navigate = useNavigate();

   const handleLogout = () => {
    // Xử lý xoá token hoặc session ở đây nếu có
    localStorage.removeItem("token"); // nếu bạn lưu token
    navigate('/dangnhap'); // điều hướng về trang đăng nhập
  };


  return (
    <nav className="navbar navbar-light bg-light shadow-sm px-4">
      <span className="navbar-brand mb-0 h1">Admin Dashboard</span>
      <button className="btn btn-outline-danger" onClick={handleLogout}>Đăng Xuất</button>
    </nav>
  );
}
