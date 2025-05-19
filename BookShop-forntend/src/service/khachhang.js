import axios from 'axios'

const REST_API_BASE_URL = 'http://localhost:9090/api/khachhangs'


export const getAllKhachHang = () => axios.get(REST_API_BASE_URL);

export const createKhachHang = (khachhang) => axios.post(REST_API_BASE_URL, khachhang);
export const getKhachhangById = (khachhangid) => axios.get(REST_API_BASE_URL + '/' + khachhangid)
export const updateKhachHang = (khachhangid,khachhang) => axios.put(REST_API_BASE_URL + '/' + khachhangid,khachhang)
export const deleteKhachhang = (khachhangid) => axios.delete(REST_API_BASE_URL + '/' + khachhangid)



