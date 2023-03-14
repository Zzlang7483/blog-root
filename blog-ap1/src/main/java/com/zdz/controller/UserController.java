package com.zdz.controller;

import com.zdz.service.SysUserService;
import com.zdz.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/currentUser")
    public Result currentUser(@RequestHeader ("Authorization") String token){

        return sysUserService.getUserInfoBytoken(token);

    }

}
