package com.synergiz.itctc.service;

import java.util.List;

import com.synergiz.itctc.dto.request.C2FormationWidthTunnelRequest;
import com.synergiz.itctc.dto.response.C2FormationWidthTunnelResponse;

public interface C2FormationWidthTunnelService {

    C2FormationWidthTunnelResponse saveC2FormationWidthTunnel(
            C2FormationWidthTunnelRequest request);
 
    C2FormationWidthTunnelResponse getC2FormationWidthTunnel(
            Long c2FormationWidthTunnelId);

    List<C2FormationWidthTunnelResponse> getAllC2FormationWidthTunnels();

    C2FormationWidthTunnelResponse updateC2FormationWidthTunnel(
            Long c2FormationWidthTunnelId,
            C2FormationWidthTunnelRequest request);

    void deleteC2FormationWidthTunnel(
            Long c2FormationWidthTunnelId,
            String updatedBy);
}