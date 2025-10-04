import { Link, useLocation } from "react-router-dom";
import { useEffect, useState } from "react";
import api from "../services/api";

const Navbar = () => {
  const location = useLocation();
  const [username, setUsername] = useState("");

  useEffect(() => {
    // Try to get username from localStorage first
    const storedUser = localStorage.getItem("user");
    if (storedUser) {
      try {
        const userObj = JSON.parse(storedUser);
        setUsername(userObj.username || "");
      } catch {
        setUsername("");
      }
    } 
  }, [location]);

  const linkStyle = (path) => ({
    marginRight: "2rem",
    fontWeight: "bold",
    fontSize: "1.1rem",
    textDecoration: "none",
    color: location.pathname === path ? "#00ffea" : "#fff", // Glow color for active tab
    textShadow: location.pathname === path ? "0 0 8px #00ffea" : "none",
    transition: "color 0.2s"
  });

  return (
    <nav style={{
      position: "fixed",
      top: 0,
      left: 0,
      width: "100%",
      zIndex: 1000,
      display: "flex",
      alignItems: "center",
      padding: "1rem 2rem",
      background: "#222",
      borderBottom: "1px solid #333",
      boxShadow: "0 2px 8px rgba(0,0,0,0.05)"
    }}>
      <Link to="/" style={linkStyle("/")}>
        LMS
      </Link>
      <Link to="/courses" style={linkStyle("/courses")}>
        My Courses
      </Link>
      <Link to="/login" style={linkStyle("/login")}>
        Login
      </Link>
      <div style={{ marginLeft: "auto", color: "#00ffea", fontWeight: "bold", fontSize: "1.1rem" }}>
        {username && `Hello, ${username}`}
      </div>
    </nav>
  );
};

export default Navbar;