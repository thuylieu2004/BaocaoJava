import { useState } from 'react'
import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import AdminHome from './pages/AdminHome';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import SachListComponent from './components/Sach/GetallList';
import AddSach from './components/Sach/Addsach';
import UpdateSach from './components/Sach/UpdateSach';
import LoginPage from './components/Login/DangNhap';
import Register from './components/Login/DangKi';
import HomePage from './pages/HomePage';
import ChiTietSach from './components/Sach/DetailsSach';
import BookHomeList from './components/Trangchu/BookHomeList';
import NhaXuatBanListComponent from './components/NhaXuatban/GetListNhaXuatBan';
import AddNhaXuatBan from './components/NhaXuatban/AddNhaXuatBan';
import UpdateNhaXuatBan from './components/NhaXuatban/UpdateNhaXuatban';
import TacGiaListComponent from './components/TacGia/GetListTacGia';
import AddTacGia from './components/TacGia/AddTacGia';
import UpdateTacGia from './components/TacGia/UpdateTacGia';
import TaiKhoanListComponent from './components/TaiKhoan.jsx/GetListTaiKhoan';
import UpdateTaiKhoanComponent from './components/TaiKhoan.jsx/UpdateTaiKhoan';
import TheLoaiListComponent from './components/TheLoai/GetAllTheLoai';




function App() {

  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* Trang chính */}
          <Route path="/trangchu" element={<HomePage />} />


          <Route path="/xem-sach/:maSach" element={<ChiTietSach />} />

          <Route path="the-loai/:maTheLoai" element={<BookHomeList />} />


          <Route path="/tim-kiem" element={<BookHomeList />} />


          {/* trang đăng nhập */}
          <Route path="/dangnhap" element={<LoginPage />} />
          {/* trang đăng kí*/}
          <Route path="/dangki" element={<Register />} />

          {/* http://localhost:3000 */}
          <Route path="/admin" element={<AdminHome />} >
            <Route path="sachs" element={<SachListComponent />} />
            <Route path="them-sach" element={<AddSach />} />
            <Route path="sua-sach/:id" element={<UpdateSach />} />
            <Route path="nhaxuatbans" element={<NhaXuatBanListComponent />} />
            <Route path="them-nhaxuatban" element={<AddNhaXuatBan />} />
            <Route path="sua-nxb/:id" element={<UpdateNhaXuatBan />} />
            <Route path="tacgias" element={<TacGiaListComponent />} />
            <Route path="them-tacgia" element={<AddTacGia />} />
            <Route path="sua-tacgia/:id" element={<UpdateTacGia />} />
            <Route path="taikhoans" element={<TaiKhoanListComponent />} />
            <Route path="sua-taikhoan/:id" element={<UpdateTaiKhoanComponent />} />
            <Route path="theloais" element={<TheLoaiListComponent />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
