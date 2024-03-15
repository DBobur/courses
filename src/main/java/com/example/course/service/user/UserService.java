package com.example.course.service.user;

import com.example.course.controller.dto.SignInDto;
import com.example.course.controller.dto.SortDto;
import com.example.course.controller.dto.UserDto;
import com.example.course.entity.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto add(UserDto userDto);
    List<UserDto> getAllUsers(Pageable pageable, SortDto sortDto);

    UserDto signIn(SignInDto signInDto);

    UserEntity getRealUser(SignInDto signInDto);

}
