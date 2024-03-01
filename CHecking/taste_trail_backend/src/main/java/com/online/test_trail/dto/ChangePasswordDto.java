package com.online.test_trail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDto {
    private String email;
    private String oldPassword;
    private String newPassword;

}


