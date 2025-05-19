import React, { useState } from "react";

const DonHang = () => {
    const [donhang, setDonHang] = useState('');
    const [chitietdonhang, setchitietdonhang] = useState('');
    const [khachhang, setkhachhang] = useState('');



    return (
        <div className="container mt-5">
            <h2 className="mb-4"> Đơn Hàng</h2>
            <form onSubmit={handleSubmit}>

                <div className="mb-3">
                    <label>Tên khách hàng:</label>
                    <input
                        type="text"
                        className="form-control"
                        value={maKhachHang}
                        onChange={e => setMaKhachHang(e.target.value)}

                    />
                </div>

                <div className="mb-3">
                    <label>Mã sách:</label>
                    <input
                        type="text"
                        className="form-control"
                        value={maSach}
                        onChange={e => setMaSach(e.target.value)}
                        onBlur={() => fetchSach(maSach)}
                    />
                    {sachInfo && (
                        <div className="mt-2">
                            <p><strong>Tên sách:</strong> {sachInfo.tenSach}</p>
                            <p><strong>Giá:</strong> {sachInfo.giaBan} VND</p>
                        </div>
                    )}
                </div>

                <div className="mb-3">
                    <label>Số lượng:</label>
                    <input
                        type="number"
                        className="form-control"
                        value={soLuong}
                        onChange={e => setSoLuong(e.target.value)}
                        min={1}
                    />
                </div>

                <div className="mb-3">
                    <label>Ngày lập hóa đơn:</label>
                    <input
                        type="date"
                        className="form-control"
                        value={ngayLap}
                        onChange={e => setNgayLap(e.target.value)}
                    />
                </div>

                <button type="submit" className="btn btn-success">Tạo đơn hàng</button>
            </form>
        </div>
    );

}

export default DonHang