package cn.duojunrui.blog.service;

import cn.duojunrui.blog.entity.User;

/**
 * @Description: 用户接口
 * @Author: Duojunrui
 * @Date: 2019/8/17 23:55
 */
public interface UserService {

    /**
     * 根据账号和密码检查用户
     * @param account
     * @param password
     * @return
     */
    User checkUser(String account, String password);
}
