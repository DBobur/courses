package com.example.course.controller;

import com.example.course.controller.dto.SignInDto;
import com.example.course.controller.dto.SortDto;
import com.example.course.controller.dto.UserDto;
import com.example.course.entity.UserEntity;
import com.example.course.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/sign-up")
    public UserDto signUp(
            @RequestBody UserDto userDto
            ){
        return userService.add(userDto);
    }
    @GetMapping("/sign-in")
    public UserDto signIn(
            @RequestBody SignInDto signInDto
            ){
        return userService.signIn(signInDto);
    }
    @GetMapping("/get-all")
    public List<UserDto> getAllUsers(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(defaultValue = "username") String sortBy,
            @RequestParam(defaultValue = "esc") String sortDesc,
            @RequestParam(defaultValue = "false") boolean sort
    ){
        Pageable pageable = PageRequest.of(page,size);
        return userService.getAllUsers(pageable,new SortDto(sortBy,sortDesc,sort));
    }

    @GetMapping("/get-real-user")
    public UserEntity getRealUser(
            @RequestBody SignInDto signInDto
    ){
        return userService.getRealUser(signInDto);

        //return UserEntity.builder().username("bobur").build();
    }

}
