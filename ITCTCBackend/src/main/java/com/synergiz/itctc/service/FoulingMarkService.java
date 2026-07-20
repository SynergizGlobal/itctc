package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.FoulingMarkRequest;
import com.synergiz.itctc.dto.response.FoulingMarkResponse;

import java.util.List;

public interface FoulingMarkService {


    Long saveFoulingMark(
            FoulingMarkRequest request);


    FoulingMarkResponse getFoulingMark(
            Long foulingMarkHeaderId);


    List<FoulingMarkResponse> getAllFoulingMarks();


    Long updateFoulingMark(
            Long foulingMarkHeaderId,
            FoulingMarkRequest request);


    void deleteFoulingMark(
            Long foulingMarkHeaderId,
            String updatedBy);
}