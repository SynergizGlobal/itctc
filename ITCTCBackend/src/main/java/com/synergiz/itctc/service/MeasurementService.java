package com.synergiz.itctc.service;



import com.synergiz.itctc.dto.request.MeasurementRequest;
import com.synergiz.itctc.dto.request.MeasurementUpdateRequest;
import com.synergiz.itctc.dto.response.MeasurementResponse;

import java.util.List;

public interface MeasurementService {

    Long saveMeasurement(MeasurementRequest request);

    MeasurementResponse getMeasurement(Long measurementId);

    List<MeasurementResponse> getAllMeasurements();

    Long updateMeasurement(Long measurementId,
    		MeasurementUpdateRequest request);
    
    Long deleteMeasurement(Long measurementId);

}