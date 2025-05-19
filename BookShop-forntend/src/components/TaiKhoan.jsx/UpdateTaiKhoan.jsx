import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { getTaiKhoanById, updateTaikhoan,  } from '../../service/TaiKhoanService';

const UpdateTaiKhoanComponent = () => {
    const { id } = useParams();
    const navigate = useNavigate();

    const [taiKhoan, setTaiKhoan] = useState({
        tenTaiKhoan: '',
        matKhau: '',
        tenNguoiDung: '',
        phanQuyen: '',
        email: ''
    });

    useEffect(() => {
        getTaiKhoanById(id)
            .then(res => {
                setTaiKhoan(res.data);
            })
            .catch(error => {
                console.error("Lỗi khi lấy tài khoản:", error);
            });
    }, [id]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setTaiKhoan(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        updateTaikhoan(id, taiKhoan)
            .then(() => {
                navigate('/admin/taikhoans');
            })
            .catch(error => {
                console.error("Lỗi khi cập nhật tài khoản:", error);
            });
    };

    return (
        <div className="container mt-4">
            <div className="card">
                <h2 className="text-center mt-3">Cập Nhật Tài Khoản</h2>
                <div className="card-body">
                    <form onSubmit={handleSubmit}>
                        <div className="form-group mb-3">
                            <label>Tên tài khoản</label>
                            <input
                                type="text"
                                className="form-control"
                                name="tenTaiKhoan"
                                value={taiKhoan.tenTaiKhoan}
                                onChange={handleChange}
                                required
                            />
                        </div>

                        <div className="form-group mb-3">
                            <label>Mật khẩu</label>
                            <input
                                type="password"
                                className="form-control"
                                name="matKhau"
                                value={taiKhoan.matKhau}
                                onChange={handleChange}
                                required
                            />
                        </div>

                        <div className="form-group mb-3">
                            <label>Tên người dùng</label>
                            <input
                                type="text"
                                className="form-control"
                                name="tenNguoiDung"
                                value={taiKhoan.tenNguoiDung}
                                onChange={handleChange}
                                required
                            />
                        </div>

                        <div className="form-group mb-3">
                            <label>Phân quyền</label>
                            <input
                                type="text"
                                className="form-control"
                                name="phanQuyen"
                                value={taiKhoan.phanQuyen}
                                onChange={handleChange}
                                required
                            />
                        </div>

                        <div className="form-group mb-3">
                            <label>Email</label>
                            <input
                                type="email"
                                className="form-control"
                                name="email"
                                value={taiKhoan.email}
                                onChange={handleChange}
                                required
                            />
                        </div>

                        <button type="submit" className="btn btn-success">Cập nhật</button>
                        <button
                            type="button"
                            className="btn btn-secondary ms-2"
                            onClick={() => navigate('/admin/taikhoans')}
                        >
                            Hủy
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default UpdateTaiKhoanComponent;
