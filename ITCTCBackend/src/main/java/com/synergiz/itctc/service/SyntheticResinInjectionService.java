package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.SyntheticResinInjectionRequest;
import com.synergiz.itctc.dto.response.SyntheticResinInjectionResponse;

import java.util.List;

public interface SyntheticResinInjectionService {

  
    Long saveSyntheticResinInjection(
            SyntheticResinInjectionRequest request);

  
    SyntheticResinInjectionResponse getSyntheticResinInjection(
            Long syntheticResinInjectionHeaderId);

  
    List<SyntheticResinInjectionResponse> getAllSyntheticResinInjections();

   
    Long updateSyntheticResinInjection(
            Long syntheticResinInjectionHeaderId,
            SyntheticResinInjectionRequest request);

   
    void deleteSyntheticResinInjection(
            Long syntheticResinInjectionHeaderId,
            String updatedBy);
}