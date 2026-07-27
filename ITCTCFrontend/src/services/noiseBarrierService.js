import api from "./api";


export const getAllNoiseBarrierMeasurements = async () => {

    const response = await api.get("/noise-barrier-measurements");

    return response.data;
};


export const getNoiseBarrierMeasurementById = async (id) => {

    const response = await api.get(`/noise-barrier-measurements/${id}`);

    return response.data;
};


export const saveNoiseBarrierMeasurement = async (payload) => {

    const response = await api.post("/noise-barrier-measurements", payload);

    return response.data;
};


export const updateNoiseBarrierMeasurement = async (id, payload) => {

    const response = await api.put(`/noise-barrier-measurements/${id}`, payload);

    return response.data;
};


export const deleteNoiseBarrierMeasurement = async (id) => {

    const response = await api.delete(
        `/noise-barrier-measurements/${id}`
    );

    return response.data;
};