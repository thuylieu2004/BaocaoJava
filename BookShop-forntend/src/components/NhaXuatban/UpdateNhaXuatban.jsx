import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { getNhaXBById, updateNhaXuatBan } from "../../service/NhaXuatBan";

const UpdateNhaXuatBan = () => {
  const { id } = useParams(); // id của NXB cần sửa
  const navigate = useNavigate();

  const [tenNhaXuatBan, setTenNhaXuatBan] = useState("");
  const [diaChi, setDiaChi] = useState("");
  const [email, setEmail] = useState("");

  useEffect(() => {
    getNhaXBById(id)
      .then((res) => {
        const data = res.data;
        setTenNhaXuatBan(data.tenNhaXuatBan || "");
        setDiaChi(data.diaChi || "");
        setEmail(data.email || "");
      })
      .catch((err) => {
        console.error("Lỗi khi lấy thông tin NXB:", err);
        alert("Không tìm thấy nhà xuất bản");
      });
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();

    const nxbData = {
      tenNhaXuatBan,
      diaChi,
      email,
    };

    updateNhaXuatBan(id, nxbData)
      .then((res) => {
        alert("Cập nhật nhà xuất bản thành công");
        navigate("/admin/nhaxuatbans");
      })
      .catch((err) => {
        console.error("Lỗi khi cập nhật NXB:", err);
        alert("Có lỗi xảy ra khi cập nhật nhà xuất bản");
      });
  };

  return (
    <div className="container">
      <h2 className="text-center mt-4">Cập nhật Nhà Xuất Bản</h2>
      <div className="card p-4">
        <form >
          <div className="form-group mb-3">
            <label className="form-label">Tên Nhà Xuất Bản</label>
            <input
              type="text"
              className="form-control"
              value={tenNhaXuatBan}
              onChange={(e) => setTenNhaXuatBan(e.target.value)}
              required
            />
          </div>
          <div className="form-group mb-3">
            <label className="form-label">Địa chỉ</label>
            <input
              type="text"
              className="form-control"
              value={diaChi}
              onChange={(e) => setDiaChi(e.target.value)}
              required
            />
          </div>
          <div className="form-group mb-3">
            <label className="form-label">Email</label>
            <input
              type="text"
              className="form-control"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
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

export default UpdateNhaXuatBan;
