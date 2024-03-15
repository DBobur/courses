package com.example.course.controller.dto;

import com.example.course.entity.ModulEntity;
import com.example.course.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseDto {
    private UserDto userEntity;
    private String title;
    private String body;
    private List<ModulDto> modulEntities;
}
