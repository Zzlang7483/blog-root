package com.zdz.service;

import com.zdz.dao.pojo.SysUser;
import com.zdz.vo.Result;

import java.lang.reflect.AccessibleObject;

public interface SysUserService {

    SysUser findUserById(Long userId);

    Result getUserInfoBytoken(String token);
    SysUser findUser(String account , String pwd);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);
}
