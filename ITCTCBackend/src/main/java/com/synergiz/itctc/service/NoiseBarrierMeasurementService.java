package com.synergiz.itctc.service;

import java.util.List;

import com.synergiz.itctc.dto.request.NoiseBarrierMeasurementRequest;
import com.synergiz.itctc.dto.request.NoiseBarrierMeasurementUpdateRequest;
import com.synergiz.itctc.dto.response.NoiseBarrierMeasurementResponse;

public interface NoiseBarrierMeasurementService {

    Long saveNoiseBarrierMeasurement(NoiseBarrierMeasurementRequest request);

    NoiseBarrierMeasurementResponse getNoiseBarrierMeasurement(Long noiseBarrierMeasurementId);

    List<NoiseBarrierMeasurementResponse> getAllNoiseBarrierMeasurements();

    Long updateNoiseBarrierMeasurement(
            Long noiseBarrierMeasurementId,
            NoiseBarrierMeasurementUpdateRequest request);

    void deleteNoiseBarrierMeasurement(Long noiseBarrierMeasurementId);

}
