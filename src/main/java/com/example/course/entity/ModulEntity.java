package com.example.course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "moduls")
public class ModulEntity extends BaseEntity{
    @JsonIgnore
    @ManyToOne
    private  CourseEntity owner;
    private String title;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private ArrayList<LessonEntity> lessons;
}
