import axios from 'axios'

const REST_API_BASE_URL = 'http://localhost:9090/api/taikhoans'


export const getAllTaiKhoan = () => axios.get(REST_API_BASE_URL);

export const createTaikhoan = (taikhoans) => axios.post(REST_API_BASE_URL, taikhoans);
export const getTaiKhoanById = (taikhoanid) => axios.get(REST_API_BASE_URL + '/' + taikhoanid)
export const updateTaikhoan = (taikhoanid, taikhoans) => axios.put(REST_API_BASE_URL + '/' + taikhoanid, taikhoans)
export const deleteTaikhoan = (taikhoanid) => axios.delete(REST_API_BASE_URL + '/' + taikhoanid)



