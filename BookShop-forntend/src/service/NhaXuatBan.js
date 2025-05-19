import axios from 'axios'

const REST_API_BASE_URL = 'http://localhost:9090/api/nhaxuatbans'


export const getAllNhaXuatBan = () => axios.get(REST_API_BASE_URL);

export const createNhaXuatBan = (nhaxuatbans) => axios.post(REST_API_BASE_URL, nhaxuatbans);
export const getNhaXBById = (nhaxuatbanid) => axios.get(REST_API_BASE_URL + '/' + nhaxuatbanid)
export const updateNhaXuatBan = (nhaxuatbanid,nhaxuatbans) => axios.put(REST_API_BASE_URL + '/' + nhaxuatbanid,nhaxuatbans)
export const deleteNhaXuaBan = (nhaxuatbanid) => axios.delete(REST_API_BASE_URL + '/' + nhaxuatbanid)



