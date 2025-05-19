import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteNhaXuaBan, getAllNhaXuatBan } from '../../service/NhaXuatBan';

const NhaXuatBanListComponent = () => {
    const [nhaXuatBans, setNhaXuatBans] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getAllNhaXuatBan()
            .then(res => {
                setNhaXuatBans(res.data || []);
            })
            .catch(error => {
                console.error("Lỗi khi lấy danh sách nhà xuất bản:", error);
            });
    }, []);


    function DeleteSach(nhaxuatbanid) {
        const confirmed = window.confirm(`Bạn có chắc chắn muốn xóa nhà xuất bản với mã "${nhaxuatbanid}" không?`);
        if (!confirmed) return;

        deleteNhaXuaBan(nhaxuatbanid)
            .then(() => {
                getAllNhaXuatBan();
            })
            .catch((error) => {
                console.error("Lỗi khi xóa nhà xuất bản:", error);
            });
    }


    return (
        <div className="container mt-4">
            <h2 className="text-center mb-4">Danh sách Nhà Xuất Bản</h2>

            <div className="table-responsive">
                <button onClick={() => navigate('/admin/them-nhaxuatban')} className="btn btn-primary">
                    <i className="bi bi-plus-circle me-2"></i>Thêm Nhà Xuất Bản
                </button>
                <table className="table table-bordered table-striped">
                    <thead className="table-dark">
                        <tr>
                            <th style={{ width: '80px' }}>Mã NXB</th>
                            <th>Tên Nhà Xuất Bản</th>
                            <th>Địa Chỉ</th>
                            <th>Email</th>
                            <th>Hành Động</th>
                        </tr>
                    </thead>
                    <tbody>
                        {nhaXuatBans.length > 0 ? (
                            nhaXuatBans.map((nxb) => (
                                <tr key={nxb.maNhaXuatBan}>
                                    <td>{nxb.maNhaXuatBan}</td>
                                    <td>{nxb.tenNhaXuatBan}</td>
                                    <td>{nxb.diaChi}</td>
                                    <td>{nxb.email}</td>
                                    <td>  <div className="d-flex gap-2">
                                        <button
                                            onClick={() => navigate(`/admin/sua-nxb/${nxb.maNhaXuatBan || ''}`)}
                                            className="btn btn-sm btn-info"
                                        >
                                            <i className="bi bi-pencil-square"></i> Sửa
                                        </button>
                                        <button
                                            onClick={() => DeleteSach(nxb.maNhaXuatBan || '')}
                                            className="btn btn-sm btn-danger"
                                        >
                                            <i className="bi bi-trash"></i> Xóa
                                        </button>
                                        <button
                                            onClick={() => navigate(`/admin/xem-sach/${nxb.maNhaXuatBan || ''}`)}
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
                                <td colSpan="4" className="text-center">Không có nhà xuất bản nào</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default NhaXuatBanListComponent;
