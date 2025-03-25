import { useQuery } from '@tanstack/react-query';
import { fetchInvestments } from '../services/api';

export const useInvestments = () => {
  return useQuery(['investments'], fetchInvestments);
};