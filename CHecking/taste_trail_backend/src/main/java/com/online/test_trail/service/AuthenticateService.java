package com.online.test_trail.service;

import com.online.test_trail.dto.request.AuthenticateRequest;
import com.online.test_trail.dto.response.AuthenticateResponse;

public interface AuthenticateService {

    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);

    void initiateForgetPassword(String email);

    boolean validateForgetPasswordOtp(String email, String otp);
    void updatePassword(String email, String newPassword);

    void changePassword(String email, String oldPassword, String newPassword);
}
