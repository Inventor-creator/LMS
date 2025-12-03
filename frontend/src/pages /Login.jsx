import React, { useState } from "react";
import api from "../services/api";
import { redirect } from "react-router-dom";

const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError("");
        try {
            const res = await api.post("/login", {
                email: username,
                password: password,
            });

            localStorage.setItem("user", `${res.data.name}`);
            localStorage.setItem("role", `${res.data.role}`);
            localStorage.setItem("userId", `${res.data.id}`);
            localStorage.setItem("uName", `${res.data.uName}`);

            if (res.data.accessLevel > 0) {
                localStorage.setItem("accessLevel", `${res.data.accessLevel}`);
            }

            window.location.href = "/";
        } catch (err) {
            setError("Invalid credentials");
        }
    };

    return (
        <div
            style={{
                maxWidth: 400,
                margin: "120px auto",
                padding: 24,
                background: "#222",
                color: "#fff",
                borderRadius: 8,
            }}
        >
            <h2 style={{ textAlign: "center" }}>Login</h2>
            <form
                onSubmit={handleSubmit}
                style={{ display: "flex", flexDirection: "column", gap: 16 }}
            >
                <input
                    type="text"
                    placeholder="email"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    style={{
                        padding: 10,
                        borderRadius: 4,
                        border: "1px solid #444",
                    }}
                    required
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    style={{
                        padding: 10,
                        borderRadius: 4,
                        border: "1px solid #444",
                    }}
                    required
                />
                <button
                    type="submit"
                    style={{
                        padding: 10,
                        borderRadius: 4,
                        background: "#00ffea",
                        color: "#222",
                        fontWeight: "bold",
                        border: "none",
                        cursor: "pointer",
                    }}
                >
                    Login
                </button>
                {error && (
                    <div style={{ color: "#ff4d4f", textAlign: "center" }}>
                        {error}
                    </div>
                )}
            </form>
        </div>
    );
};

export default Login;
