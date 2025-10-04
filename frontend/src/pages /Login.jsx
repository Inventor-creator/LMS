import React, { useState } from "react";
import api from "../services/api";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    try {
      // Send credentials to backend
      const res = await api.post("/login",  { "email" : username, "password" :  password });
      // Assuming backend sets a cookie via Set-Cookie header
      // If you need to set manually, use document.cookie:
      document.cookie = `jwt=${res.data.token}; path=/;`;
      localStorage.setItem("user", JSON.stringify({ username }));
      window.location.href = "/";
    } catch (err) {
      setError("Invalid credentials");
    }
  };

  return (
    <div style={{ maxWidth: 400, margin: "120px auto", padding: 24, background: "#222", color: "#fff", borderRadius: 8 }}>
      <h2 style={{ textAlign: "center" }}>Login</h2>
      <form onSubmit={handleSubmit} style={{ display: "flex", flexDirection: "column", gap: 16 }}>
        <input
          type="text"
          placeholder="email"
          value={username}
          onChange={e => setUsername(e.target.value)}
          style={{ padding: 10, borderRadius: 4, border: "1px solid #444" }}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          style={{ padding: 10, borderRadius: 4, border: "1px solid #444" }}
          required
        />
        <button type="submit" style={{ padding: 10, borderRadius: 4, background: "#00ffea", color: "#222", fontWeight: "bold", border: "none", cursor: "pointer" }}>
          Login
        </button>
        {error && <div style={{ color: "#ff4d4f", textAlign: "center" }}>{error}</div>}
      </form>
    </div>
  );
};

export default Login;