package com.zdz.service;

import com.zdz.dao.pojo.SysUser;
import com.zdz.vo.Result;
import com.zdz.vo.params.LoginParam;

public interface LoginService {
    /**
     * 登录
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);
    Result logout(String token);

    Result register(LoginParam loginParam);
}
