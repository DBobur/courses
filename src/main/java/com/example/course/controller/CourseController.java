package com.example.course.controller;

import com.example.course.controller.dto.CourseDto;
import com.example.course.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/add")
    public CourseDto add(
            @RequestBody CourseDto courseDto
    ){
        return courseService.add(courseDto);
    }
}
