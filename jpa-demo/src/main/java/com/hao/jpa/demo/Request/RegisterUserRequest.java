package com.hao.jpa.demo.Request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterUserRequest {
    @NotNull
    String name;
    @NotNull
    String password;
}
