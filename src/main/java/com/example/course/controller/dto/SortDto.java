package com.example.course.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortDto {
    private String getSortBy;
    private String getSortDesc;
    private boolean sort;
}
