package com.example.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "lessons")
public class LessonEntity extends BaseEntity{
    @ManyToOne
    private ModulEntity owner;
    @Column(nullable = false)
    private String title;
    private String topic;

}
