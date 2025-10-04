import React, { useEffect, useState } from 'react';
import api from '../services/api';

const EnrolledCourses = () => {
  const [courses, setCourses] = useState([]);
  const [loading, setLoading] = useState(true);
  const [isActive, setIsActive] = useState(0);

  // Fetch courses based on isActive
  const fetchCourses = (activeStatus) => {
    setLoading(true);
    api.get(`/enrolledCourses/3?isActive=${activeStatus}`)
      .then(({ data }) => {
        setCourses(data || []);
        setLoading(false);
      })
      .catch((error) => {
        console.error('Failed to fetch courses:', error);
        setLoading(false);
      });
  };

  useEffect(() => {
    fetchCourses(isActive);
  }, [isActive]);

  const handleFilterClick = () => {
    setIsActive(isActive === 1 ? 0 : 1);
  };

  return (
    <>
      <div
        style={{
          position: "fixed",
          top: "70px", // Adjust if your navbar height is different
          left: 0,
          width: "100%",
          background: "#242424", // <-- Change from "#fff" to "#222"
          color: "#fff",      // <-- Add this for white text
          zIndex: 999,
          borderBottom: "1px solid #333",
          padding: "16px 0 8px 0",
        }}
      >
        <h1 style={{ margin: 0, textAlign: "center" }}>My Courses</h1>
      </div>
      <section style={{ padding: "110px 20px 20px 20px" }}>
        <div style={{ marginBottom: "2rem" }}>
          <button
            onClick={handleFilterClick}
            style={{
              marginTop: "1rem",
              padding: "0.5rem 1.2rem",
              background: isActive ? "#007bff" : "#444",
              color: "#fff",
              border: "none",
              borderRadius: "4px",
              cursor: "pointer"
            }}
          >
            {isActive ? "Show Ongoing Courses" : "Show Completed Courses"}
          </button>
        </div>
        {loading ? (
          <div>Loading...</div>
        ) : (
          <table style={{ width: "100%", borderCollapse: "collapse", marginTop: "1rem" }}>
            <thead>
              <tr style={{ background: "#222", color: "#fff" }}>
                <th style={{ padding: "0.75rem", border: "1px solid #333" }}>Course Name</th>
                <th style={{ padding: "0.75rem", border: "1px solid #333" }}>Instructor</th>
              </tr>
            </thead>
            <tbody>
              {courses.length === 0 ? (
                <tr>
                  <td colSpan={2} style={{ textAlign: "center", padding: "1rem" }}>No courses found.</td>
                </tr>
              ) : (
                courses.map((course) => (
                  <tr key={course.courseId}>
                    <td style={{ padding: "0.75rem", border: "1px solid #767575ff" }}>{course.courseName}</td>
                    <td style={{ padding: "0.75rem", border: "1px solid #767575ff" }}>
                      {course.instructor?.instructorName || "N/A"}
                    </td>
                  </tr>
                ))
              )}
            </tbody>
          </table>
        )}
      </section>
    </>
  );
};

export default EnrolledCourses;
