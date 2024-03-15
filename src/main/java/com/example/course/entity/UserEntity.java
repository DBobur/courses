package com.example.course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
    private String name;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private LocalDate birthday;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<CourseEntity> courses;


}
