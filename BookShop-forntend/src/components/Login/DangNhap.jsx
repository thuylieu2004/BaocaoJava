import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getAllTaiKhoan } from '../../service/TaiKhoanService';


const LoginPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    const navigate = useNavigate();


    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await getAllTaiKhoan();
            const danhSachTaiKhoan = response.data;

            const taiKhoanHopLe = danhSachTaiKhoan.find(
                tk => tk.tenTaiKhoan === username && tk.matKhau === password
            );

            if (taiKhoanHopLe) {
                setMessage('');
                // Phân quyền theo vai trò
                if (taiKhoanHopLe.phanQuyen === 'admin') {
                    navigate('/admin');
                } else if (taiKhoanHopLe.phanQuyen === 'user') {
                    navigate('/trangchu');
                } else {
                    setMessage('Không xác định vai trò người dùng');
                }
            } else {
                setMessage('Tên đăng nhập hoặc mật khẩu không đúng');
            }
        } catch (error) {
            console.error('Lỗi khi kiểm tra tài khoản:', error);
            setMessage('Có lỗi xảy ra. Vui lòng thử lại sau.');
        }
    };


    return (
        <div className="d-flex justify-content-center align-items-center vh-100 bg-info">
            <form  className="bg-white p-4 rounded shadow" style={{ width: '320px' }}>
                <h2 className="text-center mb-4">Đăng Nhập</h2>

                <div className="mb-3">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Tên đăng nhập"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                </div>

                <div className="mb-3">
                    <input
                        type="password"
                        className="form-control"
                        placeholder="Mật khẩu"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </div>

                {message && (
                    <div className="text-danger text-center mb-3">{message}</div>
                )}

                <div className="d-grid mb-3">
                    <button  className="btn btn-primary" onClick={handleLogin}>Đăng Nhập</button>
                </div>

                <div className="text-center">
                    Bạn chưa có tài khoản? <a href="/dangki">Đăng kí tại đây</a>
                </div>
            </form>
        </div>
    );
};

export default LoginPage;
