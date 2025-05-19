import axios from 'axios'

const REST_API_BASE_URL = 'http://localhost:9090/api/hoadons'


export const getAllHoaDon = () => axios.get(REST_API_BASE_URL);

export const createHoaDon = (hoadon) => axios.post(REST_API_BASE_URL, hoadon);
export const getHoaDonById = (hoadonid) => axios.get(REST_API_BASE_URL + '/' + hoadonid)
export const updateHoaDon = (hoadonid,hoadon) => axios.put(REST_API_BASE_URL + '/' + hoadonid,hoadon)
export const deleteSach = (hoadonid) => axios.delete(REST_API_BASE_URL + '/' + hoadonid)



