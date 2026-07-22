package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.LoginRequest;
import com.synergiz.itctc.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

}