import React from 'react';
import { useNavigate } from 'react-router-dom';

function HeaderHomePage() {
    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.removeItem("token");
        navigate('/dangnhap');
    };

    return (
        <div className="jumbotron mb-0">
            <div className="container">
                <div className="row align-items-center">
                    <div className="col-12 text-center">
                        <h1>Book Store</h1>
                    </div>
                </div>
                <div className="row">
                    <div className="col text-end">
                        <button className="btn btn-outline-danger mt-2" onClick={handleLogout}>
                            Đăng Xuất
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default HeaderHomePage;
