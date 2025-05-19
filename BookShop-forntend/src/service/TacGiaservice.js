import axios from 'axios'

const REST_API_BASE_URL = 'http://localhost:9090/api/tacgias'


export const getAlltacgia = () => axios.get(REST_API_BASE_URL);

export const createTacgia = (tacgias) => axios.post(REST_API_BASE_URL, tacgias);

export const getTacGiayId = (tacgiaid) => axios.get(REST_API_BASE_URL + '/' + tacgiaid)
export const updateTacgia = (tacgiaid, tacgias) => axios.put(REST_API_BASE_URL + '/' + tacgiaid, tacgias)
export const deleteTacGia = (tacgiaid) => axios.delete(REST_API_BASE_URL + '/' + tacgiaid)