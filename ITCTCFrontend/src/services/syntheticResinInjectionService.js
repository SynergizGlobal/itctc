import api from "./api";

// Create
export const createSyntheticResinInjection = async (data) => {
    const response = await api.post("/synthetic-resin-injection", data);
    return response.data;
};

// Get All
export const getAllSyntheticResinInjections = async () => {
    const response = await api.get("/synthetic-resin-injection");
    return response.data;
};

// Get By Id
export const getSyntheticResinInjectionById = async (id) => {
    const response = await api.get(`/synthetic-resin-injection/${id}`);
    return response.data;
};

// Update
export const updateSyntheticResinInjection = async (id, data) => {
    const response = await api.put(`/synthetic-resin-injection/${id}`, data);
    return response.data;
};

// Delete
export const deleteSyntheticResinInjection = async (id, updatedBy) => {
    const response = await api.delete(`/synthetic-resin-injection/${id}?updatedBy=${updatedBy}`);
    return response.data;
};