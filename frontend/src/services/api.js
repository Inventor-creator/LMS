import axios from 'axios';


const api = axios.create({
  baseURL: import.meta.env.VITE_BACKEND,   // adjust to your backend
  withCredentials: true,                  // if you use cookies / sessions
});

export const login    = (data) => api.post('/auth/login', data);
export const getMe    = ()       => api.get('/users/me');
export const getCourses = ()     => api.get('/courses');
export default api;