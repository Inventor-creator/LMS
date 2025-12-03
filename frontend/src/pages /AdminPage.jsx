import React from "react";

const AdminPage = () => {
    const accessLevel = localStorage.getItem("accessLevel");

    if (accessLevel === 1) {
        return (
            <div style={{ padding: 40 }}>
                <h1>Admin Dashboard</h1>
                <p>Welcome, admin! Here you can manage users and courses.</p>
                <div
                    style={{
                        marginTop: 24,
                        background: "#222",
                        color: "#fff",
                        padding: 24,
                        borderRadius: 8,
                    }}
                >
                    <h2>Admin Actions</h2>
                    <ul>
                        <li>Add courses</li>
                    </ul>
                </div>
            </div>
        );
    } else if (accessLevel === 2) {
        return (
            <div style={{ padding: 40 }}>
                <h1>Admin Dashboard</h1>
                <p>Welcome, admin! Here you can manage users and courses.</p>
                <div
                    style={{
                        marginTop: 24,
                        background: "#222",
                        color: "#fff",
                        padding: 24,
                        borderRadius: 8,
                    }}
                >
                    <h2>Admin Actions</h2>
                    <ul>
                        <li>Add courses</li>
                    </ul>
                </div>
            </div>
        );
    }
};

export default AdminPage;
