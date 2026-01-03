import { useEffect, useState } from "react";
import api from "../services/api";
import SearchBranchesBox from "../components/SearchBranches";

const AddStudents = () => {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const [address, setAddress] = useState("");
    const [branch, setBranch] = useState("");
    const [year, setYear] = useState("");

    const handleSubmit = (event) => {
        event.preventDefault();

        api.post("/createStudent", {
            studentName: name,
            email: email,
            number: phone,
            address: address,
            branchId: branch,
            year: year,
        })
            .then(() => {
                console.log("Student created successfully");
            })
            .catch((error) => {
                console.error("Error creating student:", error);
            });
    };

    const handleBranchSelect = (selectedBranch) => {
        setBranch(selectedBranch);
    };

    return (
        <>
            <h1>Create Student</h1>
            <div
                style={{
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                }}
            >
                <form
                    style={{
                        maxWidth: "40%",
                        overflow: "visible",
                        textAlign: "center",
                    }}
                    onSubmit={handleSubmit}
                >
                    <div
                        style={{
                            display: "flex",
                            gap: "8px",
                        }}
                    >
                        <input
                            type="text"
                            placeholder="Name of Student"
                            onChange={(e) => {
                                setName(e.target.value);
                            }}
                            style={{
                                flex: 1,
                                padding: "10px",
                                fontSize: "16px",
                            }}
                        ></input>
                    </div>
                    <div style={{ display: "flex", gap: "8px" }}>
                        <input
                            type="email"
                            placeholder="Email of Student"
                            onChange={(e) => {
                                setEmail(e.target.value);
                            }}
                            style={{
                                flex: 1,
                                padding: "10px",
                                fontSize: "16px",
                            }}
                        ></input>
                    </div>
                    <div style={{ display: "flex", gap: "8px" }}>
                        <input
                            type="tel"
                            placeholder="Phone of Student"
                            onChange={(e) => {
                                setPhone(e.target.value);
                            }}
                            style={{
                                flex: 1,
                                padding: "10px",
                                fontSize: "16px",
                            }}
                        ></input>
                    </div>
                    <div style={{ display: "flex", gap: "8px" }}>
                        <input
                            type="text"
                            placeholder="Address of Student"
                            onChange={(e) => {
                                setAddress(e.target.value);
                            }}
                            style={{
                                flex: 1,
                                padding: "10px",
                                fontSize: "16px",
                            }}
                        ></input>
                    </div>
                    <div style={{ display: "flex", gap: "8px" }}>
                        <input
                            type="text"
                            placeholder="Year"
                            onChange={(e) => {
                                setYear(e.target.value);
                            }}
                            style={{
                                flex: 1,
                                padding: "10px",
                                fontSize: "16px",
                            }}
                        ></input>
                    </div>

                    <SearchBranchesBox onSelect={handleBranchSelect} />

                    <button
                        style={{
                            marginTop: "10px",
                        }}
                        type="submit"
                    >
                        Submit
                    </button>
                </form>
            </div>
        </>
    );
};

export default AddStudents;
