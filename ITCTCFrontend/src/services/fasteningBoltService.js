import api from "./api";

// Create
export const createFasteningBolt = async (data) => {
    const response = await api.post("/fastening-bolt", data);
    return response.data;
};

// Get All
export const getAllFasteningBolts = async () => {
    const response = await api.get("/fastening-bolt");
    return response.data;
};

// Get By Id
export const getFasteningBoltById = async (id) => {
    const response = await api.get(`/fastening-bolt/${id}`);
    return response.data;
};

// Update
export const updateFasteningBolt = async (id, data) => {
    const response = await api.put(`/fastening-bolt/${id}`, data);
    return response.data;
};

// Delete
export const deleteFasteningBolt = async (id, updatedBy) => {
    const response = await api.delete(`/fastening-bolt/${id}?updatedBy=${updatedBy}`);
    return response.data;
};