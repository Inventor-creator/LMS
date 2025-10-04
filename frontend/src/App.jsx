import { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, useLocation, Navigate } from 'react-router-dom';
import './App.css';
import Navbar from "./components/Navbar";
import EnrolledCourses from "./pages /EnrolledCourses";
import Homepage from "./pages /Homepage";
import Login from "./pages /Login";
import api from './services/api';

function RequireAuth({ children }) {
  const location = useLocation();
  const [checking, setChecking] = useState(true);
  const [valid, setValid] = useState(false);

  useEffect(() => {
    // Get username from localStorage if available
    const storedUser = localStorage.getItem("user");
    let username = "";
    if (storedUser) {
      try {
        username = JSON.parse(storedUser).username || "";
      } catch {
        username = "";
      }
    }

    api.post('/checkValid', { username })
      .then(() => {
        setValid(true);
        setChecking(false);
      })
      .catch(() => {
        setValid(false);
        setChecking(false);
      });
  }, [location]);

  if (checking) return <div>Checking authentication...</div>;
  if (!valid) return <Navigate to="/login" replace />;
  return children;
}

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route
          path="/courses"
          element={
            <RequireAuth>
              <EnrolledCourses />
            </RequireAuth>
          }
        />
        <Route
          path="/"
          element={
            <RequireAuth>
              <Homepage />
            </RequireAuth>
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
