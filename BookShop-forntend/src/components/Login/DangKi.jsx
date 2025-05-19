import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { createTaikhoan } from '../../service/TaiKhoanService';

function Register() {
    const navigate = useNavigate();

    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [fullName, setFullName] = useState('');
    const [error, setError] = useState('');
    const [success, setSuccess] = useState(false);

    const handleRegister = async (e) => {
        e.preventDefault();

        if (!username || !email || !password || !confirmPassword) {
            setError('Vui lòng điền đầy đủ thông tin.');
            return;
        }

        if (password !== confirmPassword) {
            setError('Mật khẩu xác nhận không khớp.');
            return;
        }

        const taiKhoanMoi = {
            tenTaiKhoan: username,
            email: email,
            matKhau: password,
            tenNguoiDung: fullName || username, // nếu chưa nhập tên đầy đủ thì dùng username
            phanQuyen: 'user'
        };

        try {
            await createTaikhoan(taiKhoanMoi);
            setSuccess(true);
            setError('');
        } catch (err) {
            setError('Lỗi khi tạo tài khoản. Có thể tài khoản đã tồn tại.');
        }
    };

    return (
        <div className="d-flex justify-content-center align-items-center vh-100 bg-info">
            <form className="bg-white p-4 rounded shadow" style={{ width: '100%', maxWidth: '400px' }} onSubmit={handleRegister}>
                <h3 className="text-center mb-4">Đăng Ký</h3>

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
                        type="text"
                        className="form-control"
                        placeholder="Họ và tên"
                        value={fullName}
                        onChange={(e) => setFullName(e.target.value)}
                    />
                </div>

                <div className="mb-3">
                    <input
                        type="email"
                        className="form-control"
                        placeholder="Email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
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

                <div className="mb-3">
                    <input
                        type="password"
                        className="form-control"
                        placeholder="Xác nhận mật khẩu"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                    />
                </div>

                <button type="submit" className="btn btn-primary w-100">Đăng Ký</button>

                {error && <div className="alert alert-danger mt-3">{error}</div>}
                {success && (
                    <div className="alert alert-success mt-3">
                        Đăng ký thành công!{' '}
                        <span className="text-decoration-underline text-primary" role="button" onClick={() => navigate('/dangnhap')}>
                            Đăng nhập
                        </span>
                    </div>
                )}
            </form>
        </div>
    );
}

export default Register;
