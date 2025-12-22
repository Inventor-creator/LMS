import { useEffect, useState } from "react";
import api from "../services/api";

var items = [];

const SearchInstructorBox = () => {
    const [searchedInstructors, setSearchInstructors] = useState([]);
    const [searchSimilarInstructor, setSearchSimilarInstructor] = useState("");

    function handleGetInstructor(e) {
        if (e.key === "Enter") {
            e.preventDefault();

            if (searchSimilarInstructor) {
                api.get(
                    `/searchInstructors/${searchSimilarInstructor.toLowerCase()}`,
                )
                    .then((response) => {
                        let resData = response.data;

                        resData.map((instructor) => {
                            console.log(instructor);
                            //add pfp and shit with hovering shit
                            items.push(
                                <option value={instructor.instructorId}>
                                    {instructor.instructorId}:{" "}
                                    {instructor.instructorName}
                                </option>,
                            );

                            setSearchInstructors(items);
                        });
                    })
                    .catch((error) => {
                        console.error(error);
                    });
            }
        }
    }

    return (
        <>
            <div style={{ display: "flex", gap: "8px" }}>
                <input
                    id="instructorTextBox"
                    placeholder="Enter instructor name"
                    style={{ flex: 1, padding: "10px", fontSize: "16px" }}
                    onKeyDown={handleGetInstructor}
                    onChange={(e) => {
                        setSearchSimilarInstructor(e.target.value);
                    }}
                    required
                />

                <select name="selectedInstructor" defaultValue={items[0]}>
                    {searchedInstructors}
                </select>
            </div>
        </>
    );
};

export default SearchInstructorBox;
