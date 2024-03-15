package com.example.course.controller.dto;

import com.example.course.entity.CourseEntity;
import com.example.course.entity.LessonEntity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModulDto {
    private CourseDto course;
    private String title;
    private List<LessonDto> lessonEntities;
}
