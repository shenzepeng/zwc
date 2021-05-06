package com.example.zwc.controller;

import com.example.zwc.common.SzpJsonResult;
import com.example.zwc.mapper.UserMapper;
import com.example.zwc.pojo.User;
import com.example.zwc.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 要写注释呀
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("login")
    public SzpJsonResult<User> login(@RequestBody LoginRequest request){
        Example example=new Example(User.class);
        example.createCriteria()
                .andEqualTo("username",request.getUsername())
                .andEqualTo("password",request.getPassword());
        List<User> users =  userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users)){
            return SzpJsonResult.errorMsg("账号密码错误");
        }
        return SzpJsonResult.ok(users.get(0));
    }
}
