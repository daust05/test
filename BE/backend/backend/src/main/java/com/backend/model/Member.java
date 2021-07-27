package com.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String userId;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String school;
}
