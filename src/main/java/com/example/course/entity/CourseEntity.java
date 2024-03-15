package com.example.course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courses")
public class CourseEntity extends BaseEntity{
    @JsonIgnore
    @ManyToOne
    private UserEntity owner;
    @Column(nullable = false)
    private String title;
    private String body;
    @OneToMany(mappedBy = "owner")
    private ArrayList<ModulEntity> moduls;



}
