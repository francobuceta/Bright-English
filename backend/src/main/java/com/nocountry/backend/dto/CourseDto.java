package com.nocountry.backend.dto;

import com.nocountry.backend.model.Teacher;
import com.nocountry.backend.utils.enums.Level;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Long id;

    private String category;

    private Level level;

    private String mode;

    private String courseDays;

    private String schedule;

    private Teacher teacher;
}
