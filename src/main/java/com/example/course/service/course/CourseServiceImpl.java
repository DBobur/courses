package com.example.course.service.course;

import com.example.course.controller.dto.CourseDto;
import com.example.course.controller.dto.SortDto;
import com.example.course.controller.dto.UserDto;
import com.example.course.entity.CourseEntity;
import com.example.course.entity.UserEntity;
import com.example.course.repository.CourseRepository;
import com.example.course.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    @Override
    public CourseDto add(CourseDto courseDto) {
        // todo Course add 1
        if(checkCourse(courseDto)){
            return null;
        }
        // todo Course add 2
        UserEntity userEntity = userRepository.findByUsername(courseDto.getUserEntity().getUsername());
        if(userEntity == null){
            return null;
        }
        // todo Course add 3
        CourseEntity courseEntity = CourseEntity.builder()
                .title(courseDto.getTitle())
                .body(courseDto.getBody())
                .owner(userEntity)
                .build();
        courseRepository.save(courseEntity);
        // todo Course add 4
        List<CourseEntity> courseEntities = userEntity.getCourses();
        if(courseEntities == null){
            userEntity.setCourses(List.of(courseEntity));
        }else {
            userEntity.getCourses().add(courseEntity);
        }
        userRepository.save(userEntity);
        return courseDto;
    }

    private boolean checkCourse(CourseDto courseDto) {
        UserEntity byUsername = userRepository.findByUsername(courseDto.getUserEntity().getUsername());
        CourseEntity course = courseRepository.findByTitleAndOwnerId(courseDto.getTitle(),byUsername.getId()).orElseThrow(null);
        return course != null;
    }

    @Override
    public List<CourseDto> getCourse(Pageable pageable, SortDto sortDto) {
        return null;
    }

    @Override
    public List<CourseDto> getUserCourse(Pageable pageable, SortDto sortDto) {
        return null;
    }

    @Override
    public List<CourseDto> getSearchCourse(Pageable pageable, SortDto sortDto, String search) {
        return null;
    }
}
