import React, { useEffect, useState } from "react";
import api from "../services/api";

const EnrollCourse = () => {
    const [courses, setCourses] = useState([]);
    const [selectedCourse, setSelectedCourse] = useState("");
    const [message, setMessage] = useState("");
    const userId = localStorage.getItem("userId");
    useEffect(() => {
        const fetchCourses = async () => {
            try {
                const res = await api.get(`/getCoursesByYear/${userId}`);

                setCourses(res.data);
                setSelectedCourse(res.data[0].courseId);
                console.log(res.data);
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
            await api.post("/courses/enroll", {
                studentId: userId,
                courseId: selectedCourse,
            });
            setMessage("Enrolled successfully!");
        } catch (err) {
            setMessage("Enrollment failed.");
        }
    };

    const SelectCourse = (e) => {
        setSelectedCourse(e.target.value);
    };

    return (
        <div style={{ padding: "2rem" }}>
            <h2>Enroll in a New Course</h2>
            <form onSubmit={handleEnroll}>
                <select
                    onSelect={(e) => setSelectedCourse(e.target.value)}
                    style={{
                        padding: "0.5rem",
                        marginBottom: "1rem",
                        width: "100%",
                    }}
                >
                    {courses.map((course) => (
                        <option key={course.courseId} value={course.courseId}>
                            {course.courseName} :{" "}
                            {course.instructor.instructorName}
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
