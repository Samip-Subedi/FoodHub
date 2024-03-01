package com.online.test_trail.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String password;

    private String confirmPassword;

}
