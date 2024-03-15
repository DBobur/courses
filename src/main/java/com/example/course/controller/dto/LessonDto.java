package com.example.course.controller.dto;

import com.example.course.entity.ModulEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LessonDto {
    private ModulDto modulEntity;
    private String title;
    private String topic;
}
