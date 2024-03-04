package com.mustafaakurt.accountuser.controller;

import com.mustafaakurt.accountuser.service.UserService;
import com.mustafaakurt.accountuser.shared.endpoints.UserEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserEndpoints.BASE_PATH)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDto addUser(@RequestBody UserRequestDto requestDto){
        return userService.addUser(requestDto);
    }
}
