import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteTheLoai, getAllTheLoai } from '../../service/TheLoaiService';

const TheLoaiListComponent = () => {
    const [theLoais, setTheLoais] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetchTheLoai();
    }, []);

    const fetchTheLoai = () => {
        getAllTheLoai()
            .then(res => {
                setTheLoais(res.data || []);
            })
            .catch(error => {
                console.error("Lỗi khi lấy danh sách tác giả:", error);
            });
    };

    const handleDelete = (theloaiId) => {
        const confirmed = window.confirm(`Bạn có chắc chắn muốn xóa thể loại với mã "${theloaiId}" không?`);
        if (!confirmed) return;

        deleteTheLoai(theloaiId)
            .then(() => {
                getAllTheLoai();
            })
            .catch(error => {
                console.error("Lỗi khi xóa thể loại:", error);
            });
    };

    return (
        <div className="container mt-4">
            <h2 className="text-center mb-4">Danh sách Tác Giả</h2>

            <div className="table-responsive">
                <button onClick={() => navigate('/admin/them-tacgia')} className="btn btn-primary mb-3">
                    <i className="bi bi-plus-circle me-2"></i>Thêm Thể Loại
                </button>
                <table className="table table-bordered table-striped">
                    <thead className="table-dark">
                        <tr>
                            <th style={{ width: '80px' }}>Mã Thể Loại</th>
                            <th>Tên Thể Loại</th>
                            <th>Mô Tả</th>
                            <th>Hành Động</th>
                        </tr>
                    </thead>
                    <tbody>
                        {theLoais.length > 0 ? (
                            theLoais.map((tg) => (
                                <tr key={tg.maTheLoai}>
                                    <td>{tg.maTheLoai}</td>
                                    <td>{tg.tenTheLoai}</td>
                                    <td>{tg.moTa}</td>
                                    <td>
                                        <div className="d-flex gap-2">
                                            <button
                                                onClick={() => navigate(`/admin/sua-theloai/${tg.maTheLoai}`)}
                                                className="btn btn-sm btn-info"
                                            >
                                                <i className="bi bi-pencil-square"></i> Sửa
                                            </button>
                                            <button
                                                onClick={() => handleDelete(tg.maTheLoai)}
                                                className="btn btn-sm btn-danger"
                                            >
                                                <i className="bi bi-trash"></i> Xóa
                                            </button>
                                            <button
                                                onClick={() => navigate(`/admin/xem-sach-theo-tg/${tg.maTheLoai}`)}
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
                                <td colSpan="5" className="text-center">Không có tác giả nào</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default TheLoaiListComponent;
