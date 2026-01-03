import { useEffect, useState } from "react";
import api from "../services/api";

var items = [];

const SearchCourseBox = ({ onSelect }) => {
    const [searchedCourses, setsearchedCourses] = useState([]);
    const [SearchSimilarCourses, setSearchSimilarCourses] = useState("");

    function handleGetInstructor(e) {
        if (e.key === "Enter") {
            e.preventDefault();
            items = [];
            if (SearchSimilarCourses) {
                api.get(`/searchCourses/${SearchSimilarCourses.toLowerCase()}`)
                    .then((response) => {
                        let resData = response.data;
                        onSelect(resData[0].instructorId);
                        resData.map((instructor) => {
                            //add pfp and shit with hovering shit

                            items.push(
                                <option value={instructor.instructorId}>
                                    {instructor.instructorId}:{" "}
                                    {instructor.instructorName}
                                </option>,
                            );

                            setsearchedCourses(items);
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
                        setSearchSimilarCourses(e.target.value);
                    }}
                    required
                />

                <select
                    // id of the instructor not the actucal object
                    defaultValue={searchedCourses[0]}
                    onChange={(e) => {
                        onSelect(e.target.value);
                    }}
                >
                    {searchedCourses}
                </select>
            </div>
        </>
    );
};

export default SearchCourseBox;
