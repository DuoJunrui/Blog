package cn.duojunrui.blog.service.impl;

import cn.duojunrui.blog.dao.UserRepository;
import cn.duojunrui.blog.entity.User;
import cn.duojunrui.blog.service.UserService;
import cn.duojunrui.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户接口实现类
 * @Author: Duojunrui
 * @Date: 2019/8/17 23:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String account, String password) {

        User user = userRepository.findByAccountAndPassword(account, MD5Utils.getMD5(password));

        return user;
    }
}
