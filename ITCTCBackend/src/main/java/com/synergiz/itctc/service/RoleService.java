package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.RoleRequest;
import com.synergiz.itctc.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {


    Long saveRole(RoleRequest request);


    RoleResponse getRole(Long roleId);


    List<RoleResponse> getAllRoles();


    Long updateRole(Long roleId, RoleRequest request);


    void deleteRole(Long roleId, String updatedBy);

}