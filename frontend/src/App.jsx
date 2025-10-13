import { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, useLocation, Navigate } from 'react-router-dom';
import './App.css';
import Navbar from "./components/Navbar";
import EnrolledCourses from "./pages /EnrolledCourses";
import Homepage from "./pages /Homepage";
import Login from "./pages /Login";
import api from './services/api';
import AdminPage from './pages /AdminPage'; // Import your admin page component
import EnrollCourse from './pages /EnrollCourse';

// Pass requiredRole to RequireAuth for role-based access
function RequireAuth({ children, requiredRole }) {
	const location = useLocation();
	const [checking, setChecking] = useState(true);
	const [valid, setValid] = useState(false);
	let id = localStorage.getItem("userId");
  useEffect(() => {
    // Get user info from localStorage
    const username = localStorage.getItem("user");
    let role = localStorage.getItem("role");
	let id = localStorage.getItem("userId");
	
	//checks if the local storage username and role is valid or not
	api.post('/checkValid', { "name" : username  , "role": role , "id" : id })
	.then(() => {
        // If a requiredRole is specified, check if user has it
        if (requiredRole && role != requiredRole )  {
			console.log("Role mismatch");
          	setValid(false);
        } else {
          setValid(true);
        }
        setChecking(false);
	}).catch(() => {
        setValid(false);
        setChecking(false);
      });
  }, [location, requiredRole ,id ]);

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
			<RequireAuth requiredRole="student">
				<EnrolledCourses />
			</RequireAuth>
			}
        />
		<Route path='/enroll' element={
			<RequireAuth requiredRole="student">
				<EnrollCourse />
			</RequireAuth>
		} />
        <Route
          path="/"
          element={
            
			<Homepage />
            
          }
        />

        <Route
          path="/admin"
          element={
            <RequireAuth requiredRole="admin">
              <AdminPage />
            </RequireAuth>
          }          
        />

		

      </Routes>
    </BrowserRouter>
  );
}

export default App;
