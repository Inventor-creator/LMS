import React, { useEffect, useState } from "react";
import api from "../services/api";

const EnrollCourse = () => {
    const [courses, setCourses] = useState([]);
    const [selectedCourse, setSelectedCourse] = useState("");
    const [message, setMessage] = useState("");

    // Fetch available courses
    useEffect(() => {
        const fetchCourses = async () => {
            try {
                const res = await api.get("/courses/available");
                setCourses(res.data);
            } catch (err) {
                setMessage("Failed to fetch courses.");
            }
        };
        fetchCourses();
    }, []);

    // Enroll in selected course1
    const handleEnroll = async (e) => {
        e.preventDefault();
        setMessage("");
        if (!selectedCourse) {
            setMessage("Please select a course.");
            return;
        }
        try {
            await api.post("/courses/enroll", { courseId: selectedCourse });
            setMessage("Enrolled successfully!");
        } catch (err) {
            setMessage("Enrollment failed.");
        }
    };

    return (
        <div style={{ padding: "2rem" }}>
            <h2>Enroll in a New Course</h2>
            <form onSubmit={handleEnroll}>
                <select
                    value={selectedCourse}
                    onChange={(e) => setSelectedCourse(e.target.value)}
                    style={{
                        padding: "0.5rem",
                        marginBottom: "1rem",
                        width: "100%",
                    }}
                >
                    <option value="">Select a course</option>
                    {courses.map((course) => (
                        <option key={course.id} value={course.id}>
                            {course.name}
                        </option>
                    ))}
                </select>
                <button
                    type="submit"
                    style={{
                        padding: "0.5rem 1.5rem",
                        background: "#00ffea",
                        color: "#222",
                        border: "none",
                        borderRadius: "4px",
                        cursor: "pointer",
                        fontWeight: "bold",
                    }}
                >
                    Enroll
                </button>
            </form>
            {message && (
                <div style={{ marginTop: "1rem", color: "#00ffea" }}>
                    {message}
                </div>
            )}
            <p>Here you can enroll into available courses.</p>
        </div>
    );
};

export default EnrollCourse;
