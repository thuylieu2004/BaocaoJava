import React, { useEffect, useState } from 'react';
import { getAllsach } from '../../service/Sachservice';
import BookCard from './BookCard';
import { useLocation, useParams } from 'react-router-dom';

const BookHomeList = () => {
  const [sachs, setSachs] = useState([]);
  const location = useLocation();
  const { maTheLoai } = useParams(); // Lấy thể loại từ route nếu có

  const searchParams = new URLSearchParams(location.search);
  const keyword = searchParams.get('query')?.toLowerCase() || '';

  useEffect(() => {
    getAllsach()
      .then((res) => {
        let allBooks = res.data || [];

        if (keyword) {
          // Tìm kiếm theo tên sách
          allBooks = allBooks.filter((book) =>
            book.tenSach.toLowerCase().includes(keyword)
          );
        }

        if (maTheLoai) {
          // Lọc theo thể loại nếu có
          allBooks = allBooks.filter((book) =>
            String(book.maTheLoai) === String(maTheLoai)
          );
        }

        setSachs(allBooks);
      })
      .catch((error) => {
        console.error('Lỗi khi lấy danh sách sách:', error);
      });
  }, [keyword, maTheLoai, location.key]);

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">
        {keyword
          ? `Kết quả tìm kiếm cho "${keyword}"`
          : maTheLoai
          ? `Sách theo thể loại`
          : 'Tất cả sách'}
      </h2>
      <div className="row">
        {sachs.length > 0 ? (
          sachs.map((book) => <BookCard key={book.maSach} book={book} />)
        ) : (
          <div className="col-12 text-center">Không có sách nào được tìm thấy</div>
        )}
      </div>
    </div>
  );
};

export default BookHomeList;
