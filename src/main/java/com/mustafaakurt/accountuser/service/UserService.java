package com.mustafaakurt.accountuser.service;

import com.mustafaakurt.accountuser.converter.UserConverter;
import com.mustafaakurt.accountuser.dto.request.UserRequestDto;
import com.mustafaakurt.accountuser.dto.response.UserResponseDto;
import com.mustafaakurt.accountuser.model.User;
import com.mustafaakurt.accountuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserResponseDto addUser(UserRequestDto requestDto) {
        User entity = userConverter.toEntity(requestDto);
        return userConverter.toResponse(userRepository.save(entity));
    }

    public UserResponseDto getById(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        User user = optUser.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userConverter.toResponse(user);

    }

    public List<UserResponseDto> getAll() {
        //List<User> userList = userRepository.findAll();
        //List<UserResponseDto> responseList;
        //for (int i = 0; i < userList.size(); i++) {
        //    UserResponseDto userResponse = userConverter.toResponse(userList.get(i));
        //    responseList.add(userResponse);
        //}
        //return responseList;
        return userRepository.findAll().stream().map(userConverter::toResponse).collect(Collectors.toList());
    }


    public void deleteUser(Long id) {
        final var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.deleteById(id);
    }

    public void deleteByName(String name, String surname) {
        if (Objects.isNull(name) && Objects.isNull(surname)) {
            throw new RuntimeException("Name and surname cannot be null");
        } else{
            User user = userRepository.findByNameAndSurname(name,surname);
            userRepository.delete(user);

        }


    }

    public UserResponseDto updateUser(Long id, UserRequestDto requestDto) {
        User theRealUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (Objects.nonNull(requestDto.getName())){
            theRealUser.setName(requestDto.getName());
        }
        if (Objects.nonNull(requestDto.getSurname())){
            theRealUser.setSurname(requestDto.getSurname());
        }
        if (Objects.nonNull(requestDto.getEmail())){
            theRealUser.setEmail(requestDto.getEmail());
        }
        if (Objects.nonNull(requestDto.getPhoneNumber())){
            theRealUser.setPhoneNumber(requestDto.getPhoneNumber());
        }
        if (Objects.nonNull(requestDto.getPassword())){
            theRealUser.setPassword(requestDto.getPassword());
        }

        return userConverter.toResponse(userRepository.save(theRealUser));
    }
}
