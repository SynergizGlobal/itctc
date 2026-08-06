import React from "react";

const WorkflowStatusBadge = ({ workflow }) => {

    if (!workflow) {
        return (
            <span className="badge bg-secondary">
                Not Submitted
            </span>
        );
    }

    const { currentStatusCode, currentStatusName } = workflow;

    let badgeClass = "bg-secondary";

    switch (currentStatusCode) {

        case "SUBMITTED_TO_PMC":
            badgeClass = "bg-primary";
            break;

        case "RETURNED_BY_PMC":
            badgeClass = "bg-warning text-dark";
            break;

        case "PMC_APPROVED":
            badgeClass = "bg-info text-dark";
            break;

        case "RETURNED_BY_ITC_TO_PMC":
            badgeClass = "bg-warning text-dark";
            break;

        case "RETURNED_BY_ITC_TO_INSPECTOR":
            badgeClass = "bg-danger";
            break;

        case "FINAL_APPROVED":
            badgeClass = "bg-success";
            break;

        default:
            badgeClass = "bg-secondary";
    }

    return (
        <span className={`badge ${badgeClass}`}>
            {currentStatusName}
        </span>
    );
};

export default WorkflowStatusBadge;