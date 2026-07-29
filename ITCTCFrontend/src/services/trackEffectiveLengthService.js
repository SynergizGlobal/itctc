import api from "./api";

// Create
export const createTrackEffectiveLength = async (data) => {
    const response = await api.post("/track-effective-length", data);
    return response.data;
};

// Get By Id
export const getTrackEffectiveLengthById = async (id) => {
    const response = await api.get(`/track-effective-length/${id}`);
    return response.data;
};

// Get All
export const getAllTrackEffectiveLengths = async () => {
    const response = await api.get("/track-effective-length");
    return response.data;
};

// Update
export const updateTrackEffectiveLength = async (id, data) => {
    const response = await api.put(`/track-effective-length/${id}`, data);
    return response.data;
};

// Delete
export const deleteTrackEffectiveLength = async (id, updatedBy) => {
    const response = await api.delete(`/track-effective-length/${id}?updatedBy=${updatedBy}`);
    return response.data;
};