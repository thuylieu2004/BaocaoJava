import axios from 'axios'

const REST_API_BASE_URL = 'http://localhost:9090/api/chitiethoadons'


export const getAllChiTietHoaDon = () => axios.get(REST_API_BASE_URL);

export const createHoaDon = (cthoadon) => axios.post(REST_API_BASE_URL, cthoadon);
export const getCTHoaDonById = (cthoadonid) => axios.get(REST_API_BASE_URL + '/' + cthoadonid)
export const updateCTHoaDon = (cthoadonid, cthoadon) => axios.put(REST_API_BASE_URL + '/' + cthoadonid, cthoadon)
export const deleteCTHoaDon = (cthoadonid) => axios.delete(REST_API_BASE_URL + '/' + cthoadonid)



