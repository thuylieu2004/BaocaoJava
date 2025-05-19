import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteSach, getAllsach } from '../../service/Sachservice';
import { getAlltacgia } from '../../service/TacGiaservice';
import { getAllTheLoai } from '../../service/TheLoaiService';
import { getAllNhaXuatBan } from '../../service/NhaXuatBan';


const SachListComponent = () => {
    const [sachs, setSach] = useState([]);
    const [tacGias, setTacGias] = useState([]);
    const [nhaXuatBans, setNhaXuatBans] = useState([]);
    const [theLoais, setTheLoais] = useState([]);

    const navigate = useNavigate();

    useEffect(() => {
        getlistsach();

        getAlltacgia()
            .then((res) => {
                console.log("API Response (Tác giả):", res);
                setTacGias(res.data || []);
            })
            .catch((error) => {
                console.error("Lỗi khi lấy danh sách tác giả:", error);
            });

        getAllTheLoai()
            .then((res) => {
                console.log("API Response (Thể loại):", res);
                setTheLoais(res.data || []);
            })
            .catch((error) => {
                console.error("Lỗi khi lấy danh sách thể loại:", error);
            });

        getAllNhaXuatBan()
            .then((res) => {
                console.log("API Response (Nhà xuất bản):", res);
                setNhaXuatBans(res.data || []);
            })
            .catch((error) => {
                console.error("Lỗi khi lấy danh sách nhà xuất bản:", error);
            });
    }, []);


    function getlistsach() {
        getAllsach()
            .then((res) => {
                console.log("API Response (Sách):", res);
                setSach(res.data || []);
            })
            .catch((error) => {
                console.error("Lỗi khi lấy danh sách sách:", error);
            });
    }

    const getTenTacGia = (maTG) => {
        const tacGia = tacGias.find((tg) => tg.maTacGia === maTG);
        return tacGia ? tacGia.tenTacGia : 'Không Tìm thấy';
    };

    const getTentheloai = (maTL) => {
        const theLoai = theLoais.find((tg) => tg.maTheLoai === maTL);
        return theLoai ? theLoai.tenTheLoai : 'Không Tìm thấy';
    };

    const getTenNhaXuatBan = (maNXB) => {
        const nhaXuatBan = nhaXuatBans.find((tg) => tg.maNhaXuatBan === maNXB);
        return nhaXuatBan ? nhaXuatBan.tenNhaXuatBan : 'Không Tìm thấy';
    };


    function DeleteSach(sachId) {
        const confirmed = window.confirm(`Bạn có chắc chắn muốn xóa cuốn sách với mã "${sachId}" không?`);
        if (!confirmed) return;

        deleteSach(sachId)
            .then(() => {
                getlistsach();
            })
            .catch((error) => {
                console.error("Lỗi khi xóa sách:", error);
            });
    }


    return (
        <div className="container mt-4">
            <h2 className="text-center mb-4">Quản lý sách</h2>
            <div className="mb-3 d-flex justify-content-start">
                <button onClick={() => navigate('/admin/them-sach')} className="btn btn-primary">
                    <i className="bi bi-plus-circle me-2"></i>Thêm sách
                </button>
            </div>

            <div className="table-responsive">
                <table className="table table-striped table-bordered">
                    <thead className="table-dark">
                        <tr>
                            <th style={{ width: "250px" }}>Tên Sách</th>
                            <th style={{ width: "100px" }}>Tác Giả</th>
                            <th>Nhà Xuất Bản</th>
                            <th>Thể Loại</th>
                            <th style={{ width: "100px" }}>Giá Bán</th>
                            <th>Số Lượng</th>
                            <th>Mô Tả</th>
                            <th>Hình Ảnh</th>
                            <th>Hành Động</th>
                        </tr>
                    </thead>
                    <tbody>

                        {sachs.length > 0 ? (
                            sachs.map((sach) => (
                                <tr key={sach.maSach}>
                                    <td>{sach.tenSach || 'Chưa có tên'}</td>
                                    <td>{getTenTacGia(sach.maTacGia) || 'Chưa xác định'}</td>
                                    <td>{getTenNhaXuatBan(sach.maNhaXuatBan) || 'Chưa xác định'}</td>
                                    <td>{getTentheloai(sach.maTheLoai) || 'Chưa xác định'}</td>
                                    <td>{(sach.giaBan?.toLocaleString('vi-VN') || '0') + ' đ'}</td>
                                    <td>{sach.soLuong || 0}</td>
                                    <td>{<div
                                        dangerouslySetInnerHTML={{
                                            __html: sach.moTa?.length > 50
                                                ? `${sach.moTa.substring(0, 50)}...`
                                                : sach.moTa || 'Chưa có mô tả'
                                        }}
                                    />}</td>
                                    <td className="text-center">
                                        {sach.hinhAnh ? (
                                            <img
                                                src={`http://localhost:9090/images/${sach.hinhAnh}`}
                                                alt="bìa sách"
                                                className="img-thumbnail"
                                                style={{ width: "60px", height: "80px", objectFit: "cover" }}
                                            />
                                        ) : (
                                            <span className="text-muted">Không có ảnh</span>
                                        )}
                                    </td>
                                    <td>
                                        <div className="d-flex gap-2">
                                            <button
                                                onClick={() => navigate(`/admin/sua-sach/${sach.maSach || ''}`)}
                                                className="btn btn-sm btn-info"
                                            >
                                                <i className="bi bi-pencil-square"></i> Sửa
                                            </button>
                                            <button
                                                onClick={() => DeleteSach(sach.maSach || '')}
                                                className="btn btn-sm btn-danger"
                                            >
                                                <i className="bi bi-trash"></i> Xóa
                                            </button>
                                            <button
                                                onClick={() => navigate(`/admin/xem-sach/${sach.maSach || ''}`)}
                                                className="btn btn-sm btn-secondary"
                                            >
                                                <i className="bi bi-eye"></i> Xem
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="9" className="text-center">Không có sách nào trong danh sách</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default SachListComponent;