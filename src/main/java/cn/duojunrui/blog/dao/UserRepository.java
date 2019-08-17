package cn.duojunrui.blog.dao;

import cn.duojunrui.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/17 23:59
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过账号和密码查询用户
     *
     * @param account
     * @param password
     * @return
     */
    User findByAccountAndPassword(String account, String password);

}
