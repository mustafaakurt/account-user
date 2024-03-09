package com.mustafaakurt.accountuser.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
}
