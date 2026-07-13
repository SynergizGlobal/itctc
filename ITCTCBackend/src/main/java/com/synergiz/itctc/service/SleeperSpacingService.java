package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.SleeperSpacingRequest;
import com.synergiz.itctc.dto.response.SleeperSpacingResponse;

import java.util.List;

public interface SleeperSpacingService {


    Long saveSleeperSpacing(SleeperSpacingRequest request);

 
    SleeperSpacingResponse getSleeperSpacing(Long sleeperSpacingHeaderId);

  
    List<SleeperSpacingResponse> getAllSleeperSpacings();


    Long updateSleeperSpacing(
            Long sleeperSpacingHeaderId,
            SleeperSpacingRequest request);


    void deleteSleeperSpacing(
            Long sleeperSpacingHeaderId,
            String updatedBy);
}