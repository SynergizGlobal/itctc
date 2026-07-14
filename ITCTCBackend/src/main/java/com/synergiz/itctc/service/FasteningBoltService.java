package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.FasteningBoltRequest;
import com.synergiz.itctc.dto.response.FasteningBoltResponse;

import java.util.List;

public interface FasteningBoltService {


    Long saveFasteningBolt(
            FasteningBoltRequest request);

 
    FasteningBoltResponse getFasteningBolt(
            Long fasteningBoltHeaderId);

 
    List<FasteningBoltResponse> getAllFasteningBolts();


    Long updateFasteningBolt(
            Long fasteningBoltHeaderId,
            FasteningBoltRequest request);


    void deleteFasteningBolt(
            Long fasteningBoltHeaderId,
            String updatedBy);
}