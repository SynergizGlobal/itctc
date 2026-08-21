package com.synergiz.itctc.constants;

public final class WorkflowConstants {

	private WorkflowConstants() {
		// Prevent Instantiation
	}

	/*
	 * =========================== Inspection Status Codes
	 * ===========================
	 */

	public static final String STATUS_SUBMITTED_TO_PMC = "SUBMITTED_TO_PMC";

	public static final String STATUS_RETURNED_BY_PMC = "RETURNED_BY_PMC";

	public static final String STATUS_PMC_APPROVED = "PMC_APPROVED";

	public static final String STATUS_RETURNED_BY_ITC_TO_PMC = "RETURNED_BY_ITC_TO_PMC";

	public static final String STATUS_RETURNED_BY_ITC_TO_INSPECTOR = "RETURNED_BY_ITC_TO_INSPECTOR";

	public static final String STATUS_FINAL_APPROVED = "FINAL_APPROVED";

	/*
	 * =========================== Workflow Actions ===========================
	 */

	public static final String ACTION_SUBMIT = "SUBMIT";

	public static final String ACTION_APPROVE = "APPROVE";

	public static final String ACTION_RETURN = "RETURN";

	/*
	 * =========================== User Roles ===========================
	 */

	public static final String ROLE_INSPECTOR = "INSPECTOR";

	public static final String ROLE_PMC = "PMC";

	public static final String ROLE_ITC = "ITC_PRECONFIRMATION_ENGINEER";

	// ==========================
	// Inspection Form IDs
	// ==========================
	public static final Integer MEASUREMENT_FORM_ID = 1; // C-1
	public static final Integer NOISE_BARRIER_FORM_ID = 2; // C-7
	public static final Integer TRACK_IRREGULARITY_FORM_ID = 3; // T-2
	public static final Integer CAM_MEASUREMENT_FORM_ID = 4; // T-7-2
	public static final Integer SLEEPER_SPACING_FORM_ID = 5; // T-8
	public static final Integer SYNTHETIC_RESIN_INJECTION_FORM_ID = 6; // T-9
	public static final Integer FASTENING_BOLT_FORM_ID = 7; // T-10
	public static final Integer FOULING_MARK_FORM_ID = 8; // T-13
	public static final Integer TRACK_EFFECTIVE_LENGTH_FORM_ID = 9; // T-21
	public static final Integer BUFFER_STOP_FORM_ID = 10; // T-22
	public static final Integer C0_ELEVATION_CLEARANCE_FORM_ID = 11; // C-0
	public static final Integer C2_FORMATION_WIDTH_TUNNEL_FORM_ID = 12; // C-2
	public static final Integer C4_STRUCTURE_GAUGE_FORM_ID = 13; // C-4
	
	
    // =========================================================
    // FORM CODES
    // =========================================================

    public static final String MEASUREMENT_FORM_CODE = "C001";

}