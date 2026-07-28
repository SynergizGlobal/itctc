import api from "./api";


export const getAllSleeperSpacing = async () => {
  const response = await api.get("/sleeper-spacing");
  return response.data;
};


export const getSleeperSpacingById = async (id) => {
  const response = await api.get(`/sleeper-spacing/${id}`);
  return response.data;
};


export const createSleeperSpacing = async (payload) => {
  const response = await api.post("/sleeper-spacing", payload);
  return response.data;
};


export const updateSleeperSpacing = async (id, payload) => {
  const response = await api.put(`/sleeper-spacing/${id}`, payload);
  return response.data;
};


export const deleteSleeperSpacing = async (id,updatedBy) => {
  const response = await api.delete(`/sleeper-spacing/${id}?updatedBy=${updatedBy}`);
  return response.data;
};