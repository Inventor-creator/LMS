import { Link, useLocation, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const Navbar = () => {
    const location = useLocation();
    const navigate = useNavigate();
    const [username, setUsername] = useState("");
    const [userRole, setRole] = useState("");
    const accessAdmin = localStorage.getItem("accessLevel");
    useEffect(() => {
        const username = localStorage.getItem("uName");
        const role = localStorage.getItem("role");
        if (username) {
            try {
                setUsername(username || "");
                setRole(role || "");
            } catch {
                setUsername("");
                setRole("");
            }
        } else {
            setUsername("");
            setRole("");
        }
    }, [location]);

    const linkStyle = (paths) => {
        const match = Array.isArray(paths)
            ? paths.includes(location.pathname)
            : location.pathname === paths;
        return {
            marginRight: "2rem",
            fontWeight: "bold",
            fontSize: "1.1rem",
            textDecoration: "none",
            color: match ? "#00ffea" : "#fff",
            textShadow: match ? "0 0 8px #00ffea" : "none",
            transition: "color 0.2s",
        };
    };

    const handleUsernameClick = () => {
        navigate("/login");
    };

    if (userRole === "student") {
        return (
            <nav
                style={{
                    position: "fixed",
                    top: 0,
                    left: 0,
                    width: "100%",
                    zIndex: 1000,
                    display: "flex",
                    alignItems: "center",
                    padding: "1rem 2rem",
                    background: "#222",
                    borderBottom: "2px solid #424242ff",
                    boxShadow: "0 2px 8px rgba(0,0,0,0.05)",
                    borderRadius: "8px 8px 8px 8px",
                    marginLeft: "4px",
                    marginRight: "4px",
                }}
            >
                <div
                    style={{
                        display: "flex",
                        alignItems: "center",
                        flex: "0 1 auto",
                    }}
                >
                    <Link to="/" style={linkStyle("/")}>
                        LMS
                    </Link>
                    {username && (
                        <Link
                            to="/courses"
                            style={linkStyle(["/courses", "/enroll"])}
                        >
                            My Courses
                        </Link>
                    )}
                    {!username && (
                        <Link to="/login" style={linkStyle("/login")}>
                            Login
                        </Link>
                    )}
                </div>
                <div style={{ flex: "0.95 0 auto" }} />
                {username && (
                    <div
                        style={{
                            color: "#00ffea",
                            fontWeight: "bold",
                            fontSize: "1.1rem",
                            maxWidth: "200px",
                            overflow: "hidden",
                            textOverflow: "ellipsis",
                            whiteSpace: "nowrap",
                            cursor: "pointer",
                        }}
                        onClick={handleUsernameClick}
                        title="Go to Login"
                    >
                        {username}
                    </div>
                )}
            </nav>
        );
    } else if (userRole === "admin") {
        if (parseInt(accessAdmin) === 1) {
            return (
                <nav
                    style={{
                        position: "fixed",
                        top: 0,
                        left: 0,
                        width: "100%",
                        zIndex: 1000,
                        display: "flex",
                        alignItems: "center",
                        padding: "1rem 2rem",
                        background: "#222",
                        borderBottom: "2px solid #424242ff",
                        boxShadow: "0 2px 8px rgba(0,0,0,0.05)",
                        borderRadius: "8px 8px 8px 8px",
                        marginLeft: "4px",
                        marginRight: "4px",
                    }}
                >
                    <div
                        style={{
                            display: "flex",
                            alignItems: "center",
                            flex: "0 1 auto",
                        }}
                    >
                        {/* add admin dashboard stuff here*/}
                        <Link to="/" style={linkStyle("/")}>
                            LMS
                        </Link>

                        {username && (
                            <Link
                                to="/createCourse"
                                style={linkStyle(["/createCourse"])}
                            >
                                Create Courses
                            </Link>
                        )}

                        {username && (
                            <Link
                                to="/addStudents"
                                style={linkStyle(["/addStudents"])}
                            >
                                Add Students
                            </Link>
                        )}

                        {!username && (
                            <Link to="/login" style={linkStyle("/login")}>
                                Login
                            </Link>
                        )}
                    </div>

                    <div style={{ flex: "0.95 0 auto" }} />
                    {username && (
                        <div
                            style={{
                                color: "#00ffea",
                                fontWeight: "bold",
                                fontSize: "1.1rem",
                                maxWidth: "200px",
                                overflow: "hidden",
                                textOverflow: "ellipsis",
                                whiteSpace: "nowrap",
                                cursor: "pointer",
                            }}
                            onClick={handleUsernameClick}
                            title="Go to Login"
                        >
                            {username}
                        </div>
                    )}
                </nav>
            );
        }
    }
};

export default Navbar;
