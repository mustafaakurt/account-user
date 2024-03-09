package com.mustafaakurt.accountuser.converter;

import com.mustafaakurt.accountuser.dto.request.UserRequestDto;
import com.mustafaakurt.accountuser.dto.response.UserResponseDto;
import com.mustafaakurt.accountuser.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserResponseDto toResponse(User entity){
        UserResponseDto userResponse = new UserResponseDto();
        userResponse.setId(entity.getId());
        // accountID
        userResponse.setName(entity.getName());
        userResponse.setSurname(entity.getSurname());
        userResponse.setEmail(entity.getEmail());
        userResponse.setPhoneNumber(entity.getPhoneNumber());
        userResponse.setCreatedDate(entity.getCreatedDate()); // TODO : Buraya ayrı converter gelebilir
        userResponse.setUpdatedDate(entity.getUpdatedDate());
        return userResponse;

    }

    public User toEntity(UserRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getName());
        user.setSurname(requestDto.getSurname());
        user.setEmail(requestDto.getEmail());
        user.setPhoneNumber(requestDto.getPhoneNumber());
        user.setPassword(requestDto.getPassword());
        return user;
    }
}
