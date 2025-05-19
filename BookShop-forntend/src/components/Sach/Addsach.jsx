import React from "react";
import { useState, useEffect } from "react";
import { Editor } from '@tinymce/tinymce-react';
import { createsach } from "../../service/Sachservice";
import { useNavigate } from "react-router-dom";
import { getAlltacgia } from '../../service/TacGiaservice';
import { getAllTheLoai } from '../../service/TheLoaiService';
import { getAllNhaXuatBan } from '../../service/NhaXuatBan';


const AddSach = () => {
    const [tenSach, setTenSach] = useState('');
    const [maTacGia, setMaTacGia] = useState('');
    const [maNhaXuatBan, setMaNhaXuatBan] = useState('');
    const [maTheLoai, setmaTheLoai] = useState('');
    const [giaBan, setGiaBan] = useState('');
    const [soLuong, setSoLuong] = useState('');
    const [moTa, setMoTa] = useState('');
    const [hinhAnh, setHinhAnh] = useState('');

    const [tacGias, setTacGias] = useState([]);
    const [nhaXuatBans, setNhaXuatBans] = useState([]);
    const [theLoais, setTheLoais] = useState([]);

    const [loiGiaBan, setLoiGiaBan] = useState('');
    const [loiSoLuong, setLoiSoLuong] = useState('');

    const navigator = useNavigate();

    useEffect(() => {
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


    function handleTenSach(e) {
        setTenSach(e.target.value);
    }

    function handleMaTacGia(e) {
        setMaTacGia(e.target.value);
    }

    function handleMaNhaXuatBan(e) {
        setMaNhaXuatBan(e.target.value);
    }

    function handleMaTheLoai(e) {
        setmaTheLoai(e.target.value);
    }

    const handleGiaBanChange = (e) => {
        const value = e.target.value;
        setGiaBan(value);

        if (isNaN(value) || Number(value) < 0) {
            setLoiGiaBan('Vui lòng nhập số!');
        } else {
            setLoiGiaBan('');
        }
    };

    // kiểm tra số lượng
    const handleSoLuongChange = (e) => {
        const value = e.target.value;

        // Kiểm tra nếu không phải số
        if (!/^\d*$/.test(value)) {
            setLoiSoLuong('Số lượng chỉ được nhập số nguyên dương');
        } else {
            setLoiSoLuong('');
        }

        setSoLuong(value);
    };

    const handleEditorChange = (content, editor) => {
        setMoTa(content);
    };

    const handleImageChange = (e) => {
        setHinhAnh(e.target.files[0]);
    };


    function saveSach(e) {
        e.preventDefault();
        const sachs = { tenSach, maTacGia, maNhaXuatBan, maTheLoai, giaBan, soLuong, moTa, hinhAnh }

        createsach(sachs).then((Response) => {
            console.log(Response.data);
            navigator('/admin/sachs')
        })
    }


    return (
        <div className="container">
            <div className="row">
                <div className="card">
                    <h2 className="text-center">Thêm sách</h2>
                    <div className="card-body">
                        <form>
                            {/* tên sách */}
                            <div className="form-group mb-2">
                                <label className="form-label">Tên sách</label>
                                <input
                                    type="text"
                                    placeholder="Nhập tên sách"
                                    name='tenSach'
                                    value={tenSach}
                                    className="form-control"
                                    onChange={handleTenSach}
                                ></input>
                            </div>
                            {/* tác giả */}
                            <div className="form-group mb-2">
                                <label className="form-label">Tác giả</label>
                                <select
                                    className="form-control"
                                    value={maTacGia}
                                    onChange={handleMaTacGia}
                                >
                                    <option value="">-- Chọn tác giả --</option>
                                    {tacGias.map((tg) => (
                                        <option key={tg.maTacGia} value={tg.maTacGia}>
                                            {tg.tenTacGia}
                                        </option>
                                    ))}
                                </select>
                            </div>
                            {/*  nhà xuất bản */}
                            <div className="form-group mb-2">
                                <label className="form-label">Nhà Xuất Bản</label>
                                <select
                                    className="form-control"
                                    value={maNhaXuatBan}
                                    onChange={handleMaNhaXuatBan}
                                >
                                    <option value="">-- Chọn Nhà Xuất Bản --</option>
                                    {nhaXuatBans.map((tg) => (
                                        <option key={tg.maNhaXuatBan} value={tg.maNhaXuatBan}>
                                            {tg.tenNhaXuatBan}
                                        </option>
                                    ))}
                                </select>
                            </div>
                            {/* thể loại */}
                            <div className="form-group mb-2">
                                <label className="form-label">Thể Loại</label>
                                <select
                                    className="form-control"
                                    value={maTheLoai}
                                    onChange={handleMaTheLoai}
                                >
                                    <option value="">-- Chọn thể loại --</option>
                                    {theLoais.map((tg) => (
                                        <option key={tg.maTheLoai} value={tg.maTheLoai}>
                                            {tg.tenTheLoai}
                                        </option>
                                    ))}
                                </select>
                            </div>
                            {/* gia ban */}
                            <div className="form-group mb-2">
                                <label className="form-label">Giá Bán</label>
                                <input
                                    type="text"
                                    placeholder="Nhập giá bán"
                                    name='giaBan'
                                    value={giaBan}
                                    className={`form-control ${loiGiaBan ? 'is-invalid' : ''}`}
                                    onChange={handleGiaBanChange}
                                />
                                {/* Hiển thị lỗi nếu có */}
                                {loiGiaBan && <div className="text-danger">{loiGiaBan}</div>}
                            </div>

                            {/* Số lượng */}
                            <div className="form-group mb-2">
                                <label className="form-label">Số Lượng</label>
                                <input
                                    type="text"
                                    placeholder="Nhập số lượng"
                                    name="soLuong"
                                    value={soLuong}
                                    className={`form-control ${loiSoLuong ? 'is-invalid' : ''}`}
                                    onChange={handleSoLuongChange}
                                />
                                {loiSoLuong && <div className="text-danger">{loiSoLuong}</div>}
                            </div>
                            {/* Mô tả */}
                            <div className="form-group mb-2">
                                <label className="form-label">Mô tả</label>
                                <Editor
                                    apiKey="gdka07fdg38kbmiz4mqsqpqpk2yksibw9vrz41z1tq8z5149" // hoặc dùng key của bạn nếu có
                                    initialValue=""
                                    value={moTa}
                                    init={{
                                        height: 200,
                                        menubar: false,
                                        plugins: [
                                            'advlist autolink lists link image charmap preview anchor',
                                            'searchreplace visualblocks code fullscreen',
                                            'insertdatetime media table paste code help wordcount'
                                        ],
                                        toolbar:
                                            'undo redo | formatselect | bold italic backcolor | \
                                             alignleft aligncenter alignright alignjustify | \
                                            bullist numlist outdent indent | removeformat | help'
                                    }}
                                    onEditorChange={handleEditorChange}
                                />
                            </div>
                            {/* hình ảnh */}
                            <div className="form-group mb-2">
                                <label className="form-label">Hình ảnh</label>
                                <input
                                    type="file"
                                    accept="image/*"
                                    name="hinhAnh"
                                    className="form-control"
                                    onChange={handleImageChange}
                                ></input>
                            </div>
                            <button  className="btn btn-success" onClick={saveSach}>Thêm sách</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )



}

export default AddSach