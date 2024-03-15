package com.example.course.controller.dto;

import com.example.course.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private LocalDate birthday;
    private List<CourseDto> courseEntities;
}
