import api from "./api";

// Create
export const createFoulingMark = async (data) => {
    const response = await api.post("/fouling-mark", data);
    return response.data;
};

// Get By Id
export const getFoulingMarkById = async (id) => {
    const response = await api.get(`/fouling-mark/${id}`);
    return response.data;
};

// Get All
export const getAllFoulingMarks = async () => {
    const response = await api.get("/fouling-mark");
    return response.data;
};

// Update
export const updateFoulingMark = async (id, data) => {
    const response = await api.put(`/fouling-mark/${id}`, data);
    return response.data;
};

// Delete
export const deleteFoulingMark = async (id, updatedBy) => {
    const response = await api.delete(`/fouling-mark/${id}?updatedBy=${updatedBy}`);
    return response.data;
};