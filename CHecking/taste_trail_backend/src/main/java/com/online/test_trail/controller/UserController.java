package com.online.test_trail.controller;


import com.online.test_trail.dto.ChangePasswordDto;
import com.online.test_trail.dto.ForgetPasswordDto;
import com.online.test_trail.dto.UpdatePasswordDto;
import com.online.test_trail.dto.UserDto;
import com.online.test_trail.entity.UserEntity;
import com.online.test_trail.service.AuthenticateService;
import com.online.test_trail.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticateService authenticateService; // Inject your AuthenticateService

    @GetMapping
    public List<UserEntity> findAll() {
        return this.userService.findAll();
    }


    @PostMapping("/save")
    public String save(@Valid @RequestBody UserDto userDto) {
        userService.save(userDto);
        return "Data saved Successfully";
    }



    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<UserEntity> findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "Data deleted successfully";
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        try {
            userService.updateUser(id, userDto);
            return ResponseEntity.ok("User updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update user: " + e.getMessage());
        }
    }


    @PostMapping("/forget-password")
    public ResponseEntity<String> initiateForgetPassword(@RequestBody ForgetPasswordDto forgetPasswordDto) {
        authenticateService.initiateForgetPassword(forgetPasswordDto.getEmail());
        return ResponseEntity.ok("Forget password initiated. Check your email for OTP.");
    }
    @PostMapping("/submit-otp")
    public ResponseEntity<String> submitOtp(@RequestBody ForgetPasswordDto forgetPasswordDto) {
        boolean isValidOtp = authenticateService.validateForgetPasswordOtp(forgetPasswordDto.getEmail(), forgetPasswordDto.getOtp());
        if (isValidOtp) {
            return ResponseEntity.ok("OTP is valid. Proceed to set a new password.");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP. Please try again.");
        }
    }

    @PostMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordDto updatePasswordDTO) {
        authenticateService.updatePassword(updatePasswordDTO.getEmail(), updatePasswordDTO.getNewPassword());
        return ResponseEntity.ok("Password updated successfully.");
    }

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDto requestDTO) {
        try {
            authenticateService.changePassword(requestDTO.getEmail(), requestDTO.getOldPassword(), requestDTO.getNewPassword());
            return ResponseEntity.ok("Password changed successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to change password. " + e.getMessage());
        }
    }
}
