import { Link, useLocation } from "react-router-dom";
import { useEffect, useState } from "react";

const Navbar = () => {
  const location = useLocation();
  const [username, setUsername] = useState("");

  useEffect(() => {
    const username = localStorage.getItem("user");
    if (username) {
      try {

        setUsername(username || "");
      } catch {
        setUsername("");
      }
    } else {
      setUsername("");
    }
  }, [location]);

  const linkStyle = (path) => ({
    marginRight: "2rem",
    fontWeight: "bold",
    fontSize: "1.1rem",
    textDecoration: "none",
    color: location.pathname === path ? "#00ffea" : "#fff",
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
      <div style={{ display: "flex", alignItems: "center", flex: "0 1 auto" }}>
        <Link to="/" style={linkStyle("/")}>
          LMS
        </Link>
        <Link to="/courses" style={linkStyle("/courses")}>
          My Courses
        </Link>
        <Link to="/login" style={linkStyle("/login")}>
          Login
        </Link>
      </div>
      <div style={{ flex: "0.97 0 auto" }} />
      {username && (
        <div style={{
          color: "#00ffea",
          fontWeight: "bold",
          fontSize: "1.1rem",
          maxWidth: "200px",
          overflow: "hidden",
          textOverflow: "ellipsis",
          whiteSpace: "nowrap"
        }}>
         {username}
        </div>
      )}
    </nav>
  );
};

export default Navbar;