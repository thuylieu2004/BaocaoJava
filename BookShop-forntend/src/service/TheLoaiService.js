import axios from 'axios'

const REST_API_BASE_URL = 'http://localhost:9090/api/theloais'


export const getAllTheLoai = () => axios.get(REST_API_BASE_URL);
export const getTheLoaiById = (theLoaiId) => axios.get(REST_API_BASE_URL + '/' + theLoaiId)

export const createTheLoai = (theloais) => axios.get(REST_API_BASE_URL + '/' + theloais)
export const updateTheLoai = (theLoaiId, theloais) => axios.put(REST_API_BASE_URL + '/' + theLoaiId, theloais)
export const deleteTheLoai = (theLoaiId) => axios.delete(REST_API_BASE_URL + '/' + theLoaiId)

