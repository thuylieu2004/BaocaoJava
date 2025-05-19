import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createTacgia } from "../../service/TacGiaservice";

const AddTacGia = () => {
    const [tenTacGia, setTenTacGia] = useState('');
    const [tieuSu, setTieuSu] = useState('');

    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();

        const tacGia = {
            tenTacGia,
            tieuSu,
        };

        createTacgia(tacGia)
            .then((response) => {
                console.log("Thêm tác giả thành công:", response.data);
                navigate('/admin/tacgias'); // Điều hướng về danh sách tác giả
            })
            .catch((error) => {
                console.error("Lỗi khi thêm tác giả:", error);
            });
    };

    return (
        <div className="container">
            <div className="row">
                <div className="card">
                    <h2 className="text-center mt-3">Thêm Tác Giả</h2>
                    <div className="card-body">
                        <form>
                            <div className="form-group mb-3">
                                <label className="form-label">Tên Tác Giả</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    value={tenTacGia}
                                    onChange={(e) => setTenTacGia(e.target.value)}
                                    required
                                />
                            </div>
                            <div className="form-group mb-3">
                                <label className="form-label">Tiểu sử</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    value={tieuSu}
                                    onChange={(e) => setTieuSu(e.target.value)}
                                    required
                                />
                            </div>

                            <button className="btn btn-success" onClick={handleSubmit}>
                                Thêm Tác Giả
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddTacGia;
