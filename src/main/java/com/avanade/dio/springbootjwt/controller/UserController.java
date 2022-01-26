package com.avanade.dio.springbootjwt.controller;

import com.avanade.dio.springbootjwt.data.UserData;
import com.avanade.dio.springbootjwt.service.UserDetailsServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    public UserController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping("/all-users")
    public List<UserData> list(){
        return userDetailsService.listUsers();
    }

}
