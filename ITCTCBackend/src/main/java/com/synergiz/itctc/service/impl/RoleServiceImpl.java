package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.RoleRequest;
import com.synergiz.itctc.dto.response.RoleResponse;
import com.synergiz.itctc.entity.Role;
import com.synergiz.itctc.exception.BadRequestException;
import com.synergiz.itctc.exception.DuplicateResourceException;
import com.synergiz.itctc.exception.ResourceNotFoundException;
import com.synergiz.itctc.repository.RoleRepository;
import com.synergiz.itctc.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	@Transactional
	public Long saveRole(RoleRequest request) {

		if (request.getRoleName() == null || request.getRoleName().trim().isEmpty()) {
			throw new BadRequestException("Role Name is required.");
		}

		String roleName = request.getRoleName().trim().toUpperCase();

		roleRepository.findByRoleName(roleName).filter(role -> Boolean.TRUE.equals(role.getIsActive()))
				.ifPresent(role -> {
					throw new DuplicateResourceException("Role already exists : " + roleName);
				});

		Role role = new Role();

		role.setRoleName(roleName);
		role.setDescription(request.getDescription());

		role.setIsActive(true);
		role.setCreatedBy(request.getCreatedBy());
		role.setCreatedDate(LocalDateTime.now());

		roleRepository.save(role);

		return role.getRoleId();
	}

	@Override
	public RoleResponse getRole(Long roleId) {

		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found with Id : " + roleId));

		RoleResponse response = new RoleResponse();

		response.setRoleId(role.getRoleId());
		response.setRoleName(role.getRoleName());
		response.setDescription(role.getDescription());

		response.setIsActive(role.getIsActive());

		response.setCreatedBy(role.getCreatedBy());
		response.setCreatedDate(role.getCreatedDate());

		response.setUpdatedBy(role.getUpdatedBy());
		response.setUpdatedDate(role.getUpdatedDate());

		return response;
	}

	@Override
	public List<RoleResponse> getAllRoles() {

		List<Role> roles = roleRepository.findAll();

		List<RoleResponse> responseList = new ArrayList<>();

		for (Role role : roles) {

			if (!Boolean.TRUE.equals(role.getIsActive())) {
				continue;
			}

			RoleResponse response = new RoleResponse();

			response.setRoleId(role.getRoleId());
			response.setRoleName(role.getRoleName());
			response.setDescription(role.getDescription());

			response.setIsActive(role.getIsActive());

			response.setCreatedBy(role.getCreatedBy());
			response.setCreatedDate(role.getCreatedDate());

			response.setUpdatedBy(role.getUpdatedBy());
			response.setUpdatedDate(role.getUpdatedDate());

			responseList.add(response);
		}

		return responseList;
	}

	@Override
	@Transactional
	public Long updateRole(Long roleId, RoleRequest request) {

		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found with Id : " + roleId));

		if (request.getRoleName() == null || request.getRoleName().trim().isEmpty()) {
			throw new BadRequestException("Role Name is required.");
		}

		String roleName = request.getRoleName().trim().toUpperCase();

		roleRepository.findByRoleName(roleName).ifPresent(existingRole -> {

			if (!existingRole.getRoleId().equals(roleId) && Boolean.TRUE.equals(existingRole.getIsActive())) {

				throw new DuplicateResourceException("Role already exists : " + roleName);
			}
		});

		// Update Role

		role.setRoleName(roleName);
		role.setDescription(request.getDescription());

		role.setUpdatedBy(request.getUpdatedBy());
		role.setUpdatedDate(LocalDateTime.now());

		roleRepository.save(role);

		return role.getRoleId();
	}

	@Override
	@Transactional
	public void deleteRole(Long roleId, String updatedBy) {

		Role role = roleRepository.findById(roleId)
				.orElseThrow(() -> new ResourceNotFoundException("Role not found with Id : " + roleId));

		role.setIsActive(false);
		role.setUpdatedBy(updatedBy);
		role.setUpdatedDate(LocalDateTime.now());

		roleRepository.save(role);
	}

}