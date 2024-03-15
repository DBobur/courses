package com.example.course.service.course;

import com.example.course.controller.dto.CourseDto;
import com.example.course.controller.dto.SortDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    CourseDto add(CourseDto courseDto);
    List<CourseDto> getCourse(Pageable pageable, SortDto sortDto);
    List<CourseDto> getUserCourse(Pageable pageable,SortDto sortDto);
    List<CourseDto> getSearchCourse(Pageable pageable,SortDto sortDto,String search);
}
