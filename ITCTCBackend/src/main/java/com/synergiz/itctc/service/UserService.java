package com.synergiz.itctc.service;

import com.synergiz.itctc.dto.request.UserRequest;
import com.synergiz.itctc.dto.response.UserResponse;

import java.util.List;

public interface UserService {


    Long saveUser(UserRequest request);


    UserResponse getUser(Long userId);


    List<UserResponse> getAllUsers();


    Long updateUser(Long userId, UserRequest request);


    void deleteUser(Long userId, String updatedBy);

}