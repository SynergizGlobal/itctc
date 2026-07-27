import api from "./api";

/**
 * Get All Track Irregularities
 */
export const getAllTrackIrregularities = async () => {
    const response = await api.get("/track-irregularities");
    return response.data;
};

/**
 * Get Track Irregularity By Id
 */
export const getTrackIrregularityById = async (id) => {
    const response = await api.get(`/track-irregularities/${id}`);
    return response.data;
};

/**
 * Save Track Irregularity
 */
export const saveTrackIrregularity = async (payload) => {
    const response = await api.post("/track-irregularities", payload);
    return response.data;
};

/**
 * Update Track Irregularity
 */
export const updateTrackIrregularity = async (id, payload) => {
    const response = await api.put(`/track-irregularities/${id}`, payload);
    return response.data;
};

/**
 * Delete Track Irregularity
 */
export const deleteTrackIrregularity = async (id, updatedBy) => {
    const response = await api.delete(
        `/track-irregularities/${id}?updatedBy=${updatedBy}`
    );

    return response.data;
};