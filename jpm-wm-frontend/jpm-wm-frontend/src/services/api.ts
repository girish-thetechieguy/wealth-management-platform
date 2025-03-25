import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export const fetchInvestments = async () => {
  const response = await axios.get(`${API_URL}/investments`);
  return response.data;
};

export const fetchRetirementData = async () => {
  const response = await axios.get(`${API_URL}/retirement`);
  return response.data;
};