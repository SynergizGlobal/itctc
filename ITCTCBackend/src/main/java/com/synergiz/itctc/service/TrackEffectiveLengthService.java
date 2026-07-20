package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.TrackEffectiveLengthRequest;
import com.synergiz.itctc.dto.response.TrackEffectiveLengthResponse;

import java.util.List;

public interface TrackEffectiveLengthService {


    Long saveTrackEffectiveLength(
            TrackEffectiveLengthRequest request);


    TrackEffectiveLengthResponse getTrackEffectiveLength(
            Long trackEffectiveLengthHeaderId);


    List<TrackEffectiveLengthResponse> getAllTrackEffectiveLengths();


    Long updateTrackEffectiveLength(
            Long trackEffectiveLengthHeaderId,
            TrackEffectiveLengthRequest request);

    void deleteTrackEffectiveLength(
            Long trackEffectiveLengthHeaderId,
            String updatedBy);
}