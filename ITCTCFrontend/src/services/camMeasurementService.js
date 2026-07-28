import api from "./api";


export const getAllCamMeasurements = async () => {
    const response = await api.get("/cam-measurements");
    return response.data;
};


export const getCamMeasurementById = async (id) => {
    const response = await api.get(`/cam-measurements/${id}`);
    return response.data;
};


export const saveCamMeasurement = async (data) => {
    const response = await api.post("/cam-measurements", data);
    return response.data;
};


export const updateCamMeasurement = async (id, data) => {
    const response = await api.put(`/cam-measurements/${id}`, data);
    return response.data;
};


export const deleteCamMeasurement = async (id,updatedBy) => {
    const response = await api.delete(`/cam-measurements/${id}?updatedBy=${updatedBy}`);
    return response.data;
};