package com.example.zwc.response;

import lombok.Data;

/**
 * 要写注释呀
 */
@Data
public class LoginResponse {

    private String username;

    private String password;

    private String nickName;

    private Integer grade;

    private Long id;
}
