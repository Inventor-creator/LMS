import { useEffect, useState } from "react";

const SearchInstructorBox = () => {
    const [searchedInstructors, setSearchInstructors] = useState([]);

    return (
        <>
            <div style={{ display: "flex", gap: "8px" }}>
                <input
                    type="text"
                    placeholder="Instructor"
                    style={{ flex: 1, padding: "10px", fontSize: "16px" }}
                    required
                />

                <button
                    style={{ padding: "10px 16px", fontSize: "16px" }}
                    onClick={() => console.log("button clicked")}
                >
                    Submit
                </button>
            </div>
        </>
    );
};

export default SearchInstructorBox;
