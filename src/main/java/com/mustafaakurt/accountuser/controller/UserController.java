package com.mustafaakurt.accountuser.controller;

import com.mustafaakurt.accountuser.dto.request.UserRequestDto;
import com.mustafaakurt.accountuser.dto.response.UserResponseDto;
import com.mustafaakurt.accountuser.service.UserService;
import com.mustafaakurt.accountuser.shared.endpoints.UserEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserEndpoints.USER_PATH)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDto addUser(@RequestBody UserRequestDto requestDto){
        return userService.addUser(requestDto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponseDto> getAll(){
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/name")
    public void deleteByName(@RequestParam String name, @RequestParam String surname){
        userService.deleteByName(name,surname);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto){
        return userService.updateUser(id,requestDto);
    }

}
