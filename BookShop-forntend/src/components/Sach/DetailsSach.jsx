// pages/ChiTietSach.jsx
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getSachById } from '../../service/Sachservice';
import { getAlltacgia } from '../../service/TacGiaservice';
import { getAllTheLoai } from '../../service/TheLoaiService';
import { getAllNhaXuatBan } from '../../service/NhaXuatBan';

const ChiTietSach = () => {
    const { maSach } = useParams();
    const [sach, setSach] = useState(null);
    const [tacGias, setTacGias] = useState([]);
    const [theLoais, setTheLoais] = useState([]);
    const [nhaXuatBans, setNhaXuatBans] = useState([]);

    useEffect(() => {
        getSachById(maSach)
            .then(res => setSach(res.data))
            .catch(err => console.error("Lỗi khi lấy sách:", err));

        getAlltacgia().then(res => setTacGias(res.data || []));
        getAllTheLoai().then(res => setTheLoais(res.data || []));
        getAllNhaXuatBan().then(res => setNhaXuatBans(res.data || []));
    }, [maSach]);

    const getTenTacGia = (maTG) => {
        const tg = tacGias.find(t => t.maTacGia === maTG);
        return tg ? tg.tenTacGia : 'Không xác định';
    };

    const getTentheloai = (maTL) => {
        const tl = theLoais.find(t => t.maTheLoai === maTL);
        return tl ? tl.tenTheLoai : 'Không xác định';
    };

    const getTenNhaXuatBan = (maNXB) => {
        const nxb = nhaXuatBans.find(n => n.maNhaXuatBan === maNXB);
        return nxb ? nxb.tenNhaXuatBan : 'Không xác định';
    };

    if (!sach) {
        return <div className="container mt-5 text-center">Đang tải chi tiết sách...</div>;
    }

    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col-md-4 text-center">
                    <img
                        src={sach.hinhAnh ? `http://localhost:9090/images/${sach.hinhAnh}` : 'https://placehold.co/200x300?text=No+Image'}
                        alt="Bìa sách"
                        className="img-fluid rounded shadow"
                        style={{ maxHeight: '400px', objectFit: 'cover' }}
                    />
                </div>

                <div className="col-md-8">
                    <h2>{sach.tenSach}</h2>
                    <p><strong>Tác giả:</strong> {getTenTacGia(sach.maTacGia)}</p>
                    <p><strong>Thể loại:</strong> {getTentheloai(sach.maTheLoai)}</p>
                    <p><strong>Nhà xuất bản:</strong> {getTenNhaXuatBan(sach.maNhaXuatBan)}</p>
                    <p><strong>Giá bán:</strong> <span className="text-danger fw-bold">{sach.giaBan?.toLocaleString('vi-VN')} đ</span></p>
                    <p><strong>Số lượng còn:</strong> {sach.soLuong}</p>
                    <button
                        className="btn btn-success mt-3"
                        onClick={() => navigate(`/donhang/${sach.maSach || ''}`)}
                    >
                        <i className="bi bi-cart-plus" ></i> Mua ngay
                    </button>
                    <hr />
                    <div>
                        <h5>Mô tả sách</h5>
                        <div dangerouslySetInnerHTML={{ __html: sach.moTa || 'Chưa có mô tả' }} />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default ChiTietSach;
