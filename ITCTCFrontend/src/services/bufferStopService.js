import api from "./api";

// Create
export const createBufferStop = async (data) => {
    const response = await api.post("/buffer-stop", data);
    return response.data;
};

// Get By Id
export const getBufferStopById = async (id) => {
    const response = await api.get(`/buffer-stop/${id}`);
    return response.data;
};

// Get All
export const getAllBufferStops = async () => {
    const response = await api.get("/buffer-stop");
    return response.data;
};

// Update
export const updateBufferStop = async (id, data) => {
    const response = await api.put(`/buffer-stop/${id}`, data);
    return response.data;
};

// Delete
export const deleteBufferStop = async (id, updatedBy) => {
    const response = await api.delete(`/buffer-stop/${id}?updatedBy=${updatedBy}`);
    return response.data;
};