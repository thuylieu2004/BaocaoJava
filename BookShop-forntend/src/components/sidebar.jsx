import React from 'react';
import { Link } from 'react-router-dom';

export default function Sidebar() {
  return (
    <div className="bg-primary text-white sidebar p-3" style={{ width: '250px'}}>
      <h4 className="mb-4">Quản trị viên</h4>
      <div className="list-group list-group-flush">
        <Link to="/admin/dashboard" className="list-group-item list-group-item-action bg-primary text-white sidebar-link">
          Dashboard
        </Link>
        <Link to="/admin/sachs" className="list-group-item list-group-item-action bg-primary text-white sidebar-link">
          QUẢN LÝ SÁCH
        </Link>
        <Link to="/admin/nhaxuatbans" className="list-group-item list-group-item-action bg-primary text-white sidebar-link">
          QUẢN LÝ NHÀ XUẤT BẢN
        </Link>
        <Link to="/admin/theloais" className="list-group-item list-group-item-action bg-primary text-white sidebar-link">
          QUẢN LÝ THỂ LOẠI
        </Link>
        <Link to="/admin/tacgias" className="list-group-item list-group-item-action bg-primary text-white sidebar-link">
          QUẢN LÝ TÁC GIẢ
        </Link>
        <Link to="/admin/books" className="list-group-item list-group-item-action bg-primary text-white sidebar-link">
          QUẢN LÝ KHÁCH HÀNG
        </Link>
        <Link to="/admin/taikhoans" className="list-group-item list-group-item-action bg-primary text-white sidebar-link">
          QUẢN LÝ NGƯỜI DÙNG
        </Link>
        <Link to="/admin/books" className="list-group-item list-group-item-action bg-primary text-white sidebar-link">
          QUẢN LÝ HÓA ĐƠN
        </Link>
      </div>
    </div>
  );
}
