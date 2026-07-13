package com.synergiz.itctc.service;


import com.synergiz.itctc.dto.request.CamMeasurementRequest;
import com.synergiz.itctc.dto.response.CamMeasurementResponse;

import java.util.List;

public interface CamMeasurementService {

   
    Long saveCamMeasurement(CamMeasurementRequest request);

  
    CamMeasurementResponse getCamMeasurement(Long camMeasurementHeaderId);


    List<CamMeasurementResponse> getAllCamMeasurements();


    Long updateCamMeasurement(
            Long camMeasurementHeaderId,
            CamMeasurementRequest request);


    void deleteCamMeasurement(
            Long camMeasurementHeaderId,
            String updatedBy);

}