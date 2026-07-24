package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.UserRequest;
import com.synergiz.itctc.dto.response.UserResponse;
import com.synergiz.itctc.entity.Role;
import com.synergiz.itctc.entity.User;
import com.synergiz.itctc.exception.BadRequestException;
import com.synergiz.itctc.exception.DuplicateResourceException;
import com.synergiz.itctc.exception.ResourceNotFoundException;
import com.synergiz.itctc.repository.RoleRepository;
import com.synergiz.itctc.repository.UserRepository;
import com.synergiz.itctc.service.UserService;
import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public Long saveUser(UserRequest request) {

		// 1. Validate Role

		Role role = roleRepository.findById(request.getRoleId())
				.orElseThrow(() -> new ResourceNotFoundException("Role not found with Id : " + request.getRoleId()));

		// 2. Validate Username

		if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
			throw new BadRequestException("Username is required.");
		}

		String username = request.getUsername().trim().toLowerCase();

		if (username.length() < 4) {
			throw new BadRequestException("Username must contain at least 4 characters.");
		}

		// 3. Check Duplicate Username

		userRepository.findByUsername(username).filter(user -> Boolean.TRUE.equals(user.getIsActive()))
				.ifPresent(user -> {
					throw new DuplicateResourceException("Username already exists : " + username);
				});

		// 4. Validate Password

		if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
			throw new BadRequestException("Password is required.");
		}

		if (request.getPassword().length() < 8) {
			throw new BadRequestException("Password must contain at least 8 characters.");
		}

		// 5. Validate First Name

		if (request.getFirstName() == null || request.getFirstName().trim().isEmpty()) {
			throw new BadRequestException("First Name is required.");
		}

		// 6. Validate Email

		if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
			throw new BadRequestException("Email is required.");
		}

		String email = request.getEmail().trim().toLowerCase();

		if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			throw new BadRequestException("Invalid Email Address.");
		}

		// 7. Check Duplicate Email

		userRepository.findByEmail(email).filter(user -> Boolean.TRUE.equals(user.getIsActive())).ifPresent(user -> {
			throw new DuplicateResourceException("Email already exists : " + email);
		});

		// 8. Validate Mobile Number

		String mobileNumber = (request.getMobileNumber() == null) ? null : request.getMobileNumber().trim();

		if (mobileNumber != null && !mobileNumber.isEmpty()) {

			if (!mobileNumber.matches("\\d{10}")) {
				throw new BadRequestException("Mobile Number must contain exactly 10 digits.");
			}
		}

		// 9. Check Duplicate Mobile Number

		if (mobileNumber != null) {

			userRepository.findByMobileNumber(mobileNumber).filter(user -> Boolean.TRUE.equals(user.getIsActive()))
					.ifPresent(user -> {
						throw new DuplicateResourceException("Mobile Number already exists : " + mobileNumber);
					});
		}

		// 10. Save User

		User user = new User();

		user.setRole(role);

		user.setUsername(username);

		user.setPassword(passwordEncoder.encode(request.getPassword()));

		user.setFirstName(request.getFirstName().trim());
		user.setMiddleName(request.getMiddleName());
		user.setLastName(request.getLastName());

		user.setEmail(email);
		user.setMobileNumber(mobileNumber);

		user.setProfileImage(request.getProfileImage());

		// Security Defaults

		user.setIsEmailVerified(false);
		user.setIsMobileVerified(false);
		user.setIsAccountLocked(false);
		user.setFailedLoginAttempts(0);

		user.setLastLoginDate(null);
		user.setLastPasswordChange(null);

		user.setPasswordResetToken(null);
		user.setPasswordResetExpiry(null);

		// Audit

		user.setIsActive(true);

		user.setCreatedBy(request.getCreatedBy());
		user.setCreatedDate(LocalDateTime.now());

		userRepository.save(user);

		return user.getUserId();
	}

	@Override
	public UserResponse getUser(Long userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with Id : " + userId));

		UserResponse response = new UserResponse();

		response.setUserId(user.getUserId());

		response.setRoleId(user.getRole().getRoleId());
		response.setRoleName(user.getRole().getRoleName());

		response.setUsername(user.getUsername());

		response.setFirstName(user.getFirstName());
		response.setMiddleName(user.getMiddleName());
		response.setLastName(user.getLastName());

		response.setEmail(user.getEmail());
		response.setMobileNumber(user.getMobileNumber());

		response.setProfileImage(user.getProfileImage());

		response.setIsEmailVerified(user.getIsEmailVerified());
		response.setIsMobileVerified(user.getIsMobileVerified());

		response.setIsAccountLocked(user.getIsAccountLocked());
		response.setFailedLoginAttempts(user.getFailedLoginAttempts());

		response.setLastLoginDate(user.getLastLoginDate());
		response.setLastPasswordChange(user.getLastPasswordChange());

		response.setIsActive(user.getIsActive());

		response.setCreatedBy(user.getCreatedBy());
		response.setCreatedDate(user.getCreatedDate());

		response.setUpdatedBy(user.getUpdatedBy());
		response.setUpdatedDate(user.getUpdatedDate());

		return response;
	}

	@Override
	public List<UserResponse> getAllUsers() {

		List<User> users = userRepository.findAll();

		List<UserResponse> responseList = new ArrayList<>();

		for (User user : users) {

			if (!Boolean.TRUE.equals(user.getIsActive())) {
				continue;
			}

			UserResponse response = new UserResponse();

			response.setUserId(user.getUserId());

			response.setRoleId(user.getRole().getRoleId());
			response.setRoleName(user.getRole().getRoleName());

			response.setUsername(user.getUsername());

			response.setFirstName(user.getFirstName());
			response.setMiddleName(user.getMiddleName());
			response.setLastName(user.getLastName());

			response.setEmail(user.getEmail());
			response.setMobileNumber(user.getMobileNumber());

			response.setProfileImage(user.getProfileImage());

			response.setIsEmailVerified(user.getIsEmailVerified());
			response.setIsMobileVerified(user.getIsMobileVerified());

			response.setIsAccountLocked(user.getIsAccountLocked());
			response.setFailedLoginAttempts(user.getFailedLoginAttempts());

			response.setLastLoginDate(user.getLastLoginDate());
			response.setLastPasswordChange(user.getLastPasswordChange());

			response.setIsActive(user.getIsActive());

			response.setCreatedBy(user.getCreatedBy());
			response.setCreatedDate(user.getCreatedDate());

			response.setUpdatedBy(user.getUpdatedBy());
			response.setUpdatedDate(user.getUpdatedDate());

			responseList.add(response);
		}

		return responseList;
	}

	@Override
	@Transactional
	public Long updateUser(Long userId, UserRequest request) {

		// ===========================
		// Find Existing User
		// ===========================

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with Id : " + userId));

		// ===========================
		// 1. Validate Role
		// ===========================

		Role role = roleRepository.findById(request.getRoleId())
				.orElseThrow(() -> new ResourceNotFoundException("Role not found with Id : " + request.getRoleId()));

		// ===========================
		// 2. Validate Username
		// ===========================

		if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
			throw new BadRequestException("Username is required.");
		}

		String username = request.getUsername().trim().toLowerCase();

		if (username.length() < 4) {
			throw new BadRequestException("Username must contain at least 4 characters.");
		}

		// ===========================
		// 3. Check Duplicate Username
		// ===========================

		userRepository.findByUsername(username).filter(existingUser -> !existingUser.getUserId().equals(userId)
				&& Boolean.TRUE.equals(existingUser.getIsActive())).ifPresent(existingUser -> {
					throw new DuplicateResourceException("Username already exists : " + username);
				});

		// ===========================
		// 4. Validate Password
		// ===========================

		if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
			throw new BadRequestException("Password is required.");
		}

		if (request.getPassword().length() < 8) {
			throw new BadRequestException("Password must contain at least 8 characters.");
		}

		// ===========================
		// 5. Validate First Name
		// ===========================

		if (request.getFirstName() == null || request.getFirstName().trim().isEmpty()) {
			throw new BadRequestException("First Name is required.");
		}

		// ===========================
		// 6. Validate Email
		// ===========================

		if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
			throw new BadRequestException("Email is required.");
		}

		String email = request.getEmail().trim().toLowerCase();

		if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
			throw new BadRequestException("Invalid Email Address.");
		}

		// ===========================
		// 7. Check Duplicate Email
		// ===========================

		userRepository.findByEmail(email).filter(existingUser -> !existingUser.getUserId().equals(userId)
				&& Boolean.TRUE.equals(existingUser.getIsActive())).ifPresent(existingUser -> {
					throw new DuplicateResourceException("Email already exists : " + email);
				});

		// ===========================
		// 8. Validate Mobile Number
		// ===========================

		String mobileNumber = null;

		if (request.getMobileNumber() != null && !request.getMobileNumber().trim().isEmpty()) {

			mobileNumber = request.getMobileNumber().trim();

			if (!mobileNumber.matches("\\d{10}")) {
				throw new BadRequestException("Mobile Number must contain exactly 10 digits.");
			}
		}

		// ===========================
		// 9. Check Duplicate Mobile Number
		// ===========================

		if (mobileNumber != null) {

			final String finalMobileNumber = mobileNumber;

			userRepository.findByMobileNumber(finalMobileNumber)
					.filter(existingUser -> !existingUser.getUserId().equals(userId)
							&& Boolean.TRUE.equals(existingUser.getIsActive()))
					.ifPresent(existingUser -> {
						throw new DuplicateResourceException("Mobile Number already exists : " + finalMobileNumber);
					});
		}

		// ===========================
		// 10. Update User
		// ===========================

		user.setRole(role);

		user.setUsername(username);

		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setLastPasswordChange(LocalDateTime.now());
		user.setFirstName(request.getFirstName().trim());
		user.setMiddleName(request.getMiddleName());
		user.setLastName(request.getLastName());

		user.setEmail(email);
		user.setMobileNumber(mobileNumber);

		user.setProfileImage(request.getProfileImage());

		user.setUpdatedBy(request.getUpdatedBy());
		user.setUpdatedDate(LocalDateTime.now());

		userRepository.save(user);

		return user.getUserId();
	}

	@Override
	@Transactional
	public void deleteUser(Long userId, String updatedBy) {

		// ===========================
		// Find User
		// ===========================

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with Id : " + userId));

		// ===========================
		// Check Already Deleted
		// ===========================

		if (!Boolean.TRUE.equals(user.getIsActive())) {
			throw new DuplicateResourceException("User is already deleted.");
		}

		// ===========================
		// Soft Delete
		// ===========================

		user.setIsActive(false);
		user.setUpdatedBy(updatedBy);
		user.setUpdatedDate(LocalDateTime.now());

		userRepository.save(user);
	}

}