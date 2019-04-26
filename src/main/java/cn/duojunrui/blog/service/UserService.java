package cn.duojunrui.blog.service;

import cn.duojunrui.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 用户 服务接口
 *
 * @interfaceName: UserService
 * @author: Duojunrui
 * @date: 2019-04-26 23:32
 */

public interface UserService {

    /**
     * 新增、编辑、保存用户
     *
     * @param user
     * @return
     * @date 2019/4/26 23:33
     */
    User saveOrUpdateUser(User user);

    /**
     * 用户注册
     *
     * @param user
     * @return
     * @date 2019/4/26 23:34
     */
    User registerUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     * @date 2019/4/26 23:35
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     * @date 2019/4/26 23:37
     */
    User getUserById(Long id);

    /**
     * 根据用户名进行分页模糊查询
     *
     * @param name
     * @return
     * @date 2019/4/26 23:38
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);
}
