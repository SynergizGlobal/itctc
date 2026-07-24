package com.synergiz.itctc.service.impl;

import com.synergiz.itctc.dto.request.LoginRequest;
import com.synergiz.itctc.dto.response.LoginResponse;
import com.synergiz.itctc.entity.User;
import com.synergiz.itctc.exception.BadRequestException;
import com.synergiz.itctc.exception.ResourceNotFoundException;
import com.synergiz.itctc.exception.UnauthorizedException;
import com.synergiz.itctc.repository.UserRepository;
import com.synergiz.itctc.security.CustomUserDetailsService;
import com.synergiz.itctc.security.JwtUtil;
import com.synergiz.itctc.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil,
                           UserRepository userRepository,
                           CustomUserDetailsService customUserDetailsService) {

        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        // ===========================================
        // Validate Username
        // ===========================================

        if (request.getUsername() == null ||
                request.getUsername().trim().isEmpty()) {

            throw new BadRequestException("Username is required.");
        }

        // ===========================================
        // Validate Password
        // ===========================================

        if (request.getPassword() == null ||
                request.getPassword().trim().isEmpty()) {

            throw new BadRequestException("Password is required.");
        }

        String username = request.getUsername().trim().toLowerCase();

        // ===========================================
        // Authenticate Username & Password
        // ===========================================

        try {

            authenticationManager.authenticate(

                    new UsernamePasswordAuthenticationToken(
                            username,
                            request.getPassword()
                    )
            );

        } catch (BadCredentialsException ex) {

            throw new UnauthorizedException("Invalid Username or Password.");

        } catch (LockedException ex) {

            throw new UnauthorizedException("Your account is locked.");

        } catch (DisabledException ex) {

            throw new UnauthorizedException("Your account is disabled.");
        }

        // ===========================================
        // Load User
        // ===========================================

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found."));

        // ===========================================
        // Load UserDetails
        // ===========================================

        UserDetails userDetails =
                customUserDetailsService.loadUserByUsername(username);

        // ===========================================
        // Generate JWT Token
        // ===========================================

        String token = jwtUtil.generateToken(userDetails);

        // ===========================================
        // Prepare Response
        // ===========================================

        LoginResponse response = new LoginResponse();

        response.setToken(token);
        response.setTokenType("Bearer");

        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());

        response.setRole(user.getRole().getRoleName());

        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());

        return response;
    }
}