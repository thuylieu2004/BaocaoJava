import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { getTacGiayId, updateTacgia } from "../../service/TacGiaservice";

const UpdateTacGia = () => {
    const { id } = useParams(); // id của NXB cần sửa
    const navigate = useNavigate();

    const [tenTacGia, setTenTacGia] = useState("");
    const [tieuSu, setTieuSu] = useState("");


    useEffect(() => {
        getTacGiayId(id)
            .then((res) => {
                const data = res.data;
                setTenTacGia(data.tenTacGia || "");
                setTieuSu(data.tieuSu || "");
            })
            .catch((err) => {
                console.error("Lỗi khi lấy thông tin Tác Giả:", err);
                alert("Không tìm thấy nhà xuất bản");
            });
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();

        const tacgia = {
            tenTacGia,
            tieuSu,
        };

        updateTacgia(id, tacgia)
            .then((res) => {
                alert("Cập nhật tác giả thành công");
                navigate("/admin/tacgias");
            })
            .catch((err) => {
                console.error("Lỗi khi cập nhật tác giả:", err);
                alert("Có lỗi xảy ra khi cập nhật tác giả");
            });
    };

    return (
        <div className="container">
            <h2 className="text-center mt-4">Cập nhật Tác Giả</h2>
            <div className="card p-4">
                <form >
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

                    <button className="btn btn-primary" onClick={handleSubmit}>
                        Cập nhật
                    </button>
                </form>
            </div>
        </div>
    );
};

export default UpdateTacGia;
