package com.example.course.service.user;

import com.example.course.controller.dto.SignInDto;
import com.example.course.controller.dto.SortDto;
import com.example.course.controller.dto.UserDto;
import com.example.course.entity.UserEntity;
import com.example.course.repository.UserRepository;
import com.example.course.service.user.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto add(UserDto userDto){
        if(checkUsername(userDto.getUsername())){
            return null;
        }
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userRepository.save(userEntity);
        return userDto;
    }

    private boolean checkUsername(String username) {
        return userRepository.findByUsername(username) != null;
    }


    public List<UserDto> getAllUsers(Pageable pageable, SortDto sortDto) {
        if(sortDto.isSort()){
            if(sortDto.getGetSortDesc().equals("desc")){
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.DESC, sortDto.getGetSortBy());
            }else {
                pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, sortDto.getGetSortBy());
            }
        }
        List<UserEntity> userEntities = userRepository.findAll(pageable).getContent();

        return userEntities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public UserDto signIn(SignInDto signInDto) {
        UserEntity byUser = userRepository.findByUsernameAndPassword(signInDto.getUsername(), signInDto.getPassword());
        return modelMapper.map(byUser,UserDto.class);
    }

    @Override
    public UserEntity getRealUser(SignInDto signInDto) {
        return userRepository.findByUsernameAndPassword(signInDto.getUsername(), signInDto.getPassword());
    }

    private UserDto convertToDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }
}
