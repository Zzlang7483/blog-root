package com.zdz.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.zdz.service.LoginService;
import com.zdz.vo.Result;
import com.zdz.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParam loginParam){

        return loginService.register(loginParam);

    }
}
