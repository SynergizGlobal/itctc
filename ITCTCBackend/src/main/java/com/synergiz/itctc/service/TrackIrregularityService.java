package com.synergiz.itctc.service;



import java.util.List;

import com.synergiz.itctc.dto.request.TrackIrregularityRequest;
import com.synergiz.itctc.dto.response.TrackIrregularityResponse;

public interface TrackIrregularityService {

    Long saveTrackIrregularity(TrackIrregularityRequest request);

    TrackIrregularityResponse getTrackIrregularity(Long trackIrregularityId);

    List<TrackIrregularityResponse> getAllTrackIrregularities();

    Long updateTrackIrregularity(Long trackIrregularityId,
                                 TrackIrregularityRequest request);

    
    void deleteTrackIrregularity(Long trackIrregularityId, String updatedBy);

}