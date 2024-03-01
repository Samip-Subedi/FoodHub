package com.online.test_trail.service.impl;

import com.online.test_trail.config.PasswordEncoderUtil;
import com.online.test_trail.dto.request.AuthenticateRequest;
import com.online.test_trail.dto.response.AuthenticateResponse;
import com.online.test_trail.entity.UserEntity;
import com.online.test_trail.repo.UserRepo;
import com.online.test_trail.security.JwtService;
import com.online.test_trail.service.AuthenticateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getUsername(), authenticateRequest.getPassword()
                )
        );

        UserEntity user = userRepo.getUserByUsername(authenticateRequest.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        UserDetails userDetails = user;
        String jwtToken = jwtService.generateToken(userDetails);


        return AuthenticateResponse.builder().token(jwtToken).userId(user.getId()).role(user.getId()==3?"admin":"").build();
    }

    @Override
    public void initiateForgetPassword(String email) {
        // Generate OTP (You may use a library or generate a simple random string)
        String generatedOtp = generateRandomOtp();

        // Send OTP to the user's email (you may use a third-party library for email sending)

        // Store the OTP in a secure way (e.g., database)
        saveOtpToDatabase(email, generatedOtp);
    }

    @Override
    public boolean validateForgetPasswordOtp(String email, String otp) {
        // Retrieve the stored OTP for the user from the database
        String storedOtp = getStoredOtpFromDatabase(email);

        // Validate the received OTP against the stored OTP
        return otp.equals(storedOtp);
    }

    // Helper method to generate a random OTP
    private String generateRandomOtp() {
        // Implement your logic to generate a random OTP (e.g., using SecureRandom)
        // This is a simplified example; you might want to use a library for OTP generation
        return String.valueOf((int) (Math.random() * 900000) + 100000);
    }

    // Helper method to save OTP to the database
    private void saveOtpToDatabase(String email, String otp) {
        // Implement your logic to store the OTP in the database
        // Example using UserRepository:
        Optional<UserEntity> optionalUser = userRepo.getUserByUsername(email);
        optionalUser.ifPresent(users -> {
            users.setForgetPasswordOtp(otp);
            userRepo.save(users);
        });
    }

    // Helper method to retrieve stored OTP from the database
    private String getStoredOtpFromDatabase(String email) {
        // Implement your logic to retrieve the stored OTP from the database
        // Example using UserRepository:
        Optional<UserEntity> optionalUser = userRepo.getUserByUsername(email);
        return optionalUser.map(UserEntity::getForgetPasswordOtp).orElse(null);
    }

    @Override
    public void updatePassword(String email, String newPassword) {
        // Implement your logic to update the user's password
        // Example using UserRepository:
        Optional<UserEntity> optionalUser = userRepo.getUserByUsername(email);
        optionalUser.ifPresent(user -> {
            user.setPassword(PasswordEncoderUtil.getInstance().encode(newPassword));
            user.setForgetPasswordOtp(null); // Reset forget password OTP after successful update
            userRepo.save(user);
        });
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        Optional<UserEntity> optionalUser = userRepo.getUserByUsername(email);
        optionalUser.ifPresent(user -> {
            // Validate old password
            if (PasswordEncoderUtil.getInstance().matches(oldPassword, user.getPassword())) {
                // Update password if old password is valid
                user.setPassword(PasswordEncoderUtil.getInstance().encode(newPassword));
                userRepo.save(user);
            } else {
                throw new RuntimeException("Invalid old password.");
            }
        });
    }
}