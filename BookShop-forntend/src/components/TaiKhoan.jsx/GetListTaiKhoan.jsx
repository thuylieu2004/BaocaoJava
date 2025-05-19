import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteTaikhoan, getAllTaiKhoan } from '../../service/TaiKhoanService';

const TaiKhoanListComponent = () => {
    const [taiKhoans, setTaiKhoans] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetchTaiKhoans();
    }, []);

    const fetchTaiKhoans = () => {
        getAllTaiKhoan()
            .then(res => {
                setTaiKhoans(res.data || []);
            })
            .catch(error => {
                console.error("Lỗi khi lấy danh sách tài khoản:", error);
            });
    };

    const handleDelete = (maTaiKhoan) => {
        const confirmed = window.confirm(`Bạn có chắc chắn muốn xóa tài khoản với mã "${maTaiKhoan}" không?`);
        if (!confirmed) return;

        deleteTaikhoan(maTaiKhoan)
            .then(() => {
                fetchTaiKhoans();
            })
            .catch(error => {
                console.error("Lỗi khi xóa tài khoản:", error);
            });
    };

    return (
        <div className="container mt-4">
            <h2 className="text-center mb-4">Danh sách Tài Khoản</h2>

            <div className="table-responsive">
                <button
                    onClick={() => navigate('/admin/them-taikhoan')}
                    className="btn btn-primary mb-3"
                >
                    <i className="bi bi-plus-circle me-2"></i>Thêm Tài Khoản
                </button>
                <table className="table table-bordered table-striped">
                    <thead className="table-dark">
                        <tr>
                            <th>Mã Tài Khoản</th>
                            <th>Tên Tên tài khoản</th>
                            <th>Mật khẩu</th>
                            <th>Tên Người Dùng</th>
                            <th>Phân Quyền</th>
                            <th>Email</th>
                            <th>Hành Động</th>
                        </tr>
                    </thead>
                    <tbody>
                        {taiKhoans.length > 0 ? (
                            taiKhoans.map((tk) => (
                                <tr key={tk.maTaiKhoan}>
                                    <td>{tk.maTaiKhoan}</td>
                                    <td>{tk.tenTaiKhoan}</td>
                                    <td>{tk.matKhau}</td>
                                    <td>{tk.tenNguoiDung}</td>
                                    <td>{tk.phanQuyen}</td>
                                    <td>{tk.email}</td>
                                    <td>
                                        <div className="d-flex gap-2">
                                            <button
                                                onClick={() => navigate(`/admin/sua-taikhoan/${tk.maTaiKhoan}`)}
                                                className="btn btn-sm btn-info"
                                            >
                                                <i className="bi bi-pencil-square"></i> Sửa
                                            </button>
                                            <button
                                                onClick={() => handleDelete(tk.maTaiKhoan)}
                                                className="btn btn-sm btn-danger"
                                            >
                                                <i className="bi bi-trash"></i> Xóa
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="6" className="text-center">Không có tài khoản nào</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default TaiKhoanListComponent;
