import React from "react";
import { useEffect } from "react";
import api from "../services/api";
import { useState } from "react";
import SearchInstructorBox from "../components/SearchInstructor";

const CreateCourses = () => {
    const [courses, setCourses] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const [search, setSearch] = useState("");

    // form state for creating a new course
    const [form, setForm] = useState({
        title: "",
        description: "",
        instructor: "",
        duration: "",
    });
    const [creating, setCreating] = useState(false);

    // fetch the courses from backend

    // create course
    const handleCreate = async (e) => {
        e.preventDefault();
        setCreating(true);
        setError(null);

        // const createCourseObj = {
        //     coruseName:
        // };

        try {
            const res = await api.post("/createCourse", {});
        } catch (err) {
            if (err.name !== "AbortError")
                setError(err.message || "Unknown error");
        } finally {
            setCreating(false);
        }
    };

    useEffect(() => {
        const fetchCourses = async () => {
            setLoading(true);
            setError(null);
            try {
                const res = await api.get("/getCourses");

                // expect data to be an array of courses
                setCourses(res.data);

                console.log(courses);
            } catch (err) {
                if (err.name !== "AbortError")
                    setError(err.message || "Unknown error");
            } finally {
                setLoading(false);
            }
        };

        fetchCourses();
    }, []);

    // here admin is moderator of the system, can add or remove courses, assign instructors
    return (
        <>
            <div
                className="p-6 max-w-6xl mx-auto"
                style={{
                    display: "grid",
                    gridTemplateColumns:
                        "auto auto" /* left fixed, right fills remaining space */,
                    gap: " 1rem",
                }}
            >
                {/* Create form */}
                <form>
                    <h2>Create Course</h2>
                    <div className="grid grid-cols-1 gap-3 mb-4 justify-items-start">
                        <input
                            style={{
                                width: "200px",
                                height: "37px",
                                fontSize: "20px",
                                float: "left",
                                margin: "0 10px",
                            }}
                            placeholder="Title*"
                            value={form.title}
                            onChange={(e) =>
                                setForm({ ...form, title: e.target.value })
                            }
                            required
                        />

                        <div
                            style={{
                                width: "200px",
                                height: "50px",
                                fontSize: "20px",
                                margin: "0 10px",
                            }}
                        >
                            <SearchInstructorBox />
                        </div>

                        <button
                            style={{ marginTop: "5px" }}
                            type="submit"
                            disabled={creating}
                            className="px-4 py-2 rounded shadow hover:opacity-90 font-semibold"
                        >
                            {creating ? "Creating..." : "Create Course"}
                        </button>
                    </div>
                </form>

                {/* Search + errors */}
                <div className="flex items-center justify-between mb-4">
                    <h2>Search Course</h2>
                    <div className="flex items-center gap-2">
                        <input
                            style={{
                                marginTop: "5px",
                                width: "200px",
                                height: "40px",
                                fontSize: "20px",
                            }}
                            value={search}
                            onChange={(e) => setSearch(e.target.value)}
                            placeholder="Search by title, instructor or description"
                            className="p-2 rounded border w-80 bg-transparent"
                        />
                        <button
                            onClick={() => setSearch("")}
                            className="px-3 py-1 rounded border"
                        >
                            Clear
                        </button>
                    </div>
                </div>
            </div>
            <p> {courses}</p>
        </>
    );
};

export default CreateCourses;
