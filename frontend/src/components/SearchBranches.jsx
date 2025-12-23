import { useEffect, useState, setForm } from "react";
import api from "../services/api";

const SearchBranchesBox = ({ onSelect }) => {
    const [searchedBranches, setsearchBranches] = useState([]);
    const [searchSimilarBranch, setsearchSimilarBranch] = useState("");

    function handleGetBranch(e) {
        if (e.key === "Enter") {
            e.preventDefault();
            var items = [];
            if (searchSimilarBranch) {
                api.get(`/searchBranches/${searchSimilarBranch.toUpperCase()}`)
                    .then((response) => {
                        let resData = response.data;
                        onSelect(resData[0].branchId);
                        resData.map((branch) => {
                            //add pfp and shit with hovering shit

                            items.push(
                                <option value={branch.branchId}>
                                    {branch.branchId}: {branch.branchName}
                                </option>,
                            );

                            setsearchBranches(items);
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
                    id="branchTextBox"
                    placeholder="Enter Branch name"
                    style={{ flex: 1, padding: "10px", fontSize: "16px" }}
                    onKeyDown={handleGetBranch}
                    onChange={(e) => {
                        setsearchSimilarBranch(e.target.value);
                    }}
                    required
                />

                <select
                    defaultValue={searchedBranches[0]}
                    onChange={(e) => {
                        onSelect(e.target.value);
                    }}
                >
                    {searchedBranches}
                </select>
            </div>
        </>
    );
};

export default SearchBranchesBox;
