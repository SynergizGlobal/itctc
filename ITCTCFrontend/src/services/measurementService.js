import api from "./api";

/**
 * ==========================================
 * C-1 Measurement APIs
 * ==========================================
 */


export const saveMeasurement = async (data) => {

    const response = await api.post("/measurements", data);

    return response.data;
};


export const getMeasurementById = async (measurementId) => {

    const response = await api.get(`/measurements/${measurementId}`);

    return response.data;
};


export const getAllMeasurements = async () => {

    const response = await api.get("/measurements/all");

    return response.data;
};


export const updateMeasurement = async (measurementId, data) => {

    const response = await api.put(
        `/measurements/${measurementId}`,
        data
    );

    return response.data;
};


export const deleteMeasurement = async (measurementId, updatedBy) => {

    const response = await api.delete(
        `/measurements/${measurementId}`,
        {
            params: {
                updatedBy
            }
        }
    );

    return response.data;
};