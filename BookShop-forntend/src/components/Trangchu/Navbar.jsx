import React, { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { getAllTheLoai } from '../../service/TheLoaiService';

const NavbarHomePage = () => {
    const [categories, setCategories] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        getAllTheLoai().then(res => {
            setCategories(res.data);
        });
    }, []);

    const handleSearch = (e) => {
        e.preventDefault();
        if (searchTerm.trim()) {
            navigate(`/tim-kiem?query=${encodeURIComponent(searchTerm.trim())}`);
            setSearchTerm(''); // Reset input sau tìm kiếm
        }
    };

    return (
        <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
            <div className="container-fluid">
                <Link className="navbar-brand" to="/">Logo</Link>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span className="navbar-toggler-icon" />
                </button>
                <div className="collapse navbar-collapse" id="mynavbar">
                    <ul className="navbar-nav me-auto">

                        {/* Hiển thị từng thể loại */}
                        {categories.map(cat => (
                            <Link className="nav-link" to={`/trangchu/the-loai/${cat.maTheLoai}`}>
                                {cat.tenTheLoai}
                            </Link>
                        ))}

                        <li className="nav-item">
                            <Link className="nav-link" to="/gio-hang">Giỏ hàng</Link>
                        </li>
                    </ul>

                    {/* Form tìm kiếm */}
                    <form className="d-flex" onSubmit={handleSearch}>
                        <input
                            className="form-control me-2"
                            type="text"
                            placeholder="Tìm sách..."
                            value={searchTerm}
                            onChange={(e) => setSearchTerm(e.target.value)}
                        />
                        <button className="btn btn-primary" type="submit">Tìm</button>
                    </form>
                </div>
            </div>
        </nav>
    );
};

export default NavbarHomePage;
