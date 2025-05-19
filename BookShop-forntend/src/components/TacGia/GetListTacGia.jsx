import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteTacGia, getAlltacgia } from '../../service/TacGiaservice';

const TacGiaListComponent = () => {
    const [tacGias, setTacGias] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetchTacGias();
    }, []);

    const fetchTacGias = () => {
        getAlltacgia()
            .then(res => {
                setTacGias(res.data || []);
            })
            .catch(error => {
                console.error("Lỗi khi lấy danh sách tác giả:", error);
            });
    };

    const handleDelete = (tacgiaId) => {
        const confirmed = window.confirm(`Bạn có chắc chắn muốn xóa tác giả với mã "${tacgiaId}" không?`);
        if (!confirmed) return;

        deleteTacGia(tacgiaId)
            .then(() => {
                getAlltacgia();
            })
            .catch(error => {
                console.error("Lỗi khi xóa tác giả:", error);
            });
    };

    return (
        <div className="container mt-4">
            <h2 className="text-center mb-4">Danh sách Tác Giả</h2>

            <div className="table-responsive">
                <button onClick={() => navigate('/admin/them-tacgia')} className="btn btn-primary mb-3">
                    <i className="bi bi-plus-circle me-2"></i>Thêm Tác Giả
                </button>
                <table className="table table-bordered table-striped">
                    <thead className="table-dark">
                        <tr>
                            <th style={{ width: '80px' }}>Mã TG</th>
                            <th>Tên Tác Giả</th>
                            <th>Tiểu Sử</th>
                            <th>Hành Động</th>
                        </tr>
                    </thead>
                    <tbody>
                        {tacGias.length > 0 ? (
                            tacGias.map((tg) => (
                                <tr key={tg.maTacGia}>
                                    <td>{tg.maTacGia}</td>
                                    <td>{tg.tenTacGia}</td>
                                    <td>{tg.tieuSu}</td>
                                    <td>
                                        <div className="d-flex gap-2">
                                            <button
                                                onClick={() => navigate(`/admin/sua-tacgia/${tg.maTacGia}`)}
                                                className="btn btn-sm btn-info"
                                            >
                                                <i className="bi bi-pencil-square"></i> Sửa
                                            </button>
                                            <button
                                                onClick={() => handleDelete(tg.maTacGia)}
                                                className="btn btn-sm btn-danger"
                                            >
                                                <i className="bi bi-trash"></i> Xóa
                                            </button>
                                            <button
                                                onClick={() => navigate(`/admin/xem-sach-theo-tg/${tg.maTacGia}`)}
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

export default TacGiaListComponent;
