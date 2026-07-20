package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.BufferStopRequest;
import com.synergiz.itctc.dto.response.BufferStopResponse;

import java.util.List;

public interface BufferStopService {

    Long saveBufferStop(BufferStopRequest request);

  
    BufferStopResponse getBufferStop(Long bufferStopHeaderId);


    List<BufferStopResponse> getAllBufferStops();


    Long updateBufferStop(
            Long bufferStopHeaderId,
            BufferStopRequest request);

   
    void deleteBufferStop(
            Long bufferStopHeaderId,
            String updatedBy);
}