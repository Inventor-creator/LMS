import React from "react";
import { useEffect } from "react";
import api from "../services/api";
import { useState } from "react";
import SearchInstructorBox from "../components/SearchInstructor";
import SearchBranchesBox from "../components/SearchBranches";

const CreateCourses = () => {
    const [courses, setCourses] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    //here all the course data to send via json for creation
    const [selectedInstructor, setSelectedInstructor] = useState("");
    const [selectedBranch, setselectedBranch] = useState("");
    const [courseName, setCourseName] = useState("");
    const [eYear, setEYear] = useState("");

    const [search, setSearch] = useState("");

    // form state for creating a new course

    const [creating, setCreating] = useState(false);

    // fetch the courses from backend

    // create course
    const handleCreate = async (e) => {
        e.preventDefault();
        setCreating(true);
        setError(null);

        let course = {
            courseName: courseName,
            instructorId: selectedInstructor,
            enrollmentYear: eYear,
            branchId: selectedBranch,
        };

        try {
            const res = await api.post("/createCourse", course);
            console.log(res);
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

    const handleSelectedInstructor = (instructorId) => {
        setSelectedInstructor(instructorId);
    };

    const handleSelectedBranch = (branchId) => {
        setselectedBranch(branchId);
    };

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
                <form onSubmit={handleCreate}>
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
                            placeholder="Title"
                            onChange={(e) => setCourseName(e.target.value)}
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
                            <SearchInstructorBox
                                onSelect={handleSelectedInstructor}
                            />
                        </div>

                        <input
                            style={{
                                width: "200px",
                                height: "37px",
                                fontSize: "20px",
                                float: "left",
                                margin: "0 10px",
                            }}
                            type="number"
                            placeholder="Enrollement Year"
                            onChange={(e) => {
                                if (
                                    parseInt(e.target.value) > 0 &&
                                    parseInt(e.target.value) <= 4
                                ) {
                                    setEYear(e.target.value);
                                } else {
                                    alert("Enrollment year between 1 and 4");
                                    e.target.value = "";
                                }
                            }}
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
                            <SearchBranchesBox
                                onSelect={handleSelectedBranch}
                            />
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

                {/* dosent work as of yet*/}
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
        </>
    );
};

export default CreateCourses;
