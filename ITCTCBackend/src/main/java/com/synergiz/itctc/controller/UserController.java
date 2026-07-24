package com.synergiz.itctc.controller;

import com.synergiz.itctc.dto.request.UserRequest;
import com.synergiz.itctc.dto.response.UserResponse;
import com.synergiz.itctc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<Long> saveUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.saveUser(request));
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }


    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PutMapping("/{userId}")
    public ResponseEntity<Long> updateUser(@PathVariable Long userId,
                                           @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.updateUser(userId, request));
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId,
                                             @RequestParam String updatedBy) {

        userService.deleteUser(userId, updatedBy);

        return ResponseEntity.ok("User deleted successfully.");
    }

}