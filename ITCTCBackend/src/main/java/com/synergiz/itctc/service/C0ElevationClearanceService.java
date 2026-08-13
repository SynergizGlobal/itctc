package com.synergiz.itctc.service;

import java.util.List;

import com.synergiz.itctc.dto.request.C0ElevationClearanceRequest;
import com.synergiz.itctc.dto.response.C0ElevationClearanceResponse;

public interface C0ElevationClearanceService {

	C0ElevationClearanceResponse saveC0ElevationClearance(C0ElevationClearanceRequest request);

	C0ElevationClearanceResponse getC0ElevationClearance(Long c0ElevationClearanceId);

	List<C0ElevationClearanceResponse> getAllC0ElevationClearances();

	C0ElevationClearanceResponse updateC0ElevationClearance(Long c0ElevationClearanceId,
			C0ElevationClearanceRequest request);

	void deleteC0ElevationClearance(Long c0ElevationClearanceId, String updatedBy);
}
