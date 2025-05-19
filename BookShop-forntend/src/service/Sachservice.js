import axios from 'axios'

const REST_API_BASE_URL = 'http://localhost:9090/api/sachs'


export const getAllsach = () => axios.get(REST_API_BASE_URL);

export const createsach = (sach) => axios.post(REST_API_BASE_URL, sach);
export const getSachById = (sachId) => axios.get(REST_API_BASE_URL + '/' + sachId)
export const updateSach = (sachId,sachs) => axios.put(REST_API_BASE_URL + '/' + sachId,sachs)
export const deleteSach = (sachId) => axios.delete(REST_API_BASE_URL + '/' + sachId)



