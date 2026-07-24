package com.synergiz.itctc.controller;

import com.synergiz.itctc.dto.request.RoleRequest;
import com.synergiz.itctc.dto.response.RoleResponse;
import com.synergiz.itctc.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
//@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping
    public ResponseEntity<Long> saveRole(
            @RequestBody RoleRequest request) {

        Long roleId = roleService.saveRole(request);

        return new ResponseEntity<>(roleId, HttpStatus.CREATED);
    }


    @GetMapping("/{roleId}")
    public ResponseEntity<RoleResponse> getRole(
            @PathVariable Long roleId) {

        RoleResponse response = roleService.getRole(roleId);

        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRoles() {

        List<RoleResponse> response = roleService.getAllRoles();

        return ResponseEntity.ok(response);
    }

   
    @PutMapping("/{roleId}")
    public ResponseEntity<Long> updateRole(
            @PathVariable Long roleId,
            @RequestBody RoleRequest request) {

        Long updatedRoleId = roleService.updateRole(roleId, request);

        return ResponseEntity.ok(updatedRoleId);
    }

  
    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRole(
            @PathVariable Long roleId,
            @RequestParam String updatedBy) {

        roleService.deleteRole(roleId, updatedBy);

        return ResponseEntity.ok("Role deleted successfully.");
    }

}