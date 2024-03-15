package com.example.course.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignInDto {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
