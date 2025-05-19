import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createNhaXuatBan } from "../../service/NhaXuatBan";

const AddNhaXuatBan = () => {
    const [tenNhaXuatBan, setTenNhaXuatBan] = useState('');
    const [diaChi, setDiaChi] = useState('');
    const [email, setEmail] = useState('');

    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();

        const nhaXuatBan = {
            tenNhaXuatBan,
            diaChi,
            email
        };

        createNhaXuatBan(nhaXuatBan)
            .then((response) => {
                console.log("Thêm NXB thành công:", response.data);
                navigate('/admin/nhaxuatbans'); // Đường dẫn sau khi thêm xong
            })
            .catch((error) => {
                console.error("Lỗi khi thêm NXB:", error);
            });
    };

    return (
        <div className="container">
            <div className="row">
                <div className="card">
                    <h2 className="text-center">Thêm Nhà Xuất Bản</h2>
                    <div className="card-body">
                        <form>
                            <div className="form-group mb-2">
                                <label className="form-label">Tên Nhà Xuất Bản</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    value={tenNhaXuatBan}
                                    onChange={(e) => setTenNhaXuatBan(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">Địa chỉ</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    value={diaChi}
                                    onChange={(e) => setDiaChi(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group mb-2">
                                <label className="form-label">email</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    value={email}
                                    onChange={(e) => setSoDienThoai(e.target.value)}
                                    required
                                />
                            </div>
                            <button className="btn btn-success" onClick={handleSubmit}>Thêm Nhà Xuất Bản</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddNhaXuatBan;
