
import React from 'react';
import { useNavigate } from 'react-router-dom';

const BookCard = ({ book }) => {
  const navigate = useNavigate();

  return (
    <div className="col-md-3 mb-4">
      <div className="card h-100">
        <img
          src={
            book.hinhAnh
              ? `http://localhost:9090/images/${book.hinhAnh}`
              : 'https://placehold.co/150x200?text=No+Image'
          }
          className="card-img-top"
          alt={book.tenSach}
          style={{ height: "250px", objectFit: "cover" }}
        />
        <div className="card-body d-flex flex-column">
          <h5 className="card-title">{book.tenSach}</h5>
          <p className="card-text text-danger fw-bold">
            {book.giaBan?.toLocaleString('vi-VN') || 0} đ
          </p>
          <button
            className="btn btn-outline-primary mt-auto"
            onClick={() => navigate(`/xem-sach/${book.maSach}`)}
          >
            Xem chi tiết
          </button>
        </div>
      </div>
    </div>
  );
};

export default BookCard;
